package com.app.HotelHungerGames.service;

import com.app.HotelHungerGames.dto.BidDto;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface BidService {
    BidDto addBid(BidDto auctionBid);
    Optional<BidDto> getBidById(Long id);
}
