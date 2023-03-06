package com.app.HotelHungerGames.controller;

import com.app.HotelHungerGames.repository.AuctionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")

public class HotelServiceController {

    private AuctionRepository auctionRepository;
    @Autowired
    public HotelServiceController(AuctionRepository auctionRepository) {
        this.auctionRepository = auctionRepository;
    }

    @GetMapping("/admin")
    public String admin() {
        return "Access allowed for hotel-service";
    }
}

