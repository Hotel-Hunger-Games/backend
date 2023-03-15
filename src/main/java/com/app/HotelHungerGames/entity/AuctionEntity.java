package com.app.HotelHungerGames.entity;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name = "auction")
public class AuctionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private StayEntity stayEntity;
    private BigDecimal startPrice;
    private BigDecimal actualPrice;
    private Instant auctionsStartDate;
    private Instant auctionEndDate;
    @OneToMany(mappedBy = "auction", cascade = CascadeType.ALL)
    private List<BidEntity> bidHistory = new ArrayList<>();


    public AuctionEntity() {
    }

    public AuctionEntity(Long id, StayEntity stayEntity, BigDecimal startPrice,
                         BigDecimal actualPrice, Instant auctionsStartDate, Instant auctionEndDate, List<BidEntity> bidHistory) {
        this.id = id;
        this.stayEntity = stayEntity;
        this.startPrice = startPrice;
        this.actualPrice = actualPrice;
        this.auctionsStartDate = auctionsStartDate;
        this.auctionEndDate = auctionEndDate;
        this.bidHistory = bidHistory;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StayEntity getStayEntity() {
        return stayEntity;
    }

    public void setStayEntity(StayEntity stayEntity) {
        this.stayEntity = stayEntity;
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

    public Instant getAuctionsStartDate() {
        return auctionsStartDate;
    }

    public void setAuctionsStartDate(Instant auctionsStartDate) {
        this.auctionsStartDate = auctionsStartDate;
    }

    public void setActualPrice(BigDecimal actualPrice) {
        this.actualPrice = actualPrice;
    }

    public Instant getAuctionEndDate() {
        return auctionEndDate;
    }

    public void setAuctionEndDate(Instant auctionEndDate) {
        this.auctionEndDate = auctionEndDate;
    }

    public List<BidEntity> getBidHistory() {
        return bidHistory;
    }

    public void setBidHistory(List<BidEntity> bidHistory) {
        this.bidHistory = bidHistory;
    }
}
