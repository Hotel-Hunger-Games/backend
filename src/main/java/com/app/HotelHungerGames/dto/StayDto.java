package com.app.HotelHungerGames.dto;

import java.time.Instant;

public record StayDto(Long id, String userId, Long auctionId, Instant reservationStartDate, Instant reservationEndDate, RoomDto roomDto) {

}
