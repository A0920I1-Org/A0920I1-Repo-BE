package com.example.a0920i1_meetingroom_be.controllers;

import com.example.a0920i1_meetingroom_be.models.dto.MeetingRoomDto;
import com.example.a0920i1_meetingroom_be.models.entity.*;
import com.example.a0920i1_meetingroom_be.services.*;
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
    OrderEquipmentService orderEquipmentService;

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
    public List<RoomStatus> findAlRoomStatus(){
        return roomStatusService.findAll();
    }



    @PostMapping(value = "")
    public ResponseEntity<?> createMeeting(@RequestBody MeetingRoomDto meetingRoom){
        System.out.println("aaa");

        meetingRoomService.saveMeetingRoom(meetingRoom.getName(),
                meetingRoom.getFloors(),
                meetingRoom.getImageUrl(),
                meetingRoom.getAreaDto(),
                meetingRoom.getRoomStatusDto(),
                meetingRoom.getTypeMeetingRoomDto());

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public List<OrderEquipment> showDetailsMeetingRoom(@PathVariable("id") long id){
        System.out.println("success!");
        return orderEquipmentService.showDetailsMeetingRoom(id);
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
