package com.mundo.storm.self;

import org.apache.storm.Config;
import org.apache.storm.LocalCluster;
import org.apache.storm.topology.TopologyBuilder;
import org.apache.storm.utils.Utils;

/**
 * Description:
 * Author: 赖传剑
 * Version: 1.0
 * Date: 2018-01-08
 */
public class BaseApp {

    private static final String BASE_SPOUT_ID = "sentence-spout";
    private static final String SPLIT_BOLT_ID = "base-bolt";
    private static final String TOPOLOGY_NAME = "base-topology";

    public static void main(String[] args) {
        MyBaseSpout baseSpout = new MyBaseSpout();
        MyBaseBolt baseBolt = new MyBaseBolt();

        //创建了一个TopologyBuilder实例
        TopologyBuilder builder = new TopologyBuilder();
        builder.setSpout(BASE_SPOUT_ID, baseSpout, 2);
        builder.setBolt(SPLIT_BOLT_ID, baseBolt, 2).setNumTasks(4).shuffleGrouping(BASE_SPOUT_ID);

        Config config = new Config();
        LocalCluster cluster = new LocalCluster();

        //本地提交
        cluster.submitTopology(TOPOLOGY_NAME, config, builder.createTopology());

        Utils.sleep(5000);
        cluster.killTopology(TOPOLOGY_NAME);
        cluster.shutdown();
    }

}
