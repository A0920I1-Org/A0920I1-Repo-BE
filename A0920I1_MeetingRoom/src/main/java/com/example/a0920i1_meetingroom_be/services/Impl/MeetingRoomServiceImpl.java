package com.example.a0920i1_meetingroom_be.services.Impl;

import com.example.a0920i1_meetingroom_be.models.entity.Equipment;
import com.example.a0920i1_meetingroom_be.models.entity.MeetingRoom;
import com.example.a0920i1_meetingroom_be.models.entity.OrderEquipment;
import com.example.a0920i1_meetingroom_be.repositories.MeetingRoomRepository;
import com.example.a0920i1_meetingroom_be.services.MeetingRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MeetingRoomServiceImpl implements MeetingRoomService {

    @Autowired
    MeetingRoomRepository meetingRoomRepository;

    @Override
    public Page<MeetingRoom> findAllMeetingRoom(Pageable pageable) {
        return meetingRoomRepository.findAll(pageable);
    }

    @Override
    public List<MeetingRoom> findAll() {
        return meetingRoomRepository.findAll();
    }

    @Override
    public void saveMeetingRoom(MeetingRoom meetingRoom) {
        this.meetingRoomRepository.save(meetingRoom);
    }

    @Override
    public List<MeetingRoom> showDetailMeetingRoom(long id) {
        return this.meetingRoomRepository.showDetailsMeetingRoom(id);
    }

    @Override
    public List<Equipment> listOrderEquipment() {
        return meetingRoomRepository.listOrderEquipment();
    }
}
