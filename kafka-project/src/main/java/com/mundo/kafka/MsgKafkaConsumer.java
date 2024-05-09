package com.mundo.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.util.Collections;
import java.util.Properties;

public class MsgKafkaConsumer implements Runnable {

    private final KafkaConsumer<String, String> consumer;
    private static final String GROUP_ID = "groupA";

    public MsgKafkaConsumer(String topicName) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "192.168.88.62:9092");
        props.put("group.id", GROUP_ID);
        props.put("enable.auto.commit", "true");
        props.put("auto.commit.interval.ms", "1000");
        props.put("session.timeout.ms", "30000");
//        props.put("auto.offset.reset", "earliest");
        props.put("key.deserializer", StringDeserializer.class.getName());
        props.put("value.deserializer", StringDeserializer.class.getName());
        this.consumer = new KafkaConsumer<String, String>(props);
        this.consumer.subscribe(Collections.singletonList(topicName));
    }

    @Override
    public void run() {
        int messageNo = 1;
        try {
            while (true) {
                ConsumerRecords<String, String> msgList = consumer.poll(1000);
                if (null != msgList && msgList.count() > 0) {
                    for (ConsumerRecord<String, String> record : msgList) {
                        //消费100条就打印 ,但打印的数据不一定是这个规律的
                        System.out.println(record.value());
                        messageNo++;
                    }
                } else {
                    Thread.sleep(1000);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            consumer.close();
        }
    }

    public static void main(String args[]) {
        MsgKafkaConsumer test1 = new MsgKafkaConsumer("flume-data");
        Thread thread1 = new Thread(test1);
        thread1.start();
    }
}
