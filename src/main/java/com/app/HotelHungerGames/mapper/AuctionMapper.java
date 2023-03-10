package com.app.HotelHungerGames.mapper;

import com.app.HotelHungerGames.dto.AuctionDto;
import com.app.HotelHungerGames.entity.AuctionEntity;

public class AuctionMapper {

    public static AuctionDto mapAuctionToDto(AuctionEntity auctionEntity) {
        AuctionDto auctionDto = new AuctionDto();
        auctionDto.setAuctionEndDate(auctionEntity.getAuctionEndDate());
        auctionDto.setActualPrice(auctionEntity.getActualPrice());
        auctionDto.setBidHistory(auctionEntity.getBidHistory());
        auctionDto.setId(auctionEntity.getId());
        auctionDto.setStayEntity(auctionEntity.getStayEntity());
        return auctionDto;
    }

    public static AuctionEntity mapAuctionToEntity(AuctionDto auctionDto) {
        AuctionEntity auctionEntity = new AuctionEntity();
        auctionEntity.setId(auctionDto.getId());
        auctionEntity.setAuctionEndDate(auctionDto.getAuctionEndDate());
        auctionEntity.setStayEntity(auctionDto.getStayEntity());
        auctionEntity.setActualPrice(auctionDto.getActualPrice());
        auctionEntity.setBidHistory(auctionDto.getBidHistory());
        return auctionEntity;
    }
}
