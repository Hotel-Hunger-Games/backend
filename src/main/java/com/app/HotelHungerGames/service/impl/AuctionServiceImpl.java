package com.app.HotelHungerGames.service.impl;

import com.app.HotelHungerGames.config.EmailSenderConfig;
import com.app.HotelHungerGames.dto.AuctionDto;
import com.app.HotelHungerGames.dto.BidDto;
import com.app.HotelHungerGames.entity.AuctionEntity;
import com.app.HotelHungerGames.entity.AuctionStatus;
import com.app.HotelHungerGames.mapper.AuctionMapper;
import com.app.HotelHungerGames.mapper.BidMapper;
import com.app.HotelHungerGames.repository.AuctionRepository;
import com.app.HotelHungerGames.service.AuctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class AuctionServiceImpl implements AuctionService {

    private final AuctionRepository auctionRepository;
    private final EmailSenderConfig emailSender;
    private final SimpMessagingTemplate simpMessagingTemplate;


    @Autowired
    public AuctionServiceImpl(AuctionRepository auctionRepository, EmailSenderConfig emailSender, SimpMessagingTemplate simpMessagingTemplate) {
        this.auctionRepository = auctionRepository;
        this.emailSender = emailSender;
        this.simpMessagingTemplate = simpMessagingTemplate;
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

    @Override
    public void updateAuctionStatus(AuctionEntity auction, AuctionStatus status){
        auction.setAuctionStatus(status);
        auctionRepository.save(auction);
    }




    @Override
    @Scheduled(fixedDelay = 5000)
    public void endAuctions() {
        List<AuctionEntity> startedAuctions = auctionRepository.getAllByAuctionStatus(AuctionStatus.STARTED);
        for (AuctionEntity auction : startedAuctions) {
            if (Instant.now().isAfter(auction.getEndDate())) {
                System.out.println("finished");
                emailSender.sendEmailToWinner(auction.getAuctionWinner());
                updateAuctionStatus(auction, AuctionStatus.FINISHED);
                simpMessagingTemplate.convertAndSend(String.format("/ws-auction/%d/end", auction.getId()), auction.getId());
            }
        }
    }

    @Override
    @Scheduled(fixedDelay = 10000)
    public void startAuctions() {
        List<AuctionEntity> createdAuctions = auctionRepository.getAllByAuctionStatus(AuctionStatus.CREATED);
        for (AuctionEntity auction : createdAuctions) {
            if (Instant.now().isAfter(auction.getStartDate())) {
                updateAuctionStatus(auction, AuctionStatus.STARTED);
            }
        }
    }

    public void addBid(Long auctionId, BidDto bidDto) {
        Optional<AuctionEntity> auction = auctionRepository.findById(auctionId);
        auction.ifPresent(auctionEntity -> auctionEntity.addBidToHistory(BidMapper.mapBidToEntity(bidDto)));
    }
}
