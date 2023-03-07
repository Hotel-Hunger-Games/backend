package com.app.HotelHungerGames.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "bid")
public class BidEntity {

    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private AuctionEntity auction;
    private String email;
    private int price;
    private LocalDateTime bidTime;


    public BidEntity() {
    }

    public BidEntity(Long id, AuctionEntity auction, String email,
                     int price, LocalDateTime bidTime) {
        this.id = id;
        this.auction = auction;
        this.email = email;
        this.price = price;
        this.bidTime = bidTime;
    }
}
