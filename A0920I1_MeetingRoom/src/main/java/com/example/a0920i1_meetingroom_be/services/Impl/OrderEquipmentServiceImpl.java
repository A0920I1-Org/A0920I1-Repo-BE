package com.example.a0920i1_meetingroom_be.services.Impl;

import com.example.a0920i1_meetingroom_be.models.entity.OrderEquipment;
import com.example.a0920i1_meetingroom_be.repositories.OrderEquipmentRepository;
import com.example.a0920i1_meetingroom_be.services.OrderEquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class OrderEquipmentServiceImpl implements OrderEquipmentService {
    @Autowired
    OrderEquipmentRepository orderEquipmentRepository;
    @Override
    public List<OrderEquipment> getAllOrderEquipment() {
        return orderEquipmentRepository.findAll();
    }
}
