package com.app.HotelHungerGames.mapper;

import com.app.HotelHungerGames.dto.BidDto;
import com.app.HotelHungerGames.entity.BidEntity;


public class BidMapper {


    public static BidDto mapBidToDto(BidEntity bidEntity) {
        BidDto bidDto = new BidDto();
        bidDto.setBidTime(bidEntity.getBidTime());
        bidDto.setAuctionId(bidEntity.getAuction().getId());
        bidDto.setEmail(bidEntity.getEmail());
        bidDto.setId(bidEntity.getId());
        bidDto.setPrice(bidEntity.getPrice());
        return bidDto;
    }

    public static BidEntity mapBidToEntity(BidDto bidDto) {
        BidEntity bidEntity = new BidEntity();
        bidEntity.setBidTime(bidDto.getBidTime());
//        bidEntity.setAuction(AuctionMapper.mapAuctionToEntity(bidDto.getAuction()));
        bidEntity.setPrice(bidDto.getPrice());
        bidEntity.setId(bidDto.getId());
        bidEntity.setEmail(bidDto.getEmail());
        return bidEntity;
    }
}
