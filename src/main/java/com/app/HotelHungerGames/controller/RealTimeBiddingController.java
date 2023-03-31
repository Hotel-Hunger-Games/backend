package com.app.HotelHungerGames.controller;


import com.app.HotelHungerGames.dto.AuctionDto;
import com.app.HotelHungerGames.dto.BidDto;
import com.app.HotelHungerGames.service.RealTimeBiddingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;


@Controller
@CrossOrigin
public class RealTimeBiddingController {

    private final RealTimeBiddingService realTimeBiddingService;


    @Autowired
    public RealTimeBiddingController(RealTimeBiddingService realTimeBiddingService) {
        this.realTimeBiddingService = realTimeBiddingService;;
    }

    @MessageMapping("/rt-auction/bid/{auctionId}")
    @SendTo("/rt-product/auction-updates/{auctionId}")
    public ResponseEntity<?> addBid(@DestinationVariable("auctionId") Long auctionId, BidDto bid){
        Optional<BidDto> bidDto = realTimeBiddingService.addBidToAuction(auctionId, bid);
        if(bidDto.isPresent()){
            return new ResponseEntity<>(bid, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(bid, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/test")
    public ResponseEntity<?> test() {
        System.out.println("dupa");
        BidDto bidDto = new BidDto();
        bidDto.setPrice(BigDecimal.valueOf(10));
        bidDto.setEmail("test");
        Optional<BidDto> bid = realTimeBiddingService.addBidToAuction(5L, bidDto);
        System.out.println(bid);
        if(bid.isPresent()){
            return new ResponseEntity<>(bid, HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping ("/bid/{auctionId}")
    public ResponseEntity<?> getBidHistoryByAuctionId(@PathVariable("auctionId") Long auctionId){
        List<BidDto> bidHistory = realTimeBiddingService.getBidHistoryByAuctionId(auctionId);
        return new ResponseEntity<>(bidHistory, HttpStatus.OK);
    }



}
