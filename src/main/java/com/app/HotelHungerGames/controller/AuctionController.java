package com.app.HotelHungerGames.controller;

import com.app.HotelHungerGames.dto.AuctionDto;
import com.app.HotelHungerGames.service.AuctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/auction")
public class AuctionController {


    private final AuctionService auctionService;


    @Autowired
    public AuctionController(AuctionService auctionService) {
        this.auctionService = auctionService;
    }

    @GetMapping()
    public List<AuctionDto> getAllAuctions() {
        return auctionService.getAllAuctions();
    }

    @GetMapping("/{auctionId}")
    public ResponseEntity<?> getAuctionById(@PathVariable("auctionId")Long auctionId) {
        Optional<AuctionDto> auction = auctionService.getAuctionById(auctionId);
        if(auction.isPresent()){
            return new ResponseEntity<>(auction, HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> addNewAuction(@RequestBody AuctionDto auction) {
        auctionService.addNewAuction(auction);
        return new ResponseEntity<>(auction, HttpStatus.CREATED);
        }

    @PutMapping("/{auctionId}")
    public ResponseEntity<?> updateAuction(@PathVariable("auctionId") Long auctionId, @RequestBody AuctionDto auctionDto){
        Optional<AuctionDto> auction = auctionService.getAuctionById(auctionId);
        if(auction.isPresent()){
            auctionService.updateAuction(auctionId, auctionDto);
            return new ResponseEntity<>(auctionDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(auctionDto, HttpStatus.NOT_FOUND);
        }

    }


}
