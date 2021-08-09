package com.zys.kafka;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * @author zhaoyshan
 * @date 2021/8/8 10:20
 */

//@Component
//public class Producer {
//    @Autowired
//    private KafkaTemplate kafkaTemplate;
//
//    public void producerr() {
//        for (int i = 0; i < 10; i++) {
//            kafkaTemplate.send(new ProducerRecord<String, String>("my-topic", "hello" + i, "java" + i));
//        }
//    }
//}
