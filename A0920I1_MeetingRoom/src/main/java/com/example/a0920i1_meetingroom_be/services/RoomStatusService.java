package com.example.a0920i1_meetingroom_be.services;

import com.example.a0920i1_meetingroom_be.models.entity.RoomStatus;

import java.util.List;

public interface RoomStatusService {
    List<RoomStatus> findAllRoomStatus();
}
