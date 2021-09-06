package com.example.a0920i1_meetingroom_be.models.dto;

public class RegisterHistory {
    private String idMeetingRoom;
    private String dateCheckin;
    private String dateCheckout;
    private String idStatusRoom;
    private String idTypeRoom;
    private String createDate;

    public String getIdMeetingRoom() {
        return idMeetingRoom;
    }

    public void setIdMeetingRoom(String idMeetingRoom) {
        this.idMeetingRoom = idMeetingRoom;
    }

    public String getDateCheckin() {
        return dateCheckin;
    }

    public void setDateCheckin(String dateCheckin) {
        this.dateCheckin = dateCheckin;
    }

    public String getDateCheckout() {
        return dateCheckout;
    }

    public void setDateCheckout(String dateCheckout) {
        this.dateCheckout = dateCheckout;
    }

    public String getIdStatusRoom() {
        return idStatusRoom;
    }

    public void setIdStatusRoom(String idStatusRoom) {
        this.idStatusRoom = idStatusRoom;
    }

    public String getIdTypeRoom() {
        return idTypeRoom;
    }

    public void setIdTypeRoom(String idTypeRoom) {
        this.idTypeRoom = idTypeRoom;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
}
