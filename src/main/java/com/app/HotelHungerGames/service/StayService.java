package com.app.HotelHungerGames.service;

import com.app.HotelHungerGames.dto.StayDto;

import java.util.Optional;

public interface StayService {
    StayDto addStay(StayDto auctionBid);
    Optional<StayDto> getStayById(Long id);
}
