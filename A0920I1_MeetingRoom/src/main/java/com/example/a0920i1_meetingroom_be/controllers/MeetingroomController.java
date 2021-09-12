package com.example.a0920i1_meetingroom_be.controllers;

import com.example.a0920i1_meetingroom_be.models.dto.MeetingRoomDto;
import com.example.a0920i1_meetingroom_be.models.entity.*;
import com.example.a0920i1_meetingroom_be.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/meeting")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class MeetingroomController {

    @Autowired
    MeetingRoomService meetingRoomService;

    @Autowired
    OrderEquipmentService orderEquipmentService;

    @Autowired
    AreaService areaService;

    @Autowired
    EquipmentService equipmentService;

    @Autowired
    TypeMeetingRoomService typeMeetingRoomService;

    @Autowired
    RoomStatusService roomStatusService;

    // huệ tạo 9/9/2021, chức năng hiển thị danh sách tài sản
    @GetMapping("equipment")
    public List<Equipment> findAllEquipment(){
        System.out.println("aaa");
        return equipmentService.listEquipment();
    }

    // huệ tạo 9/9/2021, chức năng hiển thị danh sách khu vực phòng họp
    @GetMapping("area")
    public List<Area> findAllArea(){
        return areaService.findAll();
    }

    // huệ tạo 9/9/2021, chức năng hiển thị danh sách kiểu loại phòng họp
    @GetMapping("typeMeeting")
    public List<TypeMeetingRoom> findAllTypeMeetingRoom(){
        return typeMeetingRoomService.findAll();
    }

    // huệ tạo 9/9/2021, chức năng hiển thị danh sách trạng thái phòng họp
    @GetMapping("status")
    public List<RoomStatus> findAlRoomStatus(){
        return roomStatusService.findAll();
    }

    // huệ tạo 9/9/2021, chức năng thêm mới phòng họp bằng cách sử dụng đối tượng dto
    @PostMapping(value = "")
    public ResponseEntity<?> createMeeting(@RequestBody MeetingRoomDto meetingRoom){

        meetingRoomService.saveMeetingRoom(meetingRoom.getName(),
                meetingRoom.getFloors(),
                meetingRoom.getImageUrl(),
                meetingRoom.getAreaDto(),
                meetingRoom.getRoomStatusDto(),
                meetingRoom.getTypeMeetingRoomDto());

        return new ResponseEntity<>(HttpStatus.OK);
    }

    // huệ tạo 9/9/2021, chức năng hiển thị phòng họp chi tiết
//    @GetMapping("/details-meeting-room/{id}")
//    public OrderEquipment showDetailsMeetingRoom(@PathVariable("id") long id){
//        return orderEquipmentService.showDetailsMeetingRoom(id);
//    }
    @GetMapping("/details-meeting-room/{id}")
    public MeetingRoom showDetailsMeetingRoom(@PathVariable("id") long id){
        return meetingRoomService.showDetailMeetingRoom(id);
    }

    // huệ tạo 9/9/2021, chức năng hiển thị danh sách phòng họp
    @GetMapping("")
    public List<MeetingRoom> getAllMeetingRoom(){
        return meetingRoomService.findAll();
    }

    @GetMapping("/equipment/{id}")
    public List<OrderEquipment> getAllEquipmentByIdMeetingRoom(@PathVariable(value = "id") long id){
        return orderEquipmentService.listEquipmentByIdMeeting(id);
    }
}
