package com.app.HotelHungerGames.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "room")
public class RoomEntity {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private int accommodationCapacity;
    @ElementCollection
    private List<Integer> bedsSizes;

    @OneToMany(mappedBy = "roomEntity", cascade = CascadeType.ALL)
    private List<StayEntity> stays = new ArrayList<>();

    @ElementCollection
    private List<String> images;
    public RoomEntity() {

    }

    public RoomEntity(Long id, String name, int accommodationCapacity, List<Integer> bedsSizes,
                      List<StayEntity> stays, List<String> images) {
        this.id = id;
        this.name = name;
        this.accommodationCapacity = accommodationCapacity;
        this.bedsSizes = bedsSizes;
        this.stays = stays;
        this.images = images;
    }
}
