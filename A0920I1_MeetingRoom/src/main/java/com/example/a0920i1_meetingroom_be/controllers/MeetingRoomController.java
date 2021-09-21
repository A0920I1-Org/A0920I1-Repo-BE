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
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/api/meeting-room")
public class MeetingRoomController {
    @Autowired
    MeetingRoomService meetingRoomService;
    //AnhLT

    @Autowired
    OrderEquipmentService orderEquipmentService;

    @Autowired
    RoomStatusService roomStatusService;

    @Autowired
    TypeMeetingRoomService typeMeetingRoomService;

    @Autowired
    AreaService areaService;

    @Autowired
    EquipmentService equipmentService;

    // Lấy danh sách phòng họp (Hoàng)
    @GetMapping(value = "/list")
    public ResponseEntity<List<MeetingRoom>> getAllListMeetingRoom() {
        List<MeetingRoom> meetingRooms = meetingRoomService.findAllMeetingRoom();
        if (meetingRooms.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(meetingRooms, HttpStatus.OK);
        }
    }

    // Lấy dữ liệu theo Id (Hoàng)
    @GetMapping("{id}")
    public ResponseEntity<MeetingRoom> getById(@PathVariable("id") long id) {
        System.out.println("success!");
        MeetingRoom meetingRoom = meetingRoomService.findMeetingRoomById(id);
        if (meetingRoom == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(meetingRoom, HttpStatus.OK);
    }

    // chỉnh sửa phòng họp (Hoàng)
    @PatchMapping(value = "/update-meeting/{id}")
    public ResponseEntity<?> updateMeetingRoom(@PathVariable("id") long id, @RequestBody MeetingRoomDto meetingRoomDto) {
        meetingRoomService.updateMeeting(meetingRoomDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping(value = "area")
    public ResponseEntity<List<Area>> getAllListArea() {
        List<Area> areas = areaService.findAllArea();
        return new ResponseEntity<>(areas, HttpStatus.OK);
    }

    @GetMapping(value = "typeMeetingRoom")
    public ResponseEntity<List<TypeMeetingRoom>> getAllListTypeMeetingRoom() {
        List<TypeMeetingRoom> typeMeetingRooms = typeMeetingRoomService.findAllTypeMeetingRoom();
        return new ResponseEntity<>(typeMeetingRooms, HttpStatus.OK);
    }

    @GetMapping(value = "roomStatus")
    public ResponseEntity<List<RoomStatus>> getAllRoomStatus() {
        List<RoomStatus> roomStatuses = roomStatusService.findAllRoomStatus();
        return new ResponseEntity<>(roomStatuses, HttpStatus.OK);
    }


    //Xóa phòng họp theo id (Hoàng)
    @DeleteMapping("{id}")
    public ResponseEntity<MeetingRoom> deleteMeetingRoom(@PathVariable long id) {
        System.out.println("Xoa thanh cong id " + id);
        meetingRoomService.deleteMeeting(id);
        return  new ResponseEntity<MeetingRoom>(HttpStatus.OK);
    }

    //tìm kiếm phòng họp (Hoàng)
    @GetMapping("/search")
    public ResponseEntity<List<MeetingRoom>> searchMeetingRoomByName(@RequestParam(required = false) String name ,Integer floors,long area_id , long room_status_id,long type_meeting_room_id,Integer capacity ){
        List<MeetingRoom> meetingRooms = meetingRoomService.searchMeetingRoom(name, floors, area_id, room_status_id, type_meeting_room_id, capacity);
        return new ResponseEntity<>( meetingRooms,HttpStatus.OK);
    }


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

    // huệ tạo 9/9/2021, chức năng thêm mới phòng họp bằng cách sử dụng đối tượng dto
    @PostMapping(value = "")
    public ResponseEntity<?> createMeeting(@RequestBody MeetingRoomDto meetingRoom){

        meetingRoomService.saveMeetingRoom(meetingRoom.getName().trim(),
                meetingRoom.getFloors(),
                meetingRoom.getImageUrl().trim(),
                meetingRoom.getArea(),
                meetingRoom.getRoomStatus(),
                meetingRoom.getTypeMeetingRoom());

        return new ResponseEntity<>(HttpStatus.OK);
    }

    // huệ tạo 9/9/2021, chức năng hiển thị phòng họp chi tiết theo id phòng họp
    @GetMapping("/details-meeting-room/{id}")
    public MeetingRoom showDetailsMeetingRoom(@PathVariable("id") long id){
        return meetingRoomService.findMeetingRoomById(id);
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
