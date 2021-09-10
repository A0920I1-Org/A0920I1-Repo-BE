package com.example.a0920i1_meetingroom_be.models.dto;

import com.example.a0920i1_meetingroom_be.models.entity.Area;
import com.example.a0920i1_meetingroom_be.models.entity.RoomStatus;
import com.example.a0920i1_meetingroom_be.models.entity.TypeMeetingRoom;

import java.util.List;

public class MeetingRoomDto {
    private long id;

    private String name;
    private int floors;
    private String imageUrl;
    private long areaDto;
    private long roomStatusDto;
//    private List<EquipmentDto> equipmentDtoList;
    private long typeMeetingRoomDto;

    public MeetingRoomDto() {
    }

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

    public int getFloors() {
        return floors;
    }

    public void setFloors(int floors) {
        this.floors = floors;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public long getAreaDto() {
        return areaDto;
    }

    public void setAreaDto(long areaDto) {
        this.areaDto = areaDto;
    }

    public long getRoomStatusDto() {
        return roomStatusDto;
    }

    public void setRoomStatusDto(long roomStatusDto) {
        this.roomStatusDto = roomStatusDto;
    }

    public long getTypeMeetingRoomDto() {
        return typeMeetingRoomDto;
    }

    public void setTypeMeetingRoomDto(long typeMeetingRoomDto) {
        this.typeMeetingRoomDto = typeMeetingRoomDto;
    }

    //    private AreaDto areaDto;


}
