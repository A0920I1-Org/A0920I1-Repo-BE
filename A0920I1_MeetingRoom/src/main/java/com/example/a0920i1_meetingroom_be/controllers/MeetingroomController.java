package com.example.a0920i1_meetingroom_be.controllers;

import com.example.a0920i1_meetingroom_be.models.entity.MeetingRoom;
import com.example.a0920i1_meetingroom_be.services.MeetingRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/meetingRooms")
public class MeetingroomController {
    @Autowired
    MeetingRoomService meetingRoomService;

    @GetMapping("")
    public List<MeetingRoom> getMeetingRoom(){
        return meetingRoomService.getMeetingRooms();
    }

    @PutMapping("/update")
    public MeetingRoom update(@RequestBody MeetingRoom meetingRoom){
        System.out.println("hello");
        return null;
    }
}
