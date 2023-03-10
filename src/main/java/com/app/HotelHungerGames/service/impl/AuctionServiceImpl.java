package com.app.HotelHungerGames.service.impl;

import com.app.HotelHungerGames.dto.AuctionDto;
import com.app.HotelHungerGames.entity.AuctionEntity;
import com.app.HotelHungerGames.mapper.AuctionMapper;
import com.app.HotelHungerGames.repository.AuctionRepository;
import com.app.HotelHungerGames.service.AuctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AuctionServiceImpl implements AuctionService {

    private final AuctionRepository auctionRepository;

    @Autowired
    public AuctionServiceImpl(AuctionRepository auctionRepository) {
        this.auctionRepository = auctionRepository;
    }

    @Override
    public Optional<AuctionDto> getAuctionById(Long id) {
        Optional<AuctionEntity> auctionEntity = auctionRepository.findById(id);
        return auctionEntity.map(AuctionMapper::mapAuctionToDto);
    }

    @Override
    public List<AuctionDto> getAllAuctions() {
        List<AuctionEntity> auctionEntities = auctionRepository.findAll();
        return auctionEntities.stream().map(AuctionMapper::mapAuctionToDto).toList();
    }

    @Override
    public AuctionDto addNewAuction(AuctionDto auction) {
        auctionRepository.save(AuctionMapper.mapAuctionToEntity(auction));
        return auction;
    }

    @Override
    public Optional<AuctionDto> updateAuction(Long id, AuctionDto auction) {
        Optional<AuctionEntity> auctionEntity = auctionRepository.findById(id);
        if(auctionEntity.isPresent()){
            auctionRepository.save(AuctionMapper.mapAuctionToEntity(auction));
            return auctionEntity.map(AuctionMapper::mapAuctionToDto);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public Optional<AuctionDto> deleteAuction(Long id) {
        Optional<AuctionEntity> auctionEntity = auctionRepository.findById(id);
        if(auctionEntity.isPresent()){
            return auctionEntity.map(AuctionMapper::mapAuctionToDto);
        } else {
            return Optional.empty();
        }
    }
}
