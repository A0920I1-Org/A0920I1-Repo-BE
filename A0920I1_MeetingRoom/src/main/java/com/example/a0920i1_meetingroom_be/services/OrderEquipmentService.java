package com.example.a0920i1_meetingroom_be.services;

import com.example.a0920i1_meetingroom_be.models.entity.OrderEquipment;

import java.util.List;

public interface OrderEquipmentService {

    // huệ tạo ngày 9/9/2021, chức năng thêm mới 1 order tài sản
    void insertOrderEquipment(long quantity, long equipment_id, long meeting_room_id);

    // huệ tạo ngày 9/9/2021, chức năng trả về danh sách tài sản theo id
    List<OrderEquipment> listEquipmentByIdMeeting(long id);

}
