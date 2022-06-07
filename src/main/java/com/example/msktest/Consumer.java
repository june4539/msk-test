//package com.example.msktest;
//
//import org.apache.kafka.clients.consumer.ConsumerRecord;
//import org.apache.kafka.clients.consumer.ConsumerRecords;
//import org.apache.kafka.clients.consumer.KafkaConsumer;
//import org.springframework.stereotype.Service;
//
//import java.util.Arrays;
//import java.util.Properties;
//
//@Service
//public class Consumer {
//    private static String TOPIC_NAME = "msk_test_topic";
//
//    public Consumer() {
//        this.run();
//    }
//
//    private void run() {
//        Properties configs = new Properties();
//        configs.put("bootstrap.servers", "b-1.mosdevmsk.1hbmvx.c2.kafka.ap-northeast-2.amazonaws.com:9094,b-2.mosdevmsk.1hbmvx.c2.kafka.ap-northeast-2.amazonaws.com:9094");
//        configs.put("group.id", "test_group");
//        configs.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
//        configs.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
//
//        KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(configs);
//
//        consumer.subscribe(Arrays.asList(TOPIC_NAME));
//
//        while (true) {
//            ConsumerRecords<String, String> records = consumer.poll(500);
//            for (ConsumerRecord<String, String> record : records) {
//                System.out.println("consume: " + record.value());
//            }
//        }
//    }
//}
