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

    public AuctionDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StayEntity getStayEntity() {
        return stayEntity;
    }

    public void setStayEntity(StayEntity stayEntity) {
        this.stayEntity = stayEntity;
    }

    public int getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(int startPrice) {
        this.startPrice = startPrice;
    }

    public Integer getActualPrice() {
        return actualPrice;
    }

    public void setActualPrice(Integer actualPrice) {
        this.actualPrice = actualPrice;
    }

    public Instant getAuctionEndDate() {
        return auctionEndDate;
    }

    public void setAuctionEndDate(Instant auctionEndDate) {
        this.auctionEndDate = auctionEndDate;
    }

    public List<BidEntity> getBidHistory() {
        return bidHistory;
    }

    public void setBidHistory(List<BidEntity> bidHistory) {
        this.bidHistory = bidHistory;
    }
}
