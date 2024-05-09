package com.mundo.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;
import java.util.Random;

public class MsgKafkaProducer extends Thread {

    private final KafkaProducer<Integer, String> producer;
    private final String topic;

    public MsgKafkaProducer(String topic) {

        Properties props = new Properties();
        props.put("metadata.broker.list", "192.168.88.62:9092");
        props.put("bootstrap.servers", "192.168.88.62:9092");
        props.put("retries", 0);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        producer = new KafkaProducer<>(props);
        this.topic = topic;
    }

    @Override
    public void run() {
        Random random = new Random();
        while (true) {
            for (int i = 0; i < 1; i++) {
                int messageNo = random.nextInt(100);
                String messageStr = "Message" + messageNo + " " + messageNo;
                System.out.println("Send:" + messageStr);
                producer.send(new ProducerRecord<>(topic, messageStr));
            }
            try {
                Thread.sleep(11000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        MsgKafkaProducer producerThread = new MsgKafkaProducer("flume-data");
        producerThread.start();
    }

}
