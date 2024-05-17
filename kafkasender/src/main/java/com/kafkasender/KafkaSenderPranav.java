package com.kafkasender;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

public class KafkaSenderPranav {

	public static void main(String[] args) {
		Properties p=new Properties();
		p.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		p.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		p.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		
		KafkaProducer<String, String> ks=new KafkaProducer<String, String>(p);
		
		ProducerRecord<String, String> pr=new ProducerRecord<String, String>("pranavtopic1", "Hello Pranav i am comong from java");
		
		ks.send(pr);
		ks.flush();
		ks.close();
	}

}
