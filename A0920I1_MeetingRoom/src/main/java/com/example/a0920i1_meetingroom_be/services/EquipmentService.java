package com.example.a0920i1_meetingroom_be.services;


import com.example.a0920i1_meetingroom_be.models.dto.EquipmentDto;
import com.example.a0920i1_meetingroom_be.models.entity.Equipment;

import java.util.List;

public interface EquipmentService {

    //PhapNT
    List<Equipment> getAllEquipment();
    //PhapNT
    Equipment findById(long id);
    //PhapNT
    void createEquipment(EquipmentDto equipmentDto);
    //PhapNT
    Equipment showDetailEquipment(long id);
    //PhapNT
    void deleteEquipmentById(long id);
    //PhapNT
    void updateEquipment(EquipmentDto equipmentDto);
    //PhapNT
    List<Equipment> searchName(String name);

    // huệ tạo ngày 9/9/2021, chức năng trả về danh sách tài sản
    List<Equipment> listEquipment();

    // huệ tạo ngày 9/9/2021, chức năng tìm kiếm tài sản theo tên
    List<Equipment> findEquipmentByName(String name);

}
