package com.app.HotelHungerGames.service.impl;

import com.app.HotelHungerGames.repository.StayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StayServiceImpl {
    private final StayRepository stayRepository;

    @Autowired
    public StayServiceImpl(StayRepository stayRepository) {
        this.stayRepository = stayRepository;
    }

}
