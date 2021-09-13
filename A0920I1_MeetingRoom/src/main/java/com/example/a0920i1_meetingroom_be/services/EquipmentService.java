package com.example.a0920i1_meetingroom_be.services;

import com.example.a0920i1_meetingroom_be.models.dto.EquipmentDto;
import com.example.a0920i1_meetingroom_be.models.entity.Equipment;

import java.util.List;

public interface EquipmentService {
    List<Equipment> getAllEquipment();
    Equipment findById(long id);
    void createEquipment(EquipmentDto equipmentDto);
    Equipment showDetailEquipment(long id);
    void deleteEquipmentById(long id);
    void updateEquipment(EquipmentDto equipmentDto);
    List<Equipment> searchName(String name);
}
