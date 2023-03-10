package com.app.HotelHungerGames.service.impl;

import com.app.HotelHungerGames.dto.BidDto;
import com.app.HotelHungerGames.entity.BidEntity;
import com.app.HotelHungerGames.mapper.BidMapper;
import com.app.HotelHungerGames.repository.BidRepository;
import com.app.HotelHungerGames.repository.StayRepository;
import com.app.HotelHungerGames.service.BidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BidServiceImpl implements BidService {

    private final BidRepository bidRepository;


    @Autowired
    public BidServiceImpl(BidRepository bidRepository) {
        this.bidRepository = bidRepository;
    }

    @Override
    public BidDto addBid(BidDto auctionBid) {
        bidRepository.save(BidMapper.mapBidToEntity(auctionBid));
        return auctionBid;
    }

    @Override
    public Optional<BidDto> getBidById(Long id) {
        Optional<BidEntity> bidEntity = bidRepository.findById(id);
        return bidEntity.map(BidMapper::mapBidToDto);
    }
}
