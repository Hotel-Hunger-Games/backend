package com.app.HotelHungerGames.repository;

import com.app.HotelHungerGames.entity.AuctionEntity;
import com.app.HotelHungerGames.entity.AuctionStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AuctionRepository extends JpaRepository<AuctionEntity, Long> {
    List<AuctionEntity> getAllByAuctionStatus(AuctionStatus status);
}
