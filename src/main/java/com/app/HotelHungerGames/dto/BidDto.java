package com.app.HotelHungerGames.dto;


public class BidDto {

    private Long id;
    private AuctionDto auction;
    private String email;
    private int price;

    public BidDto(Long id, AuctionDto auction, String email, int price) {
        this.id = id;
        this.auction = auction;
        this.email = email;
        this.price = price;
    }
}
