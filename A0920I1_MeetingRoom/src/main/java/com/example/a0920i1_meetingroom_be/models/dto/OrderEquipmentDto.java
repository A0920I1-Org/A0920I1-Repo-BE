package com.example.a0920i1_meetingroom_be.models.dto;

public class OrderEquipmentDto {
    private long quantity;
    private long equipment_id;
    private long meeting_room_id;

    public OrderEquipmentDto(){

    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public long getEquipment_id() {
        return equipment_id;
    }

    public void setEquipment_id(long equipment_id) {
        this.equipment_id = equipment_id;
    }

    public long getMeeting_room_id() {
        return meeting_room_id;
    }

    public void setMeeting_room_id(long meeting_room_id) {
        this.meeting_room_id = meeting_room_id;
    }
}
