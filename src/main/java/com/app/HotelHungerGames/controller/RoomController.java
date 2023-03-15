package com.app.HotelHungerGames.controller;

import com.app.HotelHungerGames.dto.RoomDto;
import com.app.HotelHungerGames.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@Controller
@CrossOrigin
@RequestMapping("/api/auction/room")
public class RoomController {

    private final RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }


    @PostMapping
    public ResponseEntity<?> addNewRoom(@RequestBody RoomDto roomDto) {
        roomService.addNewRoom(roomDto);
        return new ResponseEntity<>(roomDto, HttpStatus.CREATED);
    }

    @GetMapping("/{roomId}")
    public ResponseEntity<?> getRoomById(@PathVariable("roomId") Long roomId){
        Optional<RoomDto> room = roomService.getRoomById(roomId);
        if(room.isPresent()){
            return new ResponseEntity<>(room, HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{roomId}")
    public ResponseEntity<?> updateRoom(@PathVariable("roomId") Long roomId, @RequestBody RoomDto roomDto){
        roomService.updateRoom(roomId, roomDto);
        return new ResponseEntity<>(roomDto, HttpStatus.OK);
    }

}
