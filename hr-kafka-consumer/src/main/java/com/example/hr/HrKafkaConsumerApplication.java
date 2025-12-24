package com.example.hr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
public class HrKafkaConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrKafkaConsumerApplication.class, args);
	}

	@KafkaListener(topics = "${hrEventTopicName}")
	public void listenHrEvents(String hrEvent) {
		System.out.println(hrEvent);
	}
}
