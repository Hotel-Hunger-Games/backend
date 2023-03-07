package com.app.HotelHungerGames.dto;

import com.app.HotelHungerGames.entity.BidEntity;
import com.app.HotelHungerGames.entity.StayEntity;
import java.time.Instant;
import java.util.List;

public class AuctionDto {

    private Long id;
    private StayEntity stayEntity;
    private int startPrice;
    private Integer actualPrice;
    private Instant auctionEndDate;
    private List<BidEntity> bidHistory;

    public AuctionDto(Long id, StayEntity stayEntity, int startPrice, Integer actualPrice, Instant auctionEndDate, List<BidEntity> bidHistory) {
        this.id = id;
        this.stayEntity = stayEntity;
        this.startPrice = startPrice;
        this.actualPrice = actualPrice;
        this.auctionEndDate = auctionEndDate;
        this.bidHistory = bidHistory;
    }
}
