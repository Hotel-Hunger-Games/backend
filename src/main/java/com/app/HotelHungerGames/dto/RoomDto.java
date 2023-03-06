package com.app.HotelHungerGames.dto;

import java.util.List;

public class RoomDto {

    private Long id;
    private Long auctionId;
    private String name;
    private int accommodationCapacity;
    private List<Integer> bedsSizes;

    public RoomDto(Long id, Long auctionId, String name, int accommodationCapacity, List<Integer> bedsSizes) {
        this.id = id;
        this.auctionId = auctionId;
        this.name = name;
        this.accommodationCapacity = accommodationCapacity;
        this.bedsSizes = bedsSizes;
    }
}
