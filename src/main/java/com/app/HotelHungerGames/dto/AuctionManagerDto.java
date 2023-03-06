package com.app.HotelHungerGames.dto;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;

public class AuctionManagerDto {

    private Long id;
    private String userId;
    private LocalDateTime auctionsStartDate;
    private LocalDateTime reservationStartDate;
    private LocalDateTime reservationEndDate;
    private List<AuctionDto> auctions;

    public AuctionManagerDto(Long id, String userId, LocalDateTime auctionsStartDate, LocalDateTime reservationStartDate,
                             LocalDateTime reservationEndDate, List<AuctionDto> auctions) {
        this.id = id;
        this.userId = userId;
        this.auctionsStartDate = auctionsStartDate;
        this.reservationStartDate = reservationStartDate;
        this.reservationEndDate = reservationEndDate;
        this.auctions = auctions;
    }
}
