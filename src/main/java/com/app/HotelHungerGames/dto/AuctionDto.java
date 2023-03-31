package com.app.HotelHungerGames.dto;

import com.app.HotelHungerGames.entity.AuctionStatus;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

public class AuctionDto {

    private Long id;
    private StayDto stay;
    private AuctionStatus auctionStatus;
    private BigDecimal startPrice;
    private BigDecimal actualPrice;
    private Instant startDate;
    private Instant endDate;
    private String auctionWinner;

    public AuctionDto(Long id, StayDto stay, AuctionStatus auctionStatus, BigDecimal startPrice, BigDecimal actualPrice, Instant startDate, Instant endDate, String auctionWinner) {
        this.id = id;
        this.stay = stay;
        this.auctionStatus = auctionStatus;
        this.startPrice = startPrice;
        this.actualPrice = actualPrice;
        this.startDate = startDate;
        this.endDate = endDate;
        this.auctionWinner = auctionWinner;;
    }

    public AuctionDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StayDto getStay() {
        return stay;
    }

    public void setStay(StayDto stay) {
        this.stay = stay;
    }

    public AuctionStatus getAuctionStatus() {
        return auctionStatus;
    }

    public void setAuctionStatus(AuctionStatus auctionStatus) {
        this.auctionStatus = auctionStatus;
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

    public String getAuctionWinner() {
        return auctionWinner;
    }

    public void setAuctionWinner(String auctionWinner) {
        this.auctionWinner = auctionWinner;
    }
}
