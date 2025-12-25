package com.example.hr.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import com.example.hr.service.HrEventWebSocketPublisherService;
import com.example.hr.service.HrWebSocketService;
import com.example.hr.service.HrWebsocketController;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer{
	private final HrEventWebSocketPublisherService hrEventWebSocketPublisherService;
	private final HrWebsocketController hrWebsocketController;
	
	public WebSocketConfig(HrEventWebSocketPublisherService hrEventWebSocketPublisherService,
			HrWebsocketController hrWebsocketController) {
		this.hrEventWebSocketPublisherService = hrEventWebSocketPublisherService;
		this.hrWebsocketController = hrWebsocketController;
	}

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		registry.addHandler(hrEventWebSocketPublisherService, "/hr-events")
		        .setAllowedOrigins("*");
		registry.addHandler(hrWebsocketController, "/hr-commands")
		        .setAllowedOrigins("*");
	}

}