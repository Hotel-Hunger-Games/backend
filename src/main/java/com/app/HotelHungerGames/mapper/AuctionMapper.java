package com.app.HotelHungerGames.mapper;

import com.app.HotelHungerGames.dto.AuctionDto;
import com.app.HotelHungerGames.entity.AuctionEntity;

import java.util.stream.Collectors;

public class AuctionMapper {

    public static AuctionDto mapAuctionToDto(AuctionEntity auctionEntity) {
        AuctionDto auctionDto = new AuctionDto();
        auctionDto.setId(auctionEntity.getId());
        auctionDto.setStayDto(StayMapper.mapStayToDto(auctionEntity.getStayEntity()));
        auctionDto.setStartPrice(auctionEntity.getStartPrice());
        auctionDto.setActualPrice(auctionEntity.getActualPrice());
        auctionDto.setStartDate(auctionEntity.getAuctionsStartDate());
        auctionDto.setEndDate(auctionEntity.getAuctionEndDate());
        auctionDto.setBidHistory(auctionEntity.getBidHistory()
                .stream()
                .map(BidMapper::mapBidToDto)
                .collect(Collectors.toList()));
        return auctionDto;
    }

    public static AuctionEntity mapAuctionToEntity(AuctionDto auctionDto) {
        AuctionEntity auctionEntity = new AuctionEntity();
        auctionEntity.setStayEntity(StayMapper.mapStayToEntity(auctionDto.getStayDto()));
        auctionEntity.setStartPrice(auctionDto.getStartPrice());
        auctionEntity.setActualPrice(auctionDto.getActualPrice());
        auctionEntity.setAuctionsStartDate(auctionDto.getStartDate());
        auctionEntity.setAuctionEndDate(auctionDto.getEndDate());
//        auctionEntity.setBidHistory(auctionDto.getBidHistory()
//                .stream()
//                .map(BidMapper::mapBidToEntity)
//                .collect(Collectors.toList()));
        return auctionEntity;
    }
}
