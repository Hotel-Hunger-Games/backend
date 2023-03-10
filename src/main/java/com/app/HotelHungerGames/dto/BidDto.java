package com.app.HotelHungerGames.dto;


import com.app.HotelHungerGames.entity.AuctionEntity;

import java.time.LocalDateTime;

public class BidDto {

    private Long id;
    private AuctionEntity auction;
    private String email;
    private Double price;
    private LocalDateTime bidTime;

    public BidDto(Long id, AuctionEntity auction, String email, Double price, LocalDateTime bidTime) {
        this.id = id;
        this.auction = auction;
        this.email = email;
        this.price = price;
        this.bidTime = bidTime;
    }

    public BidDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AuctionEntity getAuction() {
        return auction;
    }

    public void setAuction(AuctionEntity auction) {
        this.auction = auction;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalDateTime getBidTime() {
        return bidTime;
    }

    public void setBidTime(LocalDateTime bidTime) {
        this.bidTime = bidTime;
    }
}
