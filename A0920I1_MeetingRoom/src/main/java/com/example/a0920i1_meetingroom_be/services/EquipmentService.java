package com.example.a0920i1_meetingroom_be.services;

import com.example.a0920i1_meetingroom_be.models.entity.Equipment;

import java.util.List;

public interface EquipmentService {
    // huệ tạo ngày 9/9/2021, chức năng trả về danh sách tài sản
    List<Equipment> listEquipment();

    // huệ tạo ngày 9/9/2021, chức năng tìm kiếm tài sản theo tên
    List<Equipment> findEquipmentByName(String name);
}
