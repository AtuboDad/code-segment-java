package com.mundo.storm.self;

import org.apache.storm.spout.SpoutOutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichSpout;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Values;
import org.apache.storm.utils.Utils;

import java.util.Map;
import java.util.Random;

/**
 * Description:
 * Author: 赖传剑
 * Version: 1.0
 * Date: 2018-01-08
 */
public class MyBaseSpout extends BaseRichSpout {

    private SpoutOutputCollector collector;
    private Random rand;
    private long msgId = 0;

    @Override
    public void open(Map conf, TopologyContext context, SpoutOutputCollector collector) {
        this.collector = collector;
        this.rand = new Random();
    }

    @Override
    public void nextTuple() {
        Utils.sleep(100);
        collector.emit(new Values(rand.nextInt(1000), System.currentTimeMillis()  - (24 * 60 * 60 * 1000), ++msgId), msgId);
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer declarer) {
        declarer.declare(new Fields("value", "ts", "msgid"));
    }
}
