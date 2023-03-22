package com.app.HotelHungerGames;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class HotelHungerGamesApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelHungerGamesApplication.class, args);
	}

}
