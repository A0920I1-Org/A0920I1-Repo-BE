package com.example.a0920i1_meetingroom_be.services.Impl;

import com.example.a0920i1_meetingroom_be.models.entity.Equipment;
import com.example.a0920i1_meetingroom_be.repositories.EquipmentRepository;
import com.example.a0920i1_meetingroom_be.services.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipmentServiceImpl  implements EquipmentService {
    @Autowired
    EquipmentRepository equipmentRepository;

    @Override
    public List<Equipment> getAllEquipment() {
        return equipmentRepository.findAll();
    }

    @Override
    public void save(Equipment equipment) {
        equipmentRepository.save(equipment);
    }

    @Override
    public void delete(long id) {
        equipmentRepository.deleteById(id);
    }

    @Override
    public Equipment findById(long id) {
        return equipmentRepository.findById(id).orElse(null);
    }
}
