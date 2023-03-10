package com.app.HotelHungerGames.service;

import com.app.HotelHungerGames.dto.BidDto;
import org.springframework.http.ResponseEntity;

public interface BidService {
    BidDto addBid(Long roomId, BidDto auctionBid);
}
