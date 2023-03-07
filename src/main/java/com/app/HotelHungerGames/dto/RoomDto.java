package com.app.HotelHungerGames.dto;

import com.app.HotelHungerGames.entity.StayEntity;
import java.util.List;

public class RoomDto {

    private Long id;
    private String name;
    private int accommodationCapacity;
    private List<Integer> bedsSizes;
    private List<StayEntity> stays;

    public RoomDto(Long id, String name, int accommodationCapacity, List<Integer> bedsSizes, List<StayEntity> stays) {
        this.id = id;
        this.name = name;
        this.accommodationCapacity = accommodationCapacity;
        this.bedsSizes = bedsSizes;
        this.stays = stays;
    }
}
