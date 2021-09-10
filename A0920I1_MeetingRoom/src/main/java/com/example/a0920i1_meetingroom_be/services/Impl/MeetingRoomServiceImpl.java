package com.example.a0920i1_meetingroom_be.services.Impl;

import com.example.a0920i1_meetingroom_be.models.entity.Equipment;
import com.example.a0920i1_meetingroom_be.models.entity.MeetingRoom;
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
    public void saveMeetingRoom(String name, int floors, String image_url, long area_id , long room_status_id, long type_meeting_room_id) {
        this.meetingRoomRepository.saveMeeting(name, floors, image_url, area_id, room_status_id, type_meeting_room_id);
    }

    @Override
    public List<MeetingRoom> showDetailMeetingRoom(long id) {
        return this.meetingRoomRepository.showDetailMeetingRoom(id);
    }

    @Override
    public List<Equipment> listOrderEquipment() {
        return meetingRoomRepository.listOrderEquipment();
    }
}
