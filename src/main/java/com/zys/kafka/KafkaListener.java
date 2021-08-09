package com.zys.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.stereotype.Component;

import javax.xml.transform.Source;
import java.util.Optional;

/**
 * @author zhaoyshan
 * @date 2021/8/8 10:16
 */
@Component
public class KafkaListener {
    @org.springframework.kafka.annotation.KafkaListener(topics={"topicName"},groupId = "test")
    public void listenConsumer(ConsumerRecord<String,String> record){
        System.out.println("消息接收成功");
        System.out.println("value =" + record);
        System.out.println("topic = " + record.topic()) ;
        System.out.println("key = " + record.key());
        System.out.println("value= " + record.value());
    }
}
