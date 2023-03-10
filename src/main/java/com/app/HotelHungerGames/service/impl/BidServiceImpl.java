package com.app.HotelHungerGames.service.impl;

import com.app.HotelHungerGames.dto.BidDto;
import com.app.HotelHungerGames.repository.BidRepository;
import com.app.HotelHungerGames.repository.StayRepository;
import com.app.HotelHungerGames.service.BidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BidServiceImpl implements BidService {

    private BidRepository bidRepository;
    private StayRepository stayRepository;

    @Autowired
    public BidServiceImpl(BidRepository bidRepository, StayRepository stayRepository) {
        this.bidRepository = bidRepository;
        this.stayRepository = stayRepository;
    }

    @Override
    public BidDto addBid(Long roomId, BidDto auctionBid) {

    }
}
