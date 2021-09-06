package com.example.a0920i1_meetingroom_be.services.Impl;

import com.example.a0920i1_meetingroom_be.models.entity.MeetingRoom;
import com.example.a0920i1_meetingroom_be.repositories.MeetingRoomRepository;
import com.example.a0920i1_meetingroom_be.services.MeetingRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MeetingRoomServiceImpl implements MeetingRoomService {

    @Autowired
    MeetingRoomRepository meetingRoomRepository;

    @Override
    public void saveMeetingRoom(MeetingRoom meetingRoom) {
        this.meetingRoomRepository.save(meetingRoom);
    }

    @Override
    public List<MeetingRoom> showDetailMeetingRoom(long id) {
        return this.meetingRoomRepository.showDetailsMeetingRoom(id);
    }
}
