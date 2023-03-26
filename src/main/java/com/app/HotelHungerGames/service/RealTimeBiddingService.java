package com.app.HotelHungerGames.service;

import com.app.HotelHungerGames.dto.BidDto;
import com.app.HotelHungerGames.entity.AuctionEntity;

import java.util.List;
import java.util.Optional;

public interface RealTimeBiddingService {
    List<BidDto> getBidHistoryByAuctionId(Long auctionId);
    Optional<BidDto> addBidToAuction(Long auctionId, BidDto bid);
    void updateAuctionPrice(BidDto bid, AuctionEntity auction);

}
