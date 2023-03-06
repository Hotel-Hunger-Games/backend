package com.app.HotelHungerGames.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name = "auction")
public class AuctionEntity {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "auction_manager_id")
    private AuctionManagerEntity auctionManager;
    private int startPrice;
    private int actualPrice;
    private LocalDateTime auctionEndDate;
    @OneToOne
    private RoomEntity room;
    @OneToMany(mappedBy = "auction", cascade = CascadeType.ALL)
    private List<BidEntity> bidHistory = new ArrayList<>();

    public AuctionEntity() {
    }

    public AuctionEntity(Long id, AuctionManagerEntity auctionManagerEntity, int startPrice, int actualPrice, LocalDateTime auctionEndDate, RoomEntity room, List<BidEntity> bidHistory) {
        this.id = id;
        this.auctionManager = auctionManagerEntity;
        this.startPrice = startPrice;
        this.actualPrice = actualPrice;
        this.auctionEndDate = auctionEndDate;
        this.room = room;
        this.bidHistory = bidHistory;
    }


}
