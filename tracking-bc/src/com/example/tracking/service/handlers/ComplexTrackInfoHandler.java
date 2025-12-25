package com.example.tracking.service.handlers;


import com.example.tracking.dto.TrackModel;
import com.example.tracking.service.TrackInfoHandler;

public class ComplexTrackInfoHandler implements TrackInfoHandler {

	@Override
	public void handle(TrackModel track) {
		System.out.println("ComplexTrackInfoHandler is started to track the target %s".formatted(track));
	}

}
