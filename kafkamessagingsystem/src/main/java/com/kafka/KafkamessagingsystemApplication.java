package com.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.kafka.producer.KafkaMessageProducer;

@SpringBootApplication
public class KafkamessagingsystemApplication {

	public static void main(String[] args) {
	ApplicationContext context=	SpringApplication.run(KafkamessagingsystemApplication.class, args);
	
	KafkaMessageProducer kafkaMessageProducer=context.getBean(KafkaMessageProducer.class);
	kafkaMessageProducer.sendMessage("Satya is working on kafka");

	System.out.println("kafka message published");
	}

}
