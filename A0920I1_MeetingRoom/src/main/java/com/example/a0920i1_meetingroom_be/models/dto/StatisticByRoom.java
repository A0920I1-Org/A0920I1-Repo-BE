package com.example.a0920i1_meetingroom_be.models.dto;

public class StatisticByRoom {
    private String idTypeMeetingRoom;
    private String idMeetingRoom;
    private String month;
    private String year;

    public String getIdTypeMeetingRoom() {
        return idTypeMeetingRoom;
    }

    public void setIdTypeMeetingRoom(String idTypeMeetingRoom) {
        this.idTypeMeetingRoom = idTypeMeetingRoom;
    }

    public String getIdMeetingRoom() {
        return idMeetingRoom;
    }

    public void setIdMeetingRoom(String idMeetingRoom) {
        this.idMeetingRoom = idMeetingRoom;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public StatisticByRoom(String idTypeMeetingRoom, String idMeetingRoom, String month, String year) {
        this.idTypeMeetingRoom = idTypeMeetingRoom;
        this.idMeetingRoom = idMeetingRoom;
        this.month = month;
        this.year = year;
    }
}
