package com.app.HotelHungerGames.mapper;

import com.app.HotelHungerGames.dto.AuctionDto;
import com.app.HotelHungerGames.dto.RoomDto;
import com.app.HotelHungerGames.dto.StayDto;
import com.app.HotelHungerGames.entity.StayEntity;

public class StayMapper {

    public static StayDto mapStayToDto(StayEntity stayEntity) {
        StayDto stayDto = new StayDto();
        stayDto.setId(stayEntity.getId());
        stayDto.setUserId(stayEntity.getUserId());
        stayDto.setAuctionDto(AuctionMapper.mapAuctionToDto(stayEntity.getAuctionEntity()));
        stayDto.setAuctionsStartDate(stayEntity.getAuctionsStartDate());
        stayDto.setReservationStartDate(stayEntity.getReservationStartDate());
        stayDto.setReservationEndDate(stayEntity.getReservationEndDate());
        stayDto.setRoomDto(RoomMapper.mapRoomToDto(stayEntity.getRoomEntity()));
        return stayDto;
    }

    public static StayEntity mapStayToEntity(StayDto stayDto){
        StayEntity stayEntity = new StayEntity();
        stayEntity.setId(stayDto.getId());
        stayEntity.setUserId(stayDto.getUserId());
        stayEntity.setReservationStartDate(stayDto.getReservationStartDate());
        stayEntity.setReservationEndDate(stayDto.getReservationEndDate());
        stayEntity.setAuctionsStartDate(stayDto.getAuctionsStartDate());
        stayEntity.setRoomEntity(RoomMapper.mapRoomToEntity(stayDto.getRoomDto()));
        stayEntity.setAuctionEntity(AuctionMapper.mapAuctionToEntity(stayDto.getAuctionDto()));
        return stayEntity;
    }
}
