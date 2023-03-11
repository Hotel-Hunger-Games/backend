package com.app.HotelHungerGames.mapper;

import com.app.HotelHungerGames.dto.AuctionDto;
import com.app.HotelHungerGames.entity.AuctionEntity;

import java.util.stream.Collectors;

public class AuctionMapper {

    public static AuctionDto mapAuctionToDto(AuctionEntity auctionEntity) {
        AuctionDto auctionDto = new AuctionDto();
        auctionDto.setAuctionEndDate(auctionEntity.getAuctionEndDate());
        auctionDto.setActualPrice(auctionEntity.getActualPrice());
        auctionDto.setBidHistory(auctionEntity.getBidHistory()
                .stream()
                .map(BidMapper::mapBidToDto)
                .collect(Collectors.toList()));
        auctionDto.setId(auctionEntity.getId());
        auctionDto.setStayDto(StayMapper.mapStayToDto(auctionEntity.getStayEntity()));
        auctionDto.setStartPrice(auctionEntity.getStartPrice());
        return auctionDto;
    }

    public static AuctionEntity mapAuctionToEntity(AuctionDto auctionDto) {
        AuctionEntity auctionEntity = new AuctionEntity();
        auctionEntity.setId(auctionDto.getId());
        auctionEntity.setAuctionEndDate(auctionDto.getAuctionEndDate());
        auctionEntity.setStayEntity(StayMapper.mapStayToEntity(auctionDto.getStayDto()));
        auctionEntity.setActualPrice(auctionDto.getActualPrice());
        auctionEntity.setBidHistory(auctionDto.getBidHistory()
                .stream()
                .map(BidMapper::mapBidToEntity)
                .collect(Collectors.toList()));
        auctionEntity.setStartPrice(auctionDto.getStartPrice());
        return auctionEntity;
    }
}
