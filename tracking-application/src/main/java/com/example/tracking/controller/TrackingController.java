package com.example.tracking.controller;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.helper.ddd.OHS;
import com.example.tracking.application.TrackSupportable;
import com.example.tracking.dto.TrackModel;

import generated.Messages.MsgTrack;

@Service
@OHS(publishedLanguage = "project::published-language", service = TrackSupportable.class)
public class TrackingController {
	private final TrackSupportable trackSupportable;

	public TrackingController(TrackSupportable trackSupportable) {
		this.trackSupportable = trackSupportable;
	}

	@KafkaListener(topics = "${tracking-topic}")
	public void listenTrackingMessage(MsgTrack msgTrack) {
		var trackModel = mapMsgTrackToTrackModel(msgTrack);
		trackSupportable.getHandlers().forEach(handler -> handler.handle(trackModel));
	}

	public static TrackModel mapMsgTrackToTrackModel(MsgTrack track) {
		return new TrackModel(track.xPos, track.yPos, track.zPos, track.validity);
	}
}
