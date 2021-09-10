package com.example.a0920i1_meetingroom_be.controllers;

import com.example.a0920i1_meetingroom_be.models.dto.MeetingRoomDto;
import com.example.a0920i1_meetingroom_be.models.entity.*;
import com.example.a0920i1_meetingroom_be.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/meeting")
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


    // Lấy danh sách phòng họp (Hoàng)
//    @GetMapping(value = "/list")
    @GetMapping
    public List<MeetingRoom>getAllListMeetingRoom(){
        List<MeetingRoom> meetingRooms = meetingRoomService.findAllMeetingRoom();
//        if(meetingRooms.isEmpty()){
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }else {
//            return new ResponseEntity<>(meetingRooms,HttpStatus.OK);
//        }
        return meetingRooms ;
    }

    // Lấy dữ liệu theo Id (Hoàng)
//    @GetMapping("/meeting-room/{id}")
    @GetMapping("{id}")
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
    public ResponseEntity<MeetingRoom> updateMeetingRoom(@PathVariable("id") long id , @RequestBody MeetingRoomDto meetingRoomDto){

        meetingRoomService.updateMeeting(meetingRoomDto.getName(),meetingRoomDto.getFloors(),meetingRoomDto.getArea(),meetingRoomDto.getRoomStatus(),
                meetingRoomDto.getTypeMeetingRoom(),meetingRoomDto.getImage_url(),meetingRoomDto.getId());
        return  new ResponseEntity<>( HttpStatus.OK);
    }


    @GetMapping(value = "area")
    public List<Area> getAllListArea(){
        List<Area> areas = areaService.findAllArea();
        return areas ;
    }

    @GetMapping(value = "typeMeetingRoom")
    public List<TypeMeetingRoom> getAllListTypeMeetingRoom(){
        List<TypeMeetingRoom> typeMeetingRooms = typeMeetingRoomService.findAllTypeMeetingRoom();
        return typeMeetingRooms ;
    }

    @GetMapping(value = "roomStatus")
    public List<RoomStatus> getAllRoomStatus(){
        List<RoomStatus> roomStatuses = roomStatusService.findAllRoomStatus();
        return roomStatuses ;
    }

    @GetMapping(value = "equipment")
    public List<Equipment> getAllEquipment(){
        List<Equipment> equipment = equipmentService.findAllEquipment();
        return equipment ;
    }

    @DeleteMapping("{id}")
    public ResponseEntity<MeetingRoom>delete(@PathVariable long id){
        System.out.println("Xoa thanh cong id " + id) ;
        meetingRoomService.deleteMeeting(id);
//        MeetingRoom user = meetingRoomService.findById(id);
//        if (user == null) {
//            System.out.println("Unable to delete. User with id " + id + " not found");
//            return new ResponseEntity<MeetingRoom>(HttpStatus.NOT_FOUND);
//        }
//
//        meetingRoomService.deleteMeetingRoom(id);
        return new ResponseEntity<MeetingRoom>(HttpStatus.NO_CONTENT);
    }

//    @PutMapping( value = "/meeting-room/{id}")
//    public ResponseEntity<?> updateMeeting(@PathVariable("id") long id , @RequestBody UpdateMeeting meetingRoom){
//        System.out.println("Hello");
//
//            return new ResponseEntity<MeetingRoom>(HttpStatus.NOT_FOUND);
//    }
}
