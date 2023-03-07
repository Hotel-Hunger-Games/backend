package com.app.HotelHungerGames.dto;

import com.app.HotelHungerGames.entity.AuctionEntity;
import com.app.HotelHungerGames.entity.RoomEntity;
import java.time.Instant;

public class StayDto {

    private Long id;
    private String userId;
    private Instant auctionsStartDate;
    private Instant reservationStartDate;
    private Instant reservationEndDate;
    private RoomEntity roomEntity;
    private AuctionEntity auctionEntity;

    public StayDto(Long id, String userId, Instant auctionsStartDate, Instant reservationStartDate, Instant reservationEndDate, RoomEntity roomEntity, AuctionEntity auctionEntity) {
        this.id = id;
        this.userId = userId;
        this.auctionsStartDate = auctionsStartDate;
        this.reservationStartDate = reservationStartDate;
        this.reservationEndDate = reservationEndDate;
        this.roomEntity = roomEntity;
        this.auctionEntity = auctionEntity;
    }
}
