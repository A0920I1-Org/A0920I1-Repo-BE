package com.example.a0920i1_meetingroom_be.models.dto;

public class TypeMeetingRoomDto {

    private long id;

    private String name;

    private Integer capacity;

    public TypeMeetingRoomDto() {
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

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }
}
