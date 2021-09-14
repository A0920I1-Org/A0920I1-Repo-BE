package com.example.a0920i1_meetingroom_be.services;

import com.example.a0920i1_meetingroom_be.models.entity.OrderEquipment;

import java.util.List;

public interface OrderEquipmentService {
    OrderEquipment showDetailsMeetingRoom(long id);

    void insertOrderEquipment(long quantity, long equipment_id, long meeting_room_id);

    List<OrderEquipment> listEquipmentByIdMeeting(long id);

}
