package com.example.a0920i1_meetingroom_be.services.Impl;

import com.example.a0920i1_meetingroom_be.models.entity.RoomStatus;
import com.example.a0920i1_meetingroom_be.repositories.RoomStatusRepository;
import com.example.a0920i1_meetingroom_be.services.RoomStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomStatusServiceImpl implements RoomStatusService {
    @Autowired
    RoomStatusRepository roomStatusRepository;

    @Override
    public List<RoomStatus> getRoomStatus() {
        return roomStatusRepository.findAll();
    }
}
