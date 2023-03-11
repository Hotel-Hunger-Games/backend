package com.app.HotelHungerGames.dto;

import java.time.Instant;

public class StayDto {

    private Long id;
    private String userId;
    private Instant auctionsStartDate;
    private Instant reservationStartDate;
    private Instant reservationEndDate;
    private RoomDto roomDto;
    private AuctionDto auctionDto;

    public StayDto(Long id, String userId, Instant auctionsStartDate, Instant reservationStartDate, Instant reservationEndDate, RoomDto roomDto, AuctionDto auctionDto) {
        this.id = id;
        this.userId = userId;
        this.auctionsStartDate = auctionsStartDate;
        this.reservationStartDate = reservationStartDate;
        this.reservationEndDate = reservationEndDate;
        this.roomDto = roomDto;
        this.auctionDto = auctionDto;
    }

    public StayDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Instant getAuctionsStartDate() {
        return auctionsStartDate;
    }

    public void setAuctionsStartDate(Instant auctionsStartDate) {
        this.auctionsStartDate = auctionsStartDate;
    }

    public Instant getReservationStartDate() {
        return reservationStartDate;
    }

    public void setReservationStartDate(Instant reservationStartDate) {
        this.reservationStartDate = reservationStartDate;
    }

    public Instant getReservationEndDate() {
        return reservationEndDate;
    }

    public void setReservationEndDate(Instant reservationEndDate) {
        this.reservationEndDate = reservationEndDate;
    }

    public RoomDto getRoomDto() {
        return roomDto;
    }

    public void setRoomDto(RoomDto roomDto) {
        this.roomDto = roomDto;
    }

    public AuctionDto getAuctionDto() {
        return auctionDto;
    }

    public void setAuctionDto(AuctionDto auctionDto) {
        this.auctionDto = auctionDto;
    }
}
