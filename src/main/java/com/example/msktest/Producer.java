package com.example.msktest;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
public class Producer {

    private static String TOPIC_NAME = "msk_test_topic";


    public Producer() {
        this.run();
    }

    private void run() {

        System.out.println("produce start : -------------------------------------------------------");

        Properties configs = new Properties();
        configs.put("bootstrap.servers", "b-2.mostestmsk.fc3yls.c2.kafka.ap-northeast-2.amazonaws.com:9094,b-1.mostestmsk.fc3yls.c2.kafka.ap-northeast-2.amazonaws.com:9094\t");
        configs.put("acks", "all");
        configs.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        configs.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(configs);

        for (int i = 0; i < 5; i++) {
            System.out.println("-------------------------------------------------------");
            String message = "hello " + i;
            producer.send(new ProducerRecord<String, String>(TOPIC_NAME, message));
            System.out.println("--------------------" + message);
        }

        producer.flush();
        producer.close();
    }
}
