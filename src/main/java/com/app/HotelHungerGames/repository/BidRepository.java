package com.app.HotelHungerGames.repository;

import com.app.HotelHungerGames.entity.AuctionEntity;
import com.app.HotelHungerGames.entity.BidEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BidRepository extends JpaRepository<BidEntity, Long> {
    List<BidEntity> getBidEntitiesByAuctionId(Long id);
}
