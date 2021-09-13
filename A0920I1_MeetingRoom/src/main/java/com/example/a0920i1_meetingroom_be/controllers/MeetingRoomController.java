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
    MeetingRoomService meetingRoomService;

    @Autowired
    RoomStatusService roomStatusService;

    @Autowired
    TypeMeetingRoomService typeMeetingRoomService;

    @Autowired
    AreaService areaService;

    @Autowired
    EquipmentService equipmentService;


    // Lấy danh sách phòng họp (Hoàng)
    @GetMapping
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
        MeetingRoom meetingRoom = meetingRoomService.findById(id);

        if (meetingRoom == null) {

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(meetingRoom, HttpStatus.OK);
    }

    // chỉnh sửa phòng họp (Hoàng)
    @PutMapping(value = "/{id}")
    public ResponseEntity<MeetingRoom> updateMeetingRoom(@PathVariable("id") long id, @RequestBody MeetingRoomDto meetingRoomDto) {

        meetingRoomService.updateMeeting(meetingRoomDto.getName(), meetingRoomDto.getFloors(), meetingRoomDto.getArea(), meetingRoomDto.getRoomStatus(),
                meetingRoomDto.getTypeMeetingRoom(), meetingRoomDto.getImage_url(), id);
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

    @GetMapping(value = "equipment")
    public ResponseEntity<List<Equipment>> getAllEquipment() {
        List<Equipment> equipment = equipmentService.findAllEquipment();
        return new ResponseEntity<>(equipment, HttpStatus.OK);
    }

    //Xóa phòng họp theo id (Hoàng)
    @DeleteMapping("{id}")
    public void delete(@PathVariable long id) {
        System.out.println("Xoa thanh cong id " + id);
        meetingRoomService.deleteMeeting(id);
//        return meetingRoomService.deleteMeeting(id);
    }

    //tìm kiếm phòng họp
        @GetMapping("/search")
    public ResponseEntity<List<MeetingRoom>> searchMeetingRoomByName(@RequestParam(required = false) String name ,Integer floors,long area_id , long room_status_id,long type_meeting_room_id,Integer capacity ){

        List<MeetingRoom> meetingRooms = meetingRoomService.searchMeetingRoom(name, floors, area_id, room_status_id, type_meeting_room_id, capacity);

        return new ResponseEntity<>( meetingRooms,HttpStatus.OK);
    }

}
