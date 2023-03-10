package com.app.HotelHungerGames.repository;

import com.app.HotelHungerGames.entity.RoomEntity;
import com.app.HotelHungerGames.entity.StayEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StayRepository extends JpaRepository<StayEntity, Long> {
}
