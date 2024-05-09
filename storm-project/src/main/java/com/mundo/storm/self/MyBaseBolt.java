package com.mundo.storm.self;

import org.apache.storm.task.OutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.BasicOutputCollector;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseBasicBolt;
import org.apache.storm.topology.base.BaseRichBolt;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.MessageId;
import org.apache.storm.tuple.Tuple;
import org.apache.storm.tuple.Values;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 * Author: 赖传剑
 * Version: 1.0
 * Date: 2018-01-08
 */
public class MyBaseBolt extends BaseRichBolt {

    private OutputCollector collector;

    @Override
    public void prepare(Map stormConf, TopologyContext context, OutputCollector collector) {
        this.collector = collector;
    }

    @Override
    public void execute(Tuple input) {
        Integer value = input.getIntegerByField("value");
        Long ts = input.getLongByField("ts");
        MessageId messageId = input.getMessageId();
        System.out.println("结果 value:" + value);
        collector.emit(new Values(messageId, ts, value));
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer declarer) {
        declarer.declare(new Fields("msgId", "ts", "value"));
    }

}
