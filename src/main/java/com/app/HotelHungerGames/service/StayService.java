package com.app.HotelHungerGames.service;

import com.app.HotelHungerGames.dto.StayDto;

import java.util.List;
import java.util.Optional;

public interface StayService {
    Optional<StayDto> getStayById(Long id);

    List<StayDto> getAllStays();

    StayDto addNewStay(StayDto stay);

    Optional<StayDto> updateStay(Long id, StayDto stay);

    Optional<StayDto> deleteStay(Long id);
}
