package com.app.HotelHungerGames.service.impl;

import com.app.HotelHungerGames.dto.StayDto;
import com.app.HotelHungerGames.service.StayService;

import java.util.List;
import java.util.Optional;

public class StayServiceImpl implements StayService {

    @Override
    public Optional<StayDto> getStayById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<StayDto> getAllStays() {
        return null;
    }

    @Override
    public StayDto addNewStay(StayDto stay) {
        return null;
    }

    @Override
    public Optional<StayDto> updateStay(Long id, StayDto stay) {
        return Optional.empty();
    }

    @Override
    public Optional<StayDto> deleteStay(Long id) {
        return Optional.empty();
    }
}
