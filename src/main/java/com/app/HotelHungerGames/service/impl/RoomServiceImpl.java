package com.app.HotelHungerGames.service.impl;

import com.app.HotelHungerGames.dto.RoomDto;
import com.app.HotelHungerGames.entity.RoomEntity;
import com.app.HotelHungerGames.mapper.RoomMapper;
import com.app.HotelHungerGames.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoomServiceImpl {

    private RoomRepository roomRepository;

    @Autowired
    public RoomServiceImpl(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public Optional<RoomDto> getRoomById(Long id){
        Optional<RoomEntity> roomEntity = roomRepository.findById(id);
        return roomEntity.map(RoomMapper::mapRoomToDto);
    }
}
