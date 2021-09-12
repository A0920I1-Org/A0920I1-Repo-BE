package com.example.a0920i1_meetingroom_be.controllers;

import com.example.a0920i1_meetingroom_be.models.entity.TypeMeetingRoom;
import com.example.a0920i1_meetingroom_be.services.TypeMeetingRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class TypeMeetingRoomController {
    @Autowired
    TypeMeetingRoomService typeMeetingRoomService;

    //display list
    @GetMapping("/listTypeMeetingRoom")
    public List<TypeMeetingRoom> getTypeMeetingRoomList(){
        return typeMeetingRoomService.getTypeMeetingRoom();
    }
}
