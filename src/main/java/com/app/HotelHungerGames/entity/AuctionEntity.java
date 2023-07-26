package com.app.HotelHungerGames.entity;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import com.app.HotelHungerGames.dto.BidDto;
import jakarta.persistence.*;

@Entity
@Table(name = "auction")
public class AuctionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne(cascade = CascadeType.PERSIST)
    private StayEntity stayEntity;
    private BigDecimal startPrice;
    @Enumerated(EnumType.STRING)
    private AuctionStatus auctionStatus;
    private BigDecimal actualPrice;
    private Instant startDate;
    private Instant endDate;
    private String auctionWinner;
    @OneToMany
    private List<BidEntity> bidHistory;


    public AuctionEntity() {
    }

    public AuctionEntity(Long id, StayEntity stayEntity, BigDecimal startPrice,
                         BigDecimal actualPrice, Instant startDate, Instant endDate, String auctionWinner, List<BidEntity> bidHistory) {
        this.id = id;
        this.stayEntity = stayEntity;
        this.startPrice = startPrice;
        this.actualPrice = actualPrice;
        this.startDate = startDate;
        this.endDate = endDate;
        this.auctionWinner = auctionWinner;
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

    public Instant getStartDate() {
        return startDate;
    }

    public void setStartDate(Instant auctionsStartDate) {
        this.startDate = auctionsStartDate;
    }

    public void setActualPrice(BigDecimal actualPrice) {
        this.actualPrice = actualPrice;
    }

    public Instant getEndDate() {
        return endDate;
    }

    public void setEndDate(Instant auctionEndDate) {
        this.endDate = auctionEndDate;
    }

    public String getAuctionWinner() {
        return auctionWinner;
    }

    public void setAuctionWinner(String auctionWinner) {
        this.auctionWinner = auctionWinner;
    }

    public List<BidEntity> getBidHistory() {
        return bidHistory;
    }

    public void addBidToHistory(BidEntity bidEntity) {
        bidHistory.add(bidEntity);
    }

    public void setBidHistory(List<BidEntity> bidHistory) {
        this.bidHistory = bidHistory;
    }
}
