package com.app.HotelHungerGames.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "room")
public class RoomEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String name;
    private int accommodationCapacity;
    @ElementCollection(fetch = FetchType.EAGER)
    private List<Integer> bedsSizes;

    @OneToMany(mappedBy = "roomEntity")
    private List<StayEntity> stays = new ArrayList<>();

    @ElementCollection(fetch = FetchType.EAGER)
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAccommodationCapacity() {
        return accommodationCapacity;
    }

    public void setAccommodationCapacity(int accommodationCapacity) {
        this.accommodationCapacity = accommodationCapacity;
    }

    public List<Integer> getBedsSizes() {
        return bedsSizes;
    }

    public void setBedsSizes(List<Integer> bedsSizes) {
        this.bedsSizes = bedsSizes;
    }

    public List<StayEntity> getStays() {
        return stays;
    }

    public void setStays(List<StayEntity> stays) {
        this.stays = stays;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }
}
