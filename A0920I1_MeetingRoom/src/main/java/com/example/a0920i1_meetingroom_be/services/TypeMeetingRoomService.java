package com.example.a0920i1_meetingroom_be.services;

import com.example.a0920i1_meetingroom_be.models.entity.TypeMeetingRoom;

import java.util.List;

public interface TypeMeetingRoomService {


    // lấy danh sách loại phòng (Hoàng)
    List<TypeMeetingRoom> findAllTypeMeetingRoom();

}
