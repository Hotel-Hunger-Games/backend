package com.app.HotelHungerGames.service;

import com.app.HotelHungerGames.dto.RoomDto;

import java.util.Optional;

public interface RoomService {
    Optional<RoomDto> getRoomById(Long id);
    RoomDto addNewRoom(RoomDto roomDto);
    Optional<RoomDto> updateRoom(Long id, RoomDto room);
    Optional<RoomDto> deleteRoom(Long id);

}
