package com.app.HotelHungerGames.repository;

import com.app.HotelHungerGames.entity.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<RoomEntity, Long> {
}
