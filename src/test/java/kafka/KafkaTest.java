package kafka;

import com.zys.ApplicationMain;
import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.clients.producer.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Properties;

/**
 * @author zhaoyshan
 * @date 2021/8/1 10:07
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationMain.class)
public class KafkaTest {
    @Autowired
    private KafkaTemplate kafkaTemplate;


    @Test
    public void tempLateTest(){
        kafkaTemplate.send("topicName","hello");
    }


    @Test
    public void consumerTest() {
        Properties props = new Properties();
        //连接的连接的主机/集群
        props.put("bootstrap.servers", "localhost:9092");
        //设置组
        props.put("group.id", "test");
        //offect 自动提交
        props.put("enable.auto.commit", "true");
        //自动提交的时间
        props.put("auto.commit.interval.ms", "1000");
        //设置序列化
        props.put("key.deserializer",
                "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer",
                "org.apache.kafka.common.serialization.StringDeserializer");
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
        consumer.subscribe(Arrays.asList("topicName"));
        while (true) {
            ConsumerRecords<String, String> records =
                    consumer.poll(100);
            for (ConsumerRecord<String, String> record : records)
                System.out.printf("offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value());

            //当 offset设置为手动提交 手动提交
           /* consumer.commitAsync(new OffsetCommitCallback() {
                @Override
                public void onComplete(Map<TopicPartition, OffsetAndMetadata> map, Exception e) {
                    if(e!= null){
                        System.out.println("commit fail");
                    }
                }
            });*/
        }
    }

    @Test
    public void croducerTest(){
        Properties props = new Properties();
        //kafka 集群，broker-list
        props.put("bootstrap.servers", "localhost:9092");
        props.put("acks", "all");
        //重试次数
        props.put("retries", 1);
        //批次大小
        props.put("batch.size", 16384);
        //等待时间
        props.put("linger.ms", 1);
        //RecordAccumulator 缓冲区大小
        props.put("buffer.memory", 33554432);
        props.put("key.serializer",
                "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer",
                "org.apache.kafka.common.serialization.StringSerializer");
        Producer<String, String> producer = new
                KafkaProducer<>(props);
        producer.send(new ProducerRecord<>("topicName","hellow"));
        producer.close();
    }

    @Test
    public void producerCallBackTest(){
        Properties props = new Properties();
        //kafka 集群，broker-list
        props.put("bootstrap.servers", "localhost:9092");
        props.put("acks", "all");
        //重试次数
        props.put("retries", 1);
        //批次大小
        props.put("batch.size", 16384);
        //等待时间
        props.put("linger.ms", 1);
        //RecordAccumulator 缓冲区大小
        props.put("buffer.memory", 33554432);
        props.put("key.serializer",
                "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer",
                "org.apache.kafka.common.serialization.StringSerializer");
        Producer<String, String> producer = new
                KafkaProducer<>(props);
        producer.send(new ProducerRecord<>("topicName", "hellow"), new Callback() {
            @Override
            public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                if (e != null){
                    System.out.println("err ！= null");
                }
                else{
                    System.out.println("success");
                }
            }
        });
        producer.close();
    }
}

