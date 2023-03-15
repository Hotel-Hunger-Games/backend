package com.app.HotelHungerGames.controller;

import com.app.HotelHungerGames.dto.AuctionDto;
import com.app.HotelHungerGames.service.AuctionService;
import com.app.HotelHungerGames.service.RoomService;
import com.app.HotelHungerGames.service.StayService;
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
    private final StayService stayService;
    private final RoomService roomService;


    @Autowired
    public AuctionController(AuctionService auctionService, StayService stayService, RoomService roomService) {
        this.auctionService = auctionService;
        this.stayService = stayService;
        this.roomService = roomService;
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
//        roomService.addNewRoom(auction.getStayDto().getRoomDto());
        auctionService.addNewAuction(auction);
        return new ResponseEntity<>(auction, HttpStatus.CREATED);
        }

    @PutMapping("/{auctionId}")
    public ResponseEntity<?> updateAuction(@PathVariable("auctionId") Long auctionId, @RequestBody AuctionDto auctionDto){
        auctionService.updateAuction(auctionId, auctionDto);
        return new ResponseEntity<>(auctionDto, HttpStatus.OK);
    }


}
