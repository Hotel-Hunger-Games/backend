package com.app.HotelHungerGames.dto;


import java.math.BigDecimal;
import java.time.Instant;

public record BidDto(Long id, Long auctionId, String email, BigDecimal price, Instant bidTime) {
}
