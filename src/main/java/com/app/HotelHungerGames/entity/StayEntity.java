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
    private Instant reservationStartDate;
    private Instant reservationEndDate;
    @ManyToOne(fetch = FetchType.LAZY)
    private RoomEntity roomEntity;

    @OneToOne
    private AuctionEntity auctionEntity;

    public StayEntity() {
    }

    public StayEntity(Long id, String userId, AuctionEntity auctionEntity, RoomEntity roomEntity, Instant reservationStartDate,
                      Instant reservationEndDate) {
        this.id = id;
        this.userId = userId;
        this.auctionEntity = auctionEntity;
        this.roomEntity = roomEntity;
        this.reservationStartDate = reservationStartDate;
        this.reservationEndDate = reservationEndDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }


    public Instant getReservationStartDate() {
        return reservationStartDate;
    }

    public void setReservationStartDate(Instant reservationStartDate) {
        this.reservationStartDate = reservationStartDate;
    }

    public Instant getReservationEndDate() {
        return reservationEndDate;
    }

    public void setReservationEndDate(Instant reservationEndDate) {
        this.reservationEndDate = reservationEndDate;
    }

    public RoomEntity getRoomEntity() {
        return roomEntity;
    }

    public void setRoomEntity(RoomEntity roomEntity) {
        this.roomEntity = roomEntity;
    }

    public AuctionEntity getAuctionEntity() {
        return auctionEntity;
    }

    public void setAuctionEntity(AuctionEntity auctionEntity) {
        this.auctionEntity = auctionEntity;
    }
}
