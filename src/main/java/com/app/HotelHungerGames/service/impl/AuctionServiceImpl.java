package com.app.HotelHungerGames.service.impl;

import com.app.HotelHungerGames.config.EmailSender;
import com.app.HotelHungerGames.dto.AuctionDto;
import com.app.HotelHungerGames.entity.AuctionEntity;
import com.app.HotelHungerGames.entity.AuctionStatus;
import com.app.HotelHungerGames.mapper.AuctionMapper;
import com.app.HotelHungerGames.repository.AuctionRepository;
import com.app.HotelHungerGames.service.AuctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class AuctionServiceImpl implements AuctionService {

    private final AuctionRepository auctionRepository;
    private final EmailSender emailSender;


    @Autowired
    public AuctionServiceImpl(AuctionRepository auctionRepository, EmailSender emailSender) {
        this.auctionRepository = auctionRepository;
        this.emailSender = emailSender;
    }

    @Override
    public Optional<AuctionDto> getAuctionById(Long id) {
        Optional<AuctionEntity> auctionEntity = auctionRepository.findById(id);
        return auctionEntity.map(AuctionMapper::mapAuctionToDto);
    }

    public Optional<AuctionEntity> getAuctionEntityById(Long id) {
        return auctionRepository.findById(id);
    }

    @Override
    public Optional<AuctionDto> endAuction(Long id) {
        Optional<AuctionEntity> auctionEntity = auctionRepository.findById(id);
        if(auctionEntity.isPresent()){
            AuctionEntity auction = auctionEntity.get();
            if(auction.getEndDate().isBefore(Instant.now())){
                emailSender.sendEmailToWinner(auction.getAuctionWinner());
                auction.setAuctionStatus(AuctionStatus.FINISHED);
                auctionRepository.save(auction);
                return Optional.of(AuctionMapper.mapAuctionToDto(auction));
            }
        }
        return Optional.empty();
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
            auctionRepository.delete(auctionEntity.get());
            return auctionEntity.map(AuctionMapper::mapAuctionToDto);
        } else {
            return Optional.empty();
        }
    }


}
