package com.example.a0920i1_meetingroom_be.controllers;

import com.example.a0920i1_meetingroom_be.models.entity.MeetingRoom;
import com.example.a0920i1_meetingroom_be.services.MeetingRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/meetingRooms")
public class MeetingroomController {
    @Autowired
    MeetingRoomService meetingRoomService;

    @GetMapping("/nameMeetingRooms")
    public List<String> getNameMeetingRooms(){
        return meetingRoomService.getNameMeetingRooms();
    }

    @GetMapping("")
    public List<MeetingRoom> getMeetingRoom(){
        return meetingRoomService.getMeetingRooms();
    }
}
