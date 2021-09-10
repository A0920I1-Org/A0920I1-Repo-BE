package com.example.a0920i1_meetingroom_be.services;

import com.example.a0920i1_meetingroom_be.models.entity.Equipment;
import com.example.a0920i1_meetingroom_be.models.entity.OrderEquipment;

import java.util.List;

public interface OrderEquipmentService {
    List<OrderEquipment> showDetailsMeetingRoom(long id);
}
