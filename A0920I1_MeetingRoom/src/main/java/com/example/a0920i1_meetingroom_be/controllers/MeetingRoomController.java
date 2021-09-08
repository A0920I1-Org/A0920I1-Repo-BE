package com.example.a0920i1_meetingroom_be.controllers;

import com.example.a0920i1_meetingroom_be.models.dto.UpdateMeeting;
import com.example.a0920i1_meetingroom_be.models.entity.*;
import com.example.a0920i1_meetingroom_be.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController("")
public class MeetingRoomController {
    @Autowired
    MeetingRoomService meetingRoomService ;

    @Autowired
    RoomStatusService roomStatusService ;

    @Autowired
    TypeMeetingRoomService typeMeetingRoomService ;

    @Autowired
    AreaService areaService ;

    @Autowired
    EquipmentService equipmentService ;


    // Get All Meeting Room
    @GetMapping(value = "/list")
//    @GetMapping
    public ResponseEntity<List<MeetingRoom>>getAllListMeetingRoom(){
        List<MeetingRoom> meetingRooms = meetingRoomService.findAllMeetingRoom();
        if(meetingRooms.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(meetingRooms,HttpStatus.OK);
        }
//        return meetingRooms ;
    }

    // Get By Id Meeting Room
//    @GetMapping("/meeting-room/{id}")
    @GetMapping("/{id}")
    public MeetingRoom getById(@PathVariable("id") long id){
        System.out.println("success!");
        MeetingRoom meetingRoom = meetingRoomService.findById(id);

        return meetingRoom ;
//        if (meetingRoom == null) {
//
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(meetingRoom, HttpStatus.OK);
    }

    // Update Meeting Room
    @PutMapping( value = "/meeting-room-edit/{id}")
    public ResponseEntity<MeetingRoom> updateMeetingRoom(@PathVariable("id") long id , @RequestBody MeetingRoom meetingRoom){
        MeetingRoom meetingRoom1 = meetingRoomService.findById(id);
        if (meetingRoom1 == null){
            System.out.println("Id  " + id + "not  found");
            return new ResponseEntity<MeetingRoom>(HttpStatus.NOT_FOUND);
        }
        meetingRoom1.setName(meetingRoom.getName());
        meetingRoom1.setFloors(meetingRoom.getFloors());
        meetingRoom1.setArea(meetingRoom.getArea());
        meetingRoom1.setRoomStatus(meetingRoom.getRoomStatus());
        meetingRoom1.setTypeMeetingRoom(meetingRoom.getTypeMeetingRoom());
        meetingRoom1.setImage_url(meetingRoom.getImage_url());
//        meetingRoom1.setId(meetingRoom.getId());

        meetingRoomService.updateMeetingRoom(meetingRoom1);
        return  new ResponseEntity<>(meetingRoom1,HttpStatus.OK);
    }

    @GetMapping(value = "/listArea")
    public List<Area> getAllListArea(){
        List<Area> areas = areaService.findAllArea();
        return areas ;
    }

    @GetMapping(value = "/listTypeMeetingRoom")
    public List<TypeMeetingRoom> getAllListTypeMeetingRoom(){
        List<TypeMeetingRoom> typeMeetingRooms = typeMeetingRoomService.findAllTypeMeetingRoom();
        return typeMeetingRooms ;
    }

    @GetMapping(value = "/listRoomStatus")
    public List<RoomStatus> getAllRoomStatus(){
        List<RoomStatus> roomStatuses = roomStatusService.findAllRoomStatus();
        return roomStatuses ;
    }

    @GetMapping(value = "/listEquipment")
    public List<Equipment> getAllEquipment(){
        List<Equipment> equipment = equipmentService.findAllEquipment();
        return equipment ;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        meetingRoomService.deleteMeetingRoom(id);
    }

    @PutMapping( value = "/meeting-room/{id}")
    public ResponseEntity<?> updateMeeting(@PathVariable("id") long id , @RequestBody UpdateMeeting meetingRoom){
        System.out.println("Hello");

            return new ResponseEntity<MeetingRoom>(HttpStatus.NOT_FOUND);
    }
}
