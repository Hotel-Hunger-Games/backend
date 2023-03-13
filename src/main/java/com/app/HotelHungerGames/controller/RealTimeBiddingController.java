package com.app.HotelHungerGames.controller;


import com.app.HotelHungerGames.dto.AuctionDto;
import com.app.HotelHungerGames.dto.BidDto;
import com.app.HotelHungerGames.service.AuctionService;
import com.app.HotelHungerGames.service.RealTimeBiddingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;


@Controller
@CrossOrigin
@RequestMapping("/api/bid")
public class RealTimeBiddingController {

    private final AuctionService auctionService;
    private final RealTimeBiddingService realTimeBiddingService;


    @Autowired
    public RealTimeBiddingController(AuctionService auctionService, RealTimeBiddingService realTimeBiddingService) {
        this.auctionService = auctionService;
        this.realTimeBiddingService = realTimeBiddingService;
    }

    @MessageMapping("/{auctionId}")
    @SendTo("/ws-auction")
    public ResponseEntity<?> addBid(@PathVariable("auctionId") Long auctionId, BidDto bid){
        Optional<AuctionDto> auction = auctionService.getAuctionById(auctionId);
        if(auction.isPresent()){
            realTimeBiddingService.addBidToAuction(auctionId, bid);
            return new ResponseEntity<>(bid, HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping ("/{auctionId}")
    public ResponseEntity<?> getBidHistoryByAuctionId(@PathVariable("auctionId") Long auctionId){
        List<BidDto> bidHistory = realTimeBiddingService.getBidHistoryByAuctionId(auctionId);
        return new ResponseEntity<>(bidHistory, HttpStatus.OK);
    }

}
