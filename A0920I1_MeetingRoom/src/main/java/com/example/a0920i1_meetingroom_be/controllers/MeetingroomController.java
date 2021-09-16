package com.example.a0920i1_meetingroom_be.controllers;

import com.example.a0920i1_meetingroom_be.models.dto.MeetingRoomDto;
import com.example.a0920i1_meetingroom_be.models.dto.OrderEquipmentDto;
import com.example.a0920i1_meetingroom_be.models.entity.*;
import com.example.a0920i1_meetingroom_be.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    // huệ tạo 9/9/2021, chức năng tìm kiếm và hiển thị danh sách tài sản
    @GetMapping("equipment")
    public List<Equipment> findAllEquipment(@RequestParam Optional<String> name){
        String stringAfterCheck = "";
        if(!name.isPresent()){
            return equipmentService.listEquipment();
        }
        else{
            stringAfterCheck = name.get();
            return equipmentService.findEquipmentByName(stringAfterCheck);
        }
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
    @PostMapping(value = "/create-meeting")
    public ResponseEntity<?> createMeeting(@RequestBody MeetingRoomDto meetingRoom){

        meetingRoomService.saveMeetingRoom(meetingRoom.getName().trim(),
                meetingRoom.getFloors(),
                meetingRoom.getImageUrl().trim(),
                meetingRoom.getAreaDto(),
                meetingRoom.getRoomStatusDto(),
                meetingRoom.getTypeMeetingRoomDto());

        return new ResponseEntity<>(HttpStatus.OK);
    }

    // huệ tạo 9/9/2021, chức năng hiển thị phòng họp chi tiết theo id phòng họp
    @GetMapping("/details-meeting-room/{id}")
    public MeetingRoom showDetailsMeetingRoom(@PathVariable("id") long id){
        return meetingRoomService.showDetailMeetingRoom(id);
    }

    // huệ tạo 9/9/2021, chức năng hiển thị danh sách phòng họp
    @GetMapping("")
    public List<MeetingRoom> getAllMeetingRoom(){
        return meetingRoomService.findAll();
    }

    // huệ tạo 10/9/2021, chức năng hiển thị thông tin tài sản của id phòng họp thông qua bảng order
    @GetMapping("/equipment/{id}")
    public List<OrderEquipment> getAllEquipmentByIdMeetingRoom(@PathVariable(value = "id") long id){
        return orderEquipmentService.listEquipmentByIdMeeting(id);
    }

    // huệ tạo 10/9/2021, chức năng thêm mới 1 tài sản của phòng họp
    @PostMapping("/order-equipment")
    public ResponseEntity<?> insertOrderEquipment(@RequestBody OrderEquipmentDto orderEquipmentDto){

        orderEquipmentService.insertOrderEquipment(orderEquipmentDto.getEquipment_id(),orderEquipmentDto.getEquipment_id(),orderEquipmentDto.getMeeting_room_id());
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
