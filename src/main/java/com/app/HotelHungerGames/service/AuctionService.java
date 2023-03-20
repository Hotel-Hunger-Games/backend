package com.app.HotelHungerGames.service;

import com.app.HotelHungerGames.dto.AuctionDto;
import com.app.HotelHungerGames.dto.BidDto;
import com.app.HotelHungerGames.entity.AuctionEntity;

import java.util.List;
import java.util.Optional;

public interface AuctionService {

    Optional<AuctionDto> getAuctionById(Long id);

    List<AuctionDto> getAllAuctions();

    AuctionDto addNewAuction(AuctionDto auction);

    Optional<AuctionDto> updateAuction(Long id, AuctionDto auction);

    Optional<AuctionDto> deleteAuction(Long id);

    Optional<AuctionEntity> getAuctionEntityById(Long id);

    Optional<AuctionDto> endAuction(Long id);

}
