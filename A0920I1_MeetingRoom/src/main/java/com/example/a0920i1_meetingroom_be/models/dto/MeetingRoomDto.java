package com.example.a0920i1_meetingroom_be.models.dto;

import java.util.List;

public class MeetingRoomDto {

    private long id;

    private String name;

    private Integer floors;

    private String imageUrl;

    private long area;

//    private List<EquipmentDto> equipments;

    private long typeMeetingRoom;

    private long roomStatus;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getFloors() {
        return floors;
    }

    public void setFloors(Integer floors) {
        this.floors = floors;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public long getArea() {
        return area;
    }

    public void setArea(long area) {
        this.area = area;
    }

    public long getTypeMeetingRoom() {
        return typeMeetingRoom;
    }

    public void setTypeMeetingRoom(long typeMeetingRoom) {
        this.typeMeetingRoom = typeMeetingRoom;
    }

    public long getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(long roomStatus) {
        this.roomStatus = roomStatus;
    }
}