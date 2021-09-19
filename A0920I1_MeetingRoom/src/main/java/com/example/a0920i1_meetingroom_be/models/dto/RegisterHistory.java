package com.example.a0920i1_meetingroom_be.models.dto;
//AnhLT
public class RegisterHistory {
    private String nameRoom;
    private String dateCheckin;
    private String dateCheckout;
    private String statusRoom;
    private String idTypeMeetingRoom;
    private String createDate;

    public String getNameRoom() {
        return nameRoom;
    }

    public void setNameRoom(String nameRoom) {
        this.nameRoom = nameRoom;
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

    public String getStatusRoom() {
        return statusRoom;
    }

    public void setStatusRoom(String statusRoom) {
        this.statusRoom = statusRoom;
    }

    public String getIdTypeMeetingRoom() {
        return idTypeMeetingRoom;
    }

    public void setIdTypeMeetingRoom(String idTypeMeetingRoom) {
        this.idTypeMeetingRoom = idTypeMeetingRoom;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
}
