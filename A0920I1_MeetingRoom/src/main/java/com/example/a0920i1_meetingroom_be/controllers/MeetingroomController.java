package com.example.a0920i1_meetingroom_be.controllers;
import com.example.a0920i1_meetingroom_be.models.entity.MeetingRoom;
import com.example.a0920i1_meetingroom_be.services.MeetingRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
//lay danh sach meetingroom TriNH
public class MeetingroomController {
    @Autowired
    private MeetingRoomService meetingRoomService;


//lay danh sach meetingroom TriNH

    @GetMapping("/meetingroom")
    public ResponseEntity<List<MeetingRoom>> getAllMeetingRoom() {
        List<MeetingRoom> meetingRoom = meetingRoomService.findMeetingRoomAll();
        return new ResponseEntity<>(meetingRoom, HttpStatus.OK);
    }


}
