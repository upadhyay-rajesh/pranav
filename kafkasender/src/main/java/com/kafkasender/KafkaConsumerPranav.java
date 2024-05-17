package com.kafkasender;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;

public class KafkaConsumerPranav {

	public static void main(String[] args) {
		Properties p=new Properties();
		p.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		p.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		p.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		p.setProperty(ConsumerConfig.GROUP_ID_CONFIG, "pranavgroup1");
		
		KafkaConsumer<String, String> kc=new KafkaConsumer<String, String>(p);
		
		kc.subscribe(Arrays.asList("pranavtopic1"));
		
		while(true) {
			ConsumerRecords<String, String> cr=kc.poll(Duration.ofMillis(200));
			
			System.out.println(cr.count());
			
			for(ConsumerRecord<String, String> c1:cr) {
				System.out.println(c1.key()+"    "+c1.value());
			}
		}

	}

}















