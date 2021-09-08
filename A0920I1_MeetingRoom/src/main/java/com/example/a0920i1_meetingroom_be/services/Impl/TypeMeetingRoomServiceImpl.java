package com.example.a0920i1_meetingroom_be.services.Impl;

import com.example.a0920i1_meetingroom_be.models.entity.TypeMeetingRoom;
import com.example.a0920i1_meetingroom_be.repositories.TypeMeetingRoomRepository;
import com.example.a0920i1_meetingroom_be.services.TypeMeetingRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeMeetingRoomServiceImpl implements TypeMeetingRoomService {
    @Autowired
    private TypeMeetingRoomRepository typeMeetingRoomRepository ;
    @Override
    public List<TypeMeetingRoom> findAllTypeMeetingRoom() {
        return typeMeetingRoomRepository.findAll();
    }
}
