package com.example.a0920i1_meetingroom_be.services.Impl;

import com.example.a0920i1_meetingroom_be.models.entity.Area;
import com.example.a0920i1_meetingroom_be.models.entity.MeetingRoom;
import com.example.a0920i1_meetingroom_be.models.entity.RoomStatus;
import com.example.a0920i1_meetingroom_be.models.entity.TypeMeetingRoom;
import com.example.a0920i1_meetingroom_be.repositories.MeetingRoomRepository;
import com.example.a0920i1_meetingroom_be.services.MeetingRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.List;

@Service
public class MeetingRoomServiceImpl implements MeetingRoomService {
    @Autowired
    private MeetingRoomRepository meetingRoomRepository ;

    @Override
    public List<MeetingRoom> findAllMeetingRoom() {
        return this.meetingRoomRepository.findAllMeetingRoom();
    }

    @Override
    public MeetingRoom findById(long id) {
        return this.meetingRoomRepository.findByIdMeetingRoom(id);
    }

    @Override
    public void updateMeetingRoom(MeetingRoom meetingRoom) {
        meetingRoomRepository.save(meetingRoom);
    }

    @Override
    public void deleteMeetingRoom(long id) {
        meetingRoomRepository.deleteById(id);
    }



}
