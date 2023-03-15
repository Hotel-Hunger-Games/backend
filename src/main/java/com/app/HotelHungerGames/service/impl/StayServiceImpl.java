package com.app.HotelHungerGames.service.impl;

import com.app.HotelHungerGames.dto.StayDto;
import com.app.HotelHungerGames.mapper.StayMapper;
import com.app.HotelHungerGames.repository.StayRepository;
import com.app.HotelHungerGames.service.StayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StayServiceImpl implements StayService {

    private final StayRepository stayRepository;

    @Autowired
    public StayServiceImpl(StayRepository stayRepository) {
        this.stayRepository = stayRepository;
    }


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
        stayRepository.save(StayMapper.mapStayToEntity(stay));
        return stay;
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
