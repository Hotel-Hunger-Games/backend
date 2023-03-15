package com.app.HotelHungerGames.dto;

import java.util.List;

public class RoomDto {

    private Long id;
    private String name;
    private int accommodationCapacity;
    private List<Integer> bedsSizes;
    private List<StayDto> stays;

    private List<String> images;

    public RoomDto(Long id, String name, int accommodationCapacity, List<Integer> bedsSizes, List<StayDto> stays, List<String> images) {
        this.id = id;
        this.name = name;
        this.accommodationCapacity = accommodationCapacity;
        this.bedsSizes = bedsSizes;
        this.stays = stays;
        this.images = images;
    }

    public RoomDto() {
    }

    @Override
    public String toString() {
        return "RoomDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", accommodationCapacity=" + accommodationCapacity +
                ", bedsSizes=" + bedsSizes +
                ", stays=" + stays +
                ", images=" + images +
                '}';
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

    public List<StayDto> getStays() {
        return stays;
    }

    public void setStays(List<StayDto> stays) {
        this.stays = stays;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }
}
