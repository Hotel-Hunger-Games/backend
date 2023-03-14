package com.app.HotelHungerGames.dto;

import java.time.Instant;
import java.util.List;

public class AuctionDto {

    private Long id;
    private StayDto stayDto;
    private Integer startPrice;
    private Integer actualPrice;
    private Instant auctionsStartDate;
    private Instant auctionEndDate;
    private List<BidDto> bidHistory;

    public AuctionDto(Long id, StayDto stayDto, Integer startPrice, Integer actualPrice, Instant auctionsStartDate, Instant auctionEndDate, List<BidDto> bidHistory) {
        this.id = id;
        this.stayDto = stayDto;
        this.startPrice = startPrice;
        this.actualPrice = actualPrice;
        this.auctionsStartDate = auctionsStartDate;
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

    public void setStartPrice(Integer startPrice) {
        this.startPrice = startPrice;
    }

    public Instant getAuctionsStartDate() {
        return auctionsStartDate;
    }

    public void setAuctionsStartDate(Instant auctionsStartDate) {
        this.auctionsStartDate = auctionsStartDate;
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
