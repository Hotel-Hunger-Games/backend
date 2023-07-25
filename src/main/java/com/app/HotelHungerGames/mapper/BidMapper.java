package com.app.HotelHungerGames.mapper;

import com.app.HotelHungerGames.dto.BidDto;
import com.app.HotelHungerGames.entity.BidEntity;


public class BidMapper {


    public static BidDto mapBidToDto(BidEntity bidEntity) {
        return new BidDto(
                bidEntity.getId(),
                bidEntity.getAuctionId(),
                bidEntity.getEmail(),
                bidEntity.getPrice(),
                bidEntity.getBidTime());
    }

    public static BidEntity mapBidToEntity(BidDto bidDto) {
        BidEntity bidEntity = new BidEntity();
        bidEntity.setId(bidDto.id());
        bidEntity.setAuctionId(bidDto.auctionId());
        bidEntity.setBidTime(bidDto.bidTime());
        bidEntity.setPrice(bidDto.price());
        bidEntity.setEmail(bidDto.email());
        return bidEntity;
    }
}
