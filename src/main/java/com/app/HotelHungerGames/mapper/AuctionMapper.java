package com.app.HotelHungerGames.mapper;

import com.app.HotelHungerGames.dto.AuctionDto;
import com.app.HotelHungerGames.entity.AuctionEntity;

public class AuctionMapper {

    public static AuctionDto mapAuctionToDto(AuctionEntity auctionEntity) {
        return new AuctionDto(
                auctionEntity.getId(),
                StayMapper.mapStayToDto(auctionEntity.getStayEntity()),
                auctionEntity.getAuctionStatus(),
                auctionEntity.getStartPrice(),
                auctionEntity.getActualPrice(),
                auctionEntity.getStartDate(),
                auctionEntity.getEndDate(),
                auctionEntity.getAuctionWinner()
                );
    }

    public static AuctionEntity mapAuctionToEntity(AuctionDto auctionDto) {
        AuctionEntity auctionEntity = new AuctionEntity();
        auctionEntity.setStayEntity(StayMapper.mapStayToEntity(auctionDto.stay()));
        auctionEntity.setAuctionStatus(auctionDto.auctionStatus());
        auctionEntity.setStartPrice(auctionDto.startPrice());
        auctionEntity.setActualPrice(auctionDto.actualPrice());
        auctionEntity.setStartDate(auctionDto.startDate());
        auctionEntity.setEndDate(auctionDto.endDate());
        auctionEntity.setAuctionWinner(auctionDto.auctionWinner());
//        auctionEntity.setBidHistory(auctionDto.getBidHistory()
//                .stream()
//                .map(BidMapper::mapBidToEntity)
//                .collect(Collectors.toList()));
        return auctionEntity;
    }
}
