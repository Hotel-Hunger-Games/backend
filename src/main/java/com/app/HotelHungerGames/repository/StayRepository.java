package com.app.HotelHungerGames.repository;

import com.app.HotelHungerGames.entity.StayEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StayRepository extends JpaRepository<StayEntity, Long> {
}
