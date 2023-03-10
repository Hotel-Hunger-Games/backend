package com.app.HotelHungerGames.service.impl;

import com.app.HotelHungerGames.dto.AuctionDto;
import com.app.HotelHungerGames.dto.BidDto;
import com.app.HotelHungerGames.service.AuctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RealTimeBiddingService {

    private AuctionService auctionService;

    @Autowired
    public RealTimeBiddingService(AuctionService auctionService) {
        this.auctionService = auctionService;
    }

    public Optional<AuctionDto> addBid(Long auctionId, BidDto bid) {
        Optional<AuctionDto> auction = auctionService.getAuctionById(auctionId);
        if(auction.isPresent()){
            auctionService.addBidToAuction(auctionId, bid);
            return auction;
        } else {
            return Optional.empty();
        }
    }
}
