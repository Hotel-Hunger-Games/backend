package com.app.HotelHungerGames.controller;

import com.app.HotelHungerGames.dto.AuctionDto;
import com.app.HotelHungerGames.service.AuctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/api/auction")
public class AuctionController {


    private final AuctionService auctionService;

    @Autowired
    public AuctionController(AuctionService auctionService) {
        this.auctionService = auctionService;
    }

    @GetMapping("/auction")
    public String getAuction() {
        return "Access allowed for all users";
    }




    @GetMapping("/{auctionId}")
    public ResponseEntity<?> getAuctionById(@PathVariable("auctionId")Long auctionId) {
        Optional<AuctionDto> auction = auctionService.getAuctionById(auctionId);
        if(auction.isPresent()){
            return new ResponseEntity<>(HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> addNewAuction(@RequestBody AuctionDto auction) {
            auctionService.addNewAuction(auction);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }


}
