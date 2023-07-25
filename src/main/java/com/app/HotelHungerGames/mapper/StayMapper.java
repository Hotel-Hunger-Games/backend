package com.app.HotelHungerGames.mapper;

import com.app.HotelHungerGames.dto.StayDto;
import com.app.HotelHungerGames.entity.StayEntity;

public class StayMapper {

    public static StayDto mapStayToDto(StayEntity stayEntity) {
        return new StayDto(
                stayEntity.getId(),
                stayEntity.getUserId(),
                stayEntity.getAuctionEntity().getId(),
                stayEntity.getReservationStartDate(),
                stayEntity.getReservationEndDate(),
                RoomMapper.mapRoomToDto(stayEntity.getRoomEntity()));
    }

    public static StayEntity mapStayToEntity(StayDto stayDto){
        StayEntity stayEntity = new StayEntity();
        stayEntity.setUserId(stayDto.userId());
        stayEntity.setReservationStartDate(stayDto.reservationStartDate());
        stayEntity.setReservationEndDate(stayDto.reservationEndDate());
        stayEntity.setRoomEntity(RoomMapper.mapRoomToEntity(stayDto.roomDto()));
        return stayEntity;
    }
}
