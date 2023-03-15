package com.app.HotelHungerGames.mapper;

import com.app.HotelHungerGames.dto.StayDto;
import com.app.HotelHungerGames.entity.StayEntity;

public class StayMapper {

    public static StayDto mapStayToDto(StayEntity stayEntity) {
        StayDto stayDto = new StayDto();
        stayDto.setId(stayEntity.getId());
        stayDto.setUserId(stayEntity.getUserId());
        stayDto.setAuctionId(stayEntity.getAuctionEntity().getId());
        stayDto.setRoomDto(RoomMapper.mapRoomToDto(stayEntity.getRoomEntity()));
        stayDto.setReservationStartDate(stayEntity.getReservationStartDate());
        stayDto.setReservationEndDate(stayEntity.getReservationEndDate());
        return stayDto;
    }

    public static StayEntity mapStayToEntity(StayDto stayDto){
        StayEntity stayEntity = new StayEntity();
        stayEntity.setUserId(stayDto.getUserId());
        stayEntity.setReservationStartDate(stayDto.getReservationStartDate());
        stayEntity.setReservationEndDate(stayDto.getReservationEndDate());
        stayEntity.setRoomEntity(RoomMapper.mapRoomToEntity(stayDto.getRoomDto()));
        return stayEntity;
    }
}
