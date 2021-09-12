package com.example.a0920i1_meetingroom_be.controllers;

import com.example.a0920i1_meetingroom_be.models.entity.RoomStatus;
import com.example.a0920i1_meetingroom_be.services.RoomStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class RoomStatusController {
    @Autowired
    RoomStatusService roomStatusService;

    // list
    @GetMapping("/listRoomStatus")
    public List<RoomStatus> getRoomStatusList(){
        return roomStatusService.getRoomStatus();
    }
}
