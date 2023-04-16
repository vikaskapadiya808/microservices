package com.kafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaMessageConsumer {

	@KafkaListener(topics = {"messgeTopic"},autoStartup = "true",groupId = "order")
	public void getMessage(String message) {
		System.out.println(message);

	}

}
