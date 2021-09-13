package com.example.a0920i1_meetingroom_be.services.Impl;

import com.example.a0920i1_meetingroom_be.models.dto.EquipmentDto;
import com.example.a0920i1_meetingroom_be.models.entity.Equipment;
import com.example.a0920i1_meetingroom_be.repositories.EquipmentRepository;
import com.example.a0920i1_meetingroom_be.repositories.OrderEquipmentRepository;
import com.example.a0920i1_meetingroom_be.services.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipmentServiceImpl  implements EquipmentService {
    @Autowired
    EquipmentRepository equipmentRepository;
    @Autowired
    OrderEquipmentRepository orderEquipmentRepository;

    @Override
    public List<Equipment> getAllEquipment() {
        return equipmentRepository.findAllEquipment();
    }

    @Override
    public Equipment findById(long id) {
        return equipmentRepository.findById(id).orElse(null);
    }

    @Override
    public void createEquipment(EquipmentDto equipmentDto) {
        equipmentRepository.createEquipment(equipmentDto.getName(),equipmentDto.getStock(),
                equipmentDto.getRepairQuantity(),equipmentDto.getImageUrl());
    }

    @Override
    public Equipment showDetailEquipment(long id) {
        return equipmentRepository.showDetailEquipment(id);
    }

    @Override
    public void deleteEquipmentById(long id) {
        orderEquipmentRepository.deleteOrderEquipmentById(id);
        equipmentRepository.deleteEquipmentById(id);
    }

    @Override
    public void updateEquipment(EquipmentDto equipmentDto) {
        equipmentRepository.updateEquipment(equipmentDto.getName(),equipmentDto.getStock(),
                equipmentDto.getRepairQuantity(),equipmentDto.getImageUrl(),equipmentDto.getId());
    }

    @Override
    public List<Equipment> searchName(String name) {
        return equipmentRepository.searchName(name);
    }
}
