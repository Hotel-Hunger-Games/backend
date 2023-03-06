package com.app.HotelHungerGames.entity;


import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "auction_manager")
public class AuctionManagerEntity {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    private String userId;
    private LocalDateTime auctionsStartDate;
    private LocalDateTime reservationStartDate;
    private LocalDateTime reservationEndDate;
    @OneToMany(mappedBy = "auctionManager", cascade = CascadeType.ALL)
    private List<AuctionEntity> auctions = new ArrayList<>();


    public AuctionManagerEntity() {
    }

    public AuctionManagerEntity(Long id, String userId, LocalDateTime auctionsStartDate, LocalDateTime reservationStartDate,
                                LocalDateTime reservationEndDate, List<AuctionEntity> auctions) {
        this.id = id;
        this.userId = userId;
        this.auctionsStartDate = auctionsStartDate;
        this.reservationStartDate = reservationStartDate;
        this.reservationEndDate = reservationEndDate;
        this.auctions = auctions;
    }
}
