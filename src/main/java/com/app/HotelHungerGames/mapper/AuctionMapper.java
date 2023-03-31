package com.app.HotelHungerGames.mapper;

import com.app.HotelHungerGames.dto.AuctionDto;
import com.app.HotelHungerGames.entity.AuctionEntity;
import com.app.HotelHungerGames.repository.BidRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.Collectors;

public class AuctionMapper {

    public static AuctionDto mapAuctionToDto(AuctionEntity auctionEntity) {
        AuctionDto auctionDto = new AuctionDto();
        auctionDto.setId(auctionEntity.getId());
        auctionDto.setStay(StayMapper.mapStayToDto(auctionEntity.getStayEntity()));
        auctionDto.setAuctionStatus(auctionEntity.getAuctionStatus());
        auctionDto.setStartPrice(auctionEntity.getStartPrice());
        auctionDto.setActualPrice(auctionEntity.getActualPrice());
        auctionDto.setStartDate(auctionEntity.getStartDate());
        auctionDto.setEndDate(auctionEntity.getEndDate());
        auctionDto.setAuctionWinner(auctionEntity.getAuctionWinner());
//        auctionDto.setBidHistory(auctionEntity.getBidHistory()
//                .stream()
//                .map(BidMapper::mapBidToDto)
//                .collect(Collectors.toList()));
        return auctionDto;
    }

    public static AuctionEntity mapAuctionToEntity(AuctionDto auctionDto) {
        AuctionEntity auctionEntity = new AuctionEntity();
        auctionEntity.setStayEntity(StayMapper.mapStayToEntity(auctionDto.getStay()));
        auctionEntity.setAuctionStatus(auctionDto.getAuctionStatus());
        auctionEntity.setStartPrice(auctionDto.getStartPrice());
        auctionEntity.setActualPrice(auctionDto.getActualPrice());
        auctionEntity.setStartDate(auctionDto.getStartDate());
        auctionEntity.setEndDate(auctionDto.getEndDate());
        auctionEntity.setAuctionWinner(auctionDto.getAuctionWinner());
//        auctionEntity.setBidHistory(auctionDto.getBidHistory()
//                .stream()
//                .map(BidMapper::mapBidToEntity)
//                .collect(Collectors.toList()));
        return auctionEntity;
    }
}
