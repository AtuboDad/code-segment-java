package com.mundo.flink.window;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.flink.api.common.eventtime.SerializableTimestampAssigner;
import org.apache.flink.api.common.eventtime.WatermarkStrategy;
import org.apache.flink.api.common.functions.CoGroupFunction;
import org.apache.flink.api.common.functions.RichMapFunction;
import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.functions.KeySelector;
import org.apache.flink.api.java.tuple.Tuple1;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.api.java.utils.ParameterTool;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.TimeCharacteristic;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.ProcessFunction;
import org.apache.flink.streaming.api.functions.timestamps.BoundedOutOfOrdernessTimestampExtractor;
import org.apache.flink.streaming.api.functions.windowing.AllWindowFunction;
import org.apache.flink.streaming.api.windowing.assigners.TumblingEventTimeWindows;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.apache.flink.streaming.api.windowing.windows.TimeWindow;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer;
import org.apache.flink.util.Collector;
import org.apache.flink.util.OutputTag;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.Duration;
import java.util.Properties;

public class OrderJoinAdv {

    public static void main(String[] args) throws Exception {
        ParameterTool parameters = ParameterTool.fromPropertiesFile(args[0]);
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setParallelism(1);
        //使用EventTime作为时间标准
        env.setStreamTimeCharacteristic(TimeCharacteristic.EventTime);

        Properties kafkaProps = new Properties();
        kafkaProps.setProperty("bootstrap.servers", "192.168.88.62:9092");
        kafkaProps.setProperty("group.id", "test-consumer-group");
        kafkaProps.setProperty("zookeeper.connect", "192.168.88.62:2181");
        kafkaProps.setProperty("topic", "data-main");
        FlinkKafkaConsumer<String> kafkaConsumerMain = new FlinkKafkaConsumer<>("data-main", new SimpleStringSchema(), kafkaProps);
        kafkaProps.setProperty("topic", "data-detail");
        FlinkKafkaConsumer<String> kafkaConsumerDetail = new FlinkKafkaConsumer<>("data-detail", new SimpleStringSchema(), kafkaProps);

        int delaySeconds = 2;
        int windowSize = 5;
        DataStream<String> orderMainLinesDataStream = env.addSource(kafkaConsumerMain).assignTimestampsAndWatermarks(WatermarkStrategy
                .forBoundedOutOfOrderness(Duration.ofSeconds(delaySeconds)));
        DataStream<String> orderDetailLinesDataStream = env.addSource(kafkaConsumerDetail).assignTimestampsAndWatermarks(WatermarkStrategy
                .forBoundedOutOfOrderness(Duration.ofSeconds(delaySeconds)));

        // 对主数据进行解析
        SingleOutputStreamOperator<OrderMain> orderMainDataStream = orderMainLinesDataStream.process(new ProcessFunction<String, OrderMain>() {
            @Override
            public void processElement(String line, Context ctx, Collector<OrderMain> out) throws Exception {
                // flatMap + filter
                try {
                    JSONObject jsonObject = JSON.parseObject(line);
                    String type = jsonObject.getString("type");
                    if (type.equals("INSERT") || type.equals("UPDATE")) {
                        JSONArray jsonArray = jsonObject.getJSONArray("data");
                        for (int i = 0; i < jsonArray.size(); i++) {
                            OrderMain orderMain = jsonArray.getObject(i, OrderMain.class);
                            orderMain.setType(type); //设置操作类型
                            out.collect(orderMain);
                        }
                    }
                } catch (Exception e) {
                    //e.printStackTrace();
                    //记录错误的数据
                }
            }
        });

        // 对业务数据进行解析
        SingleOutputStreamOperator<OrderDetail> orderDetailDataStream = orderDetailLinesDataStream.process(new ProcessFunction<String, OrderDetail>() {


            @Override

            public void processElement(String line, Context ctx, Collector<OrderDetail> out) throws Exception {
            // flatMap + filter
            try {
                JSONObject jsonObject = JSON.parseObject(line);
                String type = jsonObject.getString("type");
                if (type.equals("INSERT") || type.equals("UPDATE")) {
                    JSONArray jsonArray = jsonObject.getJSONArray("data");
                    for (int i = 0; i < jsonArray.size(); i++) {
                        OrderDetail orderDetail = jsonArray.getObject(i, OrderDetail.class);
                        orderDetail.setType(type); //设置操作类型
                        out.collect(orderDetail);
                    }
                }
            } catch (Exception e) {
                //e.printStackTrace();
                //记录错误的数据
            }
            }

        });

        // 定义迟到侧流输出的Tag
        OutputTag<OrderDetail> lateTag = new OutputTag<OrderDetail>("late-date") {};

        // 对左表进行单独划分窗口，窗口的长度与cogroup的窗口长度一样
        SingleOutputStreamOperator<OrderDetail> orderDetailWithWindow = orderDetailDataStream.windowAll(TumblingEventTimeWindows.of(Time.seconds(windowSize)))
                .sideOutputLateData(lateTag) // 将迟到的数据打上Tag
                .apply(new AllWindowFunction<OrderDetail, OrderDetail, TimeWindow>() {
                    @Override
                    public void apply(TimeWindow window, Iterable<OrderDetail> values, Collector<OrderDetail> out) throws Exception {
                        for (OrderDetail value : values) {
                            out.collect(value);
                        }
                    }
                });

        // 获取迟到的数据
        DataStream<OrderDetail> lateOrderDetailStream = orderDetailWithWindow.getSideOutput(lateTag);

        // 应为orderDetail表的数据迟到数据不是很多，没必要使用异步IO，直接使用RichMapFunction
        SingleOutputStreamOperator<Tuple2<OrderDetail, OrderMain>> lateOrderDetailAndOrderMain = lateOrderDetailStream.map(new RichMapFunction<OrderDetail, Tuple2<OrderDetail, OrderMain>>() {

            @Override

            public Tuple2<OrderDetail, OrderMain> map(OrderDetail detail) throws Exception {
                return Tuple2.of(detail, null);
            }

        });

        // Left Out JOIN，并且将订单明细表作为左表
        DataStream<Tuple2<OrderDetail, OrderMain>> joined = orderDetailWithWindow.coGroup(orderMainDataStream)
                .where(new KeySelector<OrderDetail, Long>() {
                    @Override
                    public Long getKey(OrderDetail value) throws Exception {
                        return value.getOrder_id();
                    }
                })
                .equalTo(new KeySelector<OrderMain, Long>() {
                    @Override
                    public Long getKey(OrderMain value) throws Exception {
                        return value.getOid();
                    }
                })
                .window(TumblingEventTimeWindows.of(Time.seconds(windowSize)))
                .apply(new CoGroupFunction<OrderDetail, OrderMain, Tuple2<OrderDetail, OrderMain>>() {
                    @Override
                    public void coGroup(Iterable<OrderDetail> first, Iterable<OrderMain> second, Collector<Tuple2<OrderDetail, OrderMain>> out) throws Exception {
                        for (OrderDetail orderDetail : first) {
                            boolean isJoined = false;
                            for (OrderMain orderMain : second) {
                                out.collect(Tuple2.of(orderDetail, orderMain));
                                isJoined = true;
                            }
                            if (!isJoined) {
                                out.collect(Tuple2.of(orderDetail, null));
                            }
                        }
                    }
                });

        joined.union(lateOrderDetailAndOrderMain).map(new RichMapFunction<Tuple2<OrderDetail, OrderMain>, Tuple2<OrderDetail, OrderMain>>() {
            private transient Connection connection;
            @Override
            public void open(Configuration parameters) throws Exception {
                // 可以创建数据库连接
                connection = DriverManager.getConnection("jdbc:mysql://172.16.100.100:3306/doit?characterEncoding=UTF-8", "root", "123456");
            }

            @Override
            public Tuple2<OrderDetail, OrderMain> map(Tuple2<OrderDetail, OrderMain> tp) throws Exception {
                // 每个关联上订单主表的数据，就查询书库
                if (tp.f1 == null) {
                    tp.f1 = queryOrderMainFromMySQL(tp.f0.getOrder_id(), connection);
                }
                return tp;
            }

            @Override
            public void close() throws Exception {
                //关闭数据库连接
                connection.close();
            }
        }).print();
        env.execute();
    }

    private static OrderMain queryOrderMainFromMySQL(Long order_id, Connection connection) throws Exception {
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * ordermain WHERE oid = ?");
        // 设置参数
        preparedStatement.setLong(1, order_id);
        // 执行查询
        ResultSet resultSet = preparedStatement.executeQuery();
        // 取出结果
        long oid = resultSet.getLong("oid");
        Date createTime = resultSet.getDate("create_time");
        double totalMoney = resultSet.getDouble("total_money");
        int status = resultSet.getInt("status");

        OrderMain orderMain = new OrderMain();
        orderMain.setOid(oid);
        orderMain.setStatus(status);
        return orderMain;
    }

}