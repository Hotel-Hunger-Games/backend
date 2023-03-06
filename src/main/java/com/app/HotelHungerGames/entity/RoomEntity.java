package com.app.HotelHungerGames.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "room")
public class RoomEntity {

    @Id
    @GeneratedValue
    private Long id;
    @OneToOne
    @JoinColumn(name = "auction_id")
    private AuctionEntity auction;
    private String name;
    private int accommodationCapacity;
    @ElementCollection
    private List<Integer> bedsSizes;


    public RoomEntity() {

    }

    public RoomEntity(Long id, AuctionEntity auction, String name,
                      int accommodationCapacity, List<Integer> bedsSizes) {
        this.id = id;
        this.auction = auction;
        this.name = name;
        this.accommodationCapacity = accommodationCapacity;
        this.bedsSizes = bedsSizes;
    }

}
