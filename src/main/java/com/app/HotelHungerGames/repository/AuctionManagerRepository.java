package com.app.HotelHungerGames.repository;

import com.app.HotelHungerGames.entity.AuctionEntity;
import com.app.HotelHungerGames.entity.AuctionManagerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuctionManagerRepository extends JpaRepository<AuctionManagerEntity, Long> {
}
