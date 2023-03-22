package com.app.HotelHungerGames.service.impl;

import com.app.HotelHungerGames.dto.BidDto;
import com.app.HotelHungerGames.entity.AuctionEntity;
import com.app.HotelHungerGames.entity.BidEntity;
import com.app.HotelHungerGames.mapper.AuctionMapper;
import com.app.HotelHungerGames.mapper.BidMapper;
import com.app.HotelHungerGames.repository.AuctionRepository;
import com.app.HotelHungerGames.repository.BidRepository;
import com.app.HotelHungerGames.service.RealTimeBiddingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RealTimeBiddingServiceImpl implements RealTimeBiddingService {

    private final AuctionRepository auctionRepository;
    private final BidRepository bidRepository;

    @Autowired
    public RealTimeBiddingServiceImpl(AuctionRepository auctionRepository, BidRepository bidRepository) {
        this.auctionRepository = auctionRepository;
        this.bidRepository = bidRepository;
    }

    @Override
    public List<BidDto> getBidHistoryByAuctionId(Long auctionId) {
        List<BidEntity> bidEntities = bidRepository.getBidEntitiesByAuctionId(auctionId);
        return bidEntities.stream()
                .map(BidMapper::mapBidToDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<BidDto> addBidToAuction(Long auctionId, BidDto bid) {
        Optional<AuctionEntity> auctionEntity = auctionRepository.findById(auctionId);
        if(auctionEntity.isPresent() && Instant.now().isBefore(auctionEntity.get().getEndDate())){
            AuctionEntity auction = auctionEntity.get();
            bid.setAuction(AuctionMapper.mapAuctionToDto(auctionEntity.get()));
            bidRepository.save(BidMapper.mapBidToEntity(bid));
            updateAuctionPrice(bid, auction);
            return Optional.of(bid);
        } else {
            return Optional.empty();
        }

    }

    private void updateAuctionPrice(BidDto bid, AuctionEntity auction) {
        auction.setActualPrice(bid.getPrice());
        auctionRepository.save(auction);
    }
}
