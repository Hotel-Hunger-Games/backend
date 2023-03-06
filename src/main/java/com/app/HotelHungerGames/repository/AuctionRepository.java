package com.app.HotelHungerGames.repository;

import com.app.HotelHungerGames.entity.AuctionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AuctionRepository extends JpaRepository<AuctionEntity, Long> {
}
