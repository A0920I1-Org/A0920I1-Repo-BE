package com.example.a0920i1_meetingroom_be.controllers;

import com.example.a0920i1_meetingroom_be.models.entity.MeetingRoom;
import com.example.a0920i1_meetingroom_be.services.MeetingRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("")
@CrossOrigin(origins = "http://localhost:4200")
public class MeetingroomController {

    @Autowired
    MeetingRoomService meetingRoomService;

    @PostMapping(value = "/create", consumes = "application/json;charset=UTF-8", produces = "application/json;charset=UTF-8")
//    @PostMapping(value = "/create")
    public void createMeetingRoom(@RequestBody MeetingRoom meetingRoom){
        // validate
        System.out.println("start create");
        meetingRoomService.saveMeetingRoom(meetingRoom);
        System.out.println("Create success!!");
//        return new ResponseEntity<>( HttpStatus.OK);
    }

    @GetMapping("/details/{id}")
    public List<MeetingRoom> showDetailsMeetingRoom(@PathVariable("id") long id){
        System.out.println("success!");
        return meetingRoomService.showDetailMeetingRoom(id);
    }
}
