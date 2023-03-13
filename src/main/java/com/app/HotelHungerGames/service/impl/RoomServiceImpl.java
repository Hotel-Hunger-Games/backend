package com.app.HotelHungerGames.service.impl;

import com.app.HotelHungerGames.dto.RoomDto;
import com.app.HotelHungerGames.entity.RoomEntity;
import com.app.HotelHungerGames.mapper.RoomMapper;
import com.app.HotelHungerGames.repository.RoomRepository;
import com.app.HotelHungerGames.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;

    @Autowired
    public RoomServiceImpl(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public Optional<RoomDto> getRoomById(Long id){
        Optional<RoomEntity> roomEntity = roomRepository.findById(id);
        return roomEntity.map(RoomMapper::mapRoomToDto);
    }

    public RoomDto addNewRoom(RoomDto roomDto){
        roomRepository.save(RoomMapper.mapRoomToEntity(roomDto));
        return roomDto;
    }

    public Optional<RoomDto> updateRoom(Long id, RoomDto room) {
        Optional<RoomEntity> roomEntity = roomRepository.findById(id);
        if(roomEntity.isPresent()){
            roomRepository.save(RoomMapper.mapRoomToEntity(room));
            return roomEntity.map(RoomMapper::mapRoomToDto);
        } else {
            return Optional.empty();
        }
    }


    public Optional<RoomDto> deleteRoom(Long id) {
        Optional<RoomEntity> roomEntity = roomRepository.findById(id);
        if(roomEntity.isPresent()){
            roomRepository.delete(roomEntity.get());
            return roomEntity.map(RoomMapper::mapRoomToDto);
        } else {
            return Optional.empty();
        }
    }
}
