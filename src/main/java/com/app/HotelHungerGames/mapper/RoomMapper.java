package com.app.HotelHungerGames.mapper;

import com.app.HotelHungerGames.dto.RoomDto;
import com.app.HotelHungerGames.entity.RoomEntity;

import java.util.stream.Collectors;

public class RoomMapper {

    public static RoomDto mapRoomToDto(RoomEntity roomEntity){
        return new RoomDto(
                roomEntity.getId(),
                roomEntity.getName(),
                roomEntity.getAccommodationCapacity(),
                roomEntity.getBedsSizes(),
                null,
                roomEntity.getImages());
    }

    public static RoomEntity mapRoomToEntity(RoomDto roomDto){
        RoomEntity roomEntity = new RoomEntity();
        roomEntity.setId(roomDto.id());
        roomEntity.setName(roomDto.name());
        roomEntity.setAccommodationCapacity(roomDto.accommodationCapacity());
        if(roomDto.stays() != null){
            roomEntity.setStays(roomDto.stays()
                    .stream()
                    .map(StayMapper::mapStayToEntity)
                    .collect(Collectors.toList()));
        }
        roomEntity.setBedsSizes(roomDto.bedsSizes());
        roomEntity.setImages(roomDto.images());
        return roomEntity;
    }
}
