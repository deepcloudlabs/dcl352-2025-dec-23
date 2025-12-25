package com.example.tracking.dto;

import com.example.helper.hexagonal.DTO;

@DTO
public record TrackModel(int xPos,int yPos,int zPos,boolean validity) 
{}
