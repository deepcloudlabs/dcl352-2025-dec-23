package com.example.hr.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.EventListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.hr.domain.event.HrEvent;

import tools.jackson.databind.ObjectMapper;

@Service
public class HrEventKafkaPublisherService {
	private final KafkaTemplate<String, String> kafkaTemplate;
	private final ObjectMapper objectMapper;
	private final String topicName;

	public HrEventKafkaPublisherService(KafkaTemplate<String, String> kafkaTemplate, ObjectMapper objectMapper,
			@Value("${hrEventTopicName}") String topicName) {
		this.kafkaTemplate = kafkaTemplate;
		this.objectMapper = objectMapper;
		this.topicName = topicName;
	}

	@EventListener
	public void handleHrEvent(HrEvent event) {
		var eventAsJson = objectMapper.writeValueAsString(event);
		kafkaTemplate.send(topicName, eventAsJson);
	}
}
