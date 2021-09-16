package com.example.a0920i1_meetingroom_be.services.Impl;

import com.example.a0920i1_meetingroom_be.models.entity.MeetingRoom;
import com.example.a0920i1_meetingroom_be.repositories.MeetingRoomRepository;
import com.example.a0920i1_meetingroom_be.services.MeetingRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
//tri NH
@Service
public class MeetingRoomServiceImpl implements MeetingRoomService {
    @Autowired
    private MeetingRoomRepository meetingRoomRepository;



    @Override
    public List<MeetingRoom> findMeetingRoomAll() {
        return meetingRoomRepository.findMeetingRoomAll();
    }
}
