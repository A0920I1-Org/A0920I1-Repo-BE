package com.example.a0920i1_meetingroom_be.controllers;

import com.example.a0920i1_meetingroom_be.models.entity.*;
import com.example.a0920i1_meetingroom_be.services.AreaService;
import com.example.a0920i1_meetingroom_be.services.MeetingRoomService;
import com.example.a0920i1_meetingroom_be.services.RoomStatusService;
import com.example.a0920i1_meetingroom_be.services.TypeMeetingRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/meeting")
@CrossOrigin(origins = "http://localhost:4200")
public class MeetingroomController {

    @Autowired
    MeetingRoomService meetingRoomService;

    @Autowired
    AreaService areaService;

    @Autowired
    TypeMeetingRoomService typeMeetingRoomService;

    @Autowired
    RoomStatusService roomStatusService;

    @GetMapping("equipment")
    public List<Equipment> findAllEquipment(){
        System.out.println("equipment ");
        return meetingRoomService.listOrderEquipment();
    }

    @GetMapping("area")
    public List<Area> findAllArea(){
        return areaService.findAll();
    }

    @GetMapping("typeMeeting")
    public List<TypeMeetingRoom> findAllTypeMeetingRoom(){
        return typeMeetingRoomService.findAll();
    }

    @GetMapping("status")
    public List<RoomStatus> findAlRoomStatusl(){
        return roomStatusService.findAll();
    }

    @PostMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE})
//    @PostMapping(value = "/create")
    public ResponseEntity<?> createMeetingRoom(@RequestBody MeetingRoom meetingRoom){
        // validate
        System.out.println("start create");
        meetingRoomService.saveMeetingRoom(meetingRoom);
        System.out.println("Create success!!");
        return new ResponseEntity<>( HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public List<MeetingRoom> showDetailsMeetingRoom(@PathVariable("id") long id){
        System.out.println("success!");
        return meetingRoomService.showDetailMeetingRoom(id);
    }

//    @GetMapping("")
//    public Page<MeetingRoom> getAllMeetingRoom(@PageableDefault(value = 5) Pageable pageable){
//        System.out.println("success!");
//        return meetingRoomService.findAllMeetingRoom(pageable);
//    }

    @GetMapping("")
    public List<MeetingRoom> getAllMeetingRoom(){
        System.out.println("success!");
        return meetingRoomService.findAll();
    }
}
