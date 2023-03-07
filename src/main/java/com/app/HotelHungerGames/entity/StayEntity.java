package com.app.HotelHungerGames.entity;


import jakarta.persistence.*;
import java.time.Instant;


@Entity
@Table(name = "stay")
public class StayEntity {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    private String userId;
    private Instant auctionsStartDate;
    private Instant reservationStartDate;
    private Instant reservationEndDate;
    @ManyToOne(fetch = FetchType.LAZY)
    private RoomEntity roomEntity;

    @OneToOne
    private AuctionEntity auctionEntity;

    public StayEntity() {
    }

    public StayEntity(Long id, String userId, AuctionEntity auctionEntity, RoomEntity roomEntity, Instant auctionsStartDate, Instant reservationStartDate,
                      Instant reservationEndDate) {
        this.id = id;
        this.userId = userId;
        this.auctionEntity = auctionEntity;
        this.roomEntity = roomEntity;
        this.auctionsStartDate = auctionsStartDate;
        this.reservationStartDate = reservationStartDate;
        this.reservationEndDate = reservationEndDate;
    }
}
