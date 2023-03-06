package com.app.HotelHungerGames.dto;

import java.time.LocalDateTime;
import java.util.List;

public class AuctionDto {

    private Long id;
    private AuctionManagerDto auctionManager;
    private int startPrice;
    private int actualPrice;
    private LocalDateTime auctionEndDate;
    private RoomDto room;
    private List<BidDto> bidHistory;

    public AuctionDto(Long id, AuctionManagerDto auctionManager, int startPrice, int actualPrice,
                      LocalDateTime auctionEndDate, RoomDto room, List<BidDto> bidHistory) {
        this.id = id;
        this.auctionManager = auctionManager;
        this.startPrice = startPrice;
        this.actualPrice = actualPrice;
        this.auctionEndDate = auctionEndDate;
        this.room = room;
        this.bidHistory = bidHistory;
    }
}
