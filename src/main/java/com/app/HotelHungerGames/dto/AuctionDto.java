package com.app.HotelHungerGames.dto;

import com.app.HotelHungerGames.entity.BidEntity;
import com.app.HotelHungerGames.entity.StayEntity;
import java.time.Instant;
import java.util.List;

public class AuctionDto {

    private Long id;
    private StayDto stayDto;
    private int startPrice;
    private Integer actualPrice;
    private Instant auctionEndDate;
    private List<BidDto> bidHistory;

    public AuctionDto(Long id, StayDto stayDto, int startPrice, Integer actualPrice, Instant auctionEndDate, List<BidDto> bidHistory) {
        this.id = id;
        this.stayDto = stayDto;
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

    public StayDto getStayDto() {
        return stayDto;
    }

    public void setStayDto(StayDto stayDto) {
        this.stayDto = stayDto;
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

    public List<BidDto> getBidHistory() {
        return bidHistory;
    }

    public void setBidHistory(List<BidDto> bidHistory) {
        this.bidHistory = bidHistory;
    }
}
