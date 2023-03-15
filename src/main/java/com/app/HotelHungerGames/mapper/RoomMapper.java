package com.app.HotelHungerGames.mapper;

import com.app.HotelHungerGames.dto.RoomDto;
import com.app.HotelHungerGames.entity.RoomEntity;

import java.util.stream.Collectors;

public class RoomMapper {

    public static RoomDto mapRoomToDto(RoomEntity roomEntity){
        RoomDto roomDto = new RoomDto();
        roomDto.setId(roomEntity.getId());
        roomDto.setAccommodationCapacity(roomEntity.getAccommodationCapacity());
        roomDto.setBedsSizes(roomEntity.getBedsSizes());
        roomDto.setImages(roomEntity.getImages());
        roomDto.setName(roomEntity.getName());
//        roomDto.setStays(roomEntity.getStays()
//                .stream()
//                .map(StayMapper::mapStayToDto)
//                .collect(Collectors.toList()));
        return roomDto;
    }

    public static RoomEntity mapRoomToEntity(RoomDto roomDto){
        RoomEntity roomEntity = new RoomEntity();
        roomEntity.setId(roomDto.getId());
        roomEntity.setName(roomDto.getName());
        roomEntity.setAccommodationCapacity(roomDto.getAccommodationCapacity());
        if(roomDto.getStays() != null){
            roomEntity.setStays(roomDto.getStays()
                    .stream()
                    .map(StayMapper::mapStayToEntity)
                    .collect(Collectors.toList()));
        }
        roomEntity.setBedsSizes(roomDto.getBedsSizes());
        roomEntity.setImages(roomDto.getImages());
        return roomEntity;
    }
}
