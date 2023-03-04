package com.app.HotelHungerGames.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")

public class HotelServiceController {


    @GetMapping("/admin")
    public String admin() {
        return "Access allowed for hotel-service";
    }
}

