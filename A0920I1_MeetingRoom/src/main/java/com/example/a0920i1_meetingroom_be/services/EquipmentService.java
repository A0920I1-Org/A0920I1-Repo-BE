package com.example.a0920i1_meetingroom_be.services;

import com.example.a0920i1_meetingroom_be.models.entity.Equipment;

import java.util.List;

public interface EquipmentService {

    List<Equipment> listEquipment();
    List<Equipment> findEquipmentByName(String name);
}
