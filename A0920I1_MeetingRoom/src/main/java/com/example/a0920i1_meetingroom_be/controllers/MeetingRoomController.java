package com.example.a0920i1_meetingroom_be.controllers;

import com.example.a0920i1_meetingroom_be.models.entity.MeetingRoom;
import com.example.a0920i1_meetingroom_be.services.MeetingRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping("/meetingRooms")
public class MeetingRoomController {
    @Autowired
    MeetingRoomService meetingRoomService;
    //AnhLT
    @GetMapping("")
    public List<MeetingRoom> getMeetingRoom(){
        return meetingRoomService.getMeetingRooms();
    }
}
