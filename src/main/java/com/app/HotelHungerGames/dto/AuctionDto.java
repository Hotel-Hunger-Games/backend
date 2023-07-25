package com.app.HotelHungerGames.dto;

import com.app.HotelHungerGames.entity.AuctionStatus;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

public record AuctionDto(Long id, StayDto stay, AuctionStatus auctionStatus, BigDecimal startPrice, BigDecimal actualPrice, Instant startDate, Instant endDate, String auctionWinner) {

}
