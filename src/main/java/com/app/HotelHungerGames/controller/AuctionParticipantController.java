package com.app.HotelHungerGames.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class AuctionParticipantController {


    @GetMapping("/auction")
    public String getAuction() {
        return "Access allowed for all users";
    }
}
