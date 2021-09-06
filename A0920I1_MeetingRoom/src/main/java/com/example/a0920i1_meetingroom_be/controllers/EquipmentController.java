package com.example.a0920i1_meetingroom_be.controllers;

import com.example.a0920i1_meetingroom_be.models.entity.Equipment;
import com.example.a0920i1_meetingroom_be.models.entity.MeetingRoom;
import com.example.a0920i1_meetingroom_be.models.entity.OrderEquipment;
import com.example.a0920i1_meetingroom_be.services.EquipmentService;
import com.example.a0920i1_meetingroom_be.services.MeetingRoomService;
import com.example.a0920i1_meetingroom_be.services.OrderEquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class EquipmentController {

    @Autowired
    OrderEquipmentService orderEquipmentService;
    @Autowired
    EquipmentService equipmentService;
    @Autowired
    MeetingRoomService meetingRoomService;

    @GetMapping("/order-equipment")
    public ResponseEntity<List<OrderEquipment>> listAllOrderEquipment() {
        List<OrderEquipment> orderEquipments = orderEquipmentService.getAllOrderEquipment();
        if (orderEquipments.isEmpty()) {
            return new ResponseEntity<List<OrderEquipment>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<OrderEquipment>>(orderEquipments, HttpStatus.OK);
    }
    @GetMapping("/equipment")
    public ResponseEntity<List<Equipment>> listAllEquipment() {
        List<Equipment> equipments = equipmentService.getAllEquipment();
        if (equipments.isEmpty()) {
            return new ResponseEntity<List<Equipment>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Equipment>>(equipments, HttpStatus.OK);
    }
    @GetMapping("/meeting-room")
    public ResponseEntity<List<MeetingRoom>> listAllMeetingRoom() {
        List<MeetingRoom> meetingRooms = meetingRoomService.getAllMeetingRoom();
        if (meetingRooms.isEmpty()) {
            return new ResponseEntity<List<MeetingRoom>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<MeetingRoom>>(meetingRooms, HttpStatus.OK);
    }
}
