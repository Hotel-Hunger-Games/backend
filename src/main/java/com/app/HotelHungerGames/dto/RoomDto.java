package com.app.HotelHungerGames.dto;

import java.util.List;

public record RoomDto(Long id, String name, int accommodationCapacity, List<Integer> bedsSizes, List<StayDto> stays, List<String> images) {
    @Override
    public String toString() {
        return "RoomDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", accommodationCapacity=" + accommodationCapacity +
                ", bedsSizes=" + bedsSizes +
                ", stays=" + stays +
                ", images=" + images +
                '}';
    }


}
