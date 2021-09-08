package com.example.a0920i1_meetingroom_be.models.dto;


import java.util.List;

public class UpdateMeeting {

    private long id;

    private String name;

    private Integer floors;

    private String image_url;

    private Area area;

    private List<Equipment> equipments;

    private TypeMeetingRoom typeMeetingRoom;

    private RoomStatus roomStatus;

    public UpdateMeeting() {
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public List<Equipment> getEquipments() {
        return equipments;
    }

    public void setEquipments(List<Equipment> equipments) {
        this.equipments = equipments;
    }

    public TypeMeetingRoom getTypeMeetingRoom() {
        return typeMeetingRoom;
    }

    public void setTypeMeetingRoom(TypeMeetingRoom typeMeetingRoom) {
        this.typeMeetingRoom = typeMeetingRoom;
    }

    public RoomStatus getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(RoomStatus roomStatus) {
        this.roomStatus = roomStatus;
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

    public Integer getFloors() {
        return floors;
    }

    public void setFloors(Integer floors) {
        this.floors = floors;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

}
