package com.example.a0920i1_meetingroom_be.services.Impl;

import com.example.a0920i1_meetingroom_be.models.entity.Equipment;
import com.example.a0920i1_meetingroom_be.models.entity.OrderEquipment;
import com.example.a0920i1_meetingroom_be.repositories.OrderEquipmentRepository;
import com.example.a0920i1_meetingroom_be.services.OrderEquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderEquipmentServiceImpl implements OrderEquipmentService {
    @Autowired
    OrderEquipmentRepository equipmentRepository;

    @Override
    public List<OrderEquipment> showDetailsMeetingRoom(long id) {
        return equipmentRepository.showDetailsMeetingRoom(id);
    }
}
