package com.example.a0920i1_meetingroom_be.models.dto;

public class RoomStatusDto {
    private long id;

    private String name;

    public RoomStatusDto() {
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
}
