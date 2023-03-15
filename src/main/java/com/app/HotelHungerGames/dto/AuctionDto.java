package com.app.HotelHungerGames.dto;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

public class AuctionDto {

    private Long id;
    private StayDto stayDto;
    private BigDecimal startPrice;
    private BigDecimal actualPrice;
    private Instant startDate;
    private Instant endDate;
    private List<BidDto> bidHistory;

    public AuctionDto(Long id, StayDto stayDto, BigDecimal startPrice, BigDecimal actualPrice, Instant startDate, Instant endDate, List<BidDto> bidHistory) {
        this.id = id;
        this.stayDto = stayDto;
        this.startPrice = startPrice;
        this.actualPrice = actualPrice;
        this.startDate = startDate;
        this.endDate = endDate;
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

    public BigDecimal getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(BigDecimal startPrice) {
        this.startPrice = startPrice;
    }

    public BigDecimal getActualPrice() {
        return actualPrice;
    }

    public void setActualPrice(BigDecimal actualPrice) {
        this.actualPrice = actualPrice;
    }


    public Instant getStartDate() {
        return startDate;
    }

    public void setStartDate(Instant startDate) {
        this.startDate = startDate;
    }



    public Instant getEndDate() {
        return endDate;
    }

    public void setEndDate(Instant endDate) {
        this.endDate = endDate;
    }

    public List<BidDto> getBidHistory() {
        return bidHistory;
    }

    public void setBidHistory(List<BidDto> bidHistory) {
        this.bidHistory = bidHistory;
    }
}
