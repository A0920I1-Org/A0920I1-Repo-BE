package com.example.a0920i1_meetingroom_be.controllers;

import com.example.a0920i1_meetingroom_be.models.entity.Equipment;
import com.example.a0920i1_meetingroom_be.models.entity.MeetingRoom;
import com.example.a0920i1_meetingroom_be.models.entity.OrderEquipment;
import com.example.a0920i1_meetingroom_be.services.EquipmentService;
import com.example.a0920i1_meetingroom_be.services.MeetingRoomService;
import com.example.a0920i1_meetingroom_be.services.OrderEquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
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

//Hiển thị danh sách OrderEquipment - PhapNT
    @GetMapping("/order-equipment")
    public ResponseEntity<List<OrderEquipment>> listAllOrderEquipment() {
        List<OrderEquipment> orderEquipments = orderEquipmentService.getAllOrderEquipment();
        if (orderEquipments.isEmpty()) {
            return new ResponseEntity<List<OrderEquipment>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<OrderEquipment>>(orderEquipments, HttpStatus.OK);
    }
//Hiển thị danh sách Equipment _ PhapNT
    @GetMapping("/equipment")
    public ResponseEntity<List<Equipment>> listAllEquipment() {
        List<Equipment> equipments = equipmentService.getAllEquipment();
        if (equipments.isEmpty()) {
            return new ResponseEntity<List<Equipment>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Equipment>>(equipments, HttpStatus.OK);
    }
    //Hiển thị danh sách MeetingRoom - PhapNT
    @GetMapping("/meeting-room")
    public ResponseEntity<List<MeetingRoom>> listAllMeetingRoom() {
        List<MeetingRoom> meetingRooms = meetingRoomService.getAllMeetingRoom();
        if (meetingRooms.isEmpty()) {
            return new ResponseEntity<List<MeetingRoom>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<MeetingRoom>>(meetingRooms, HttpStatus.OK);
    }

    // Tạo mới equipment - PhapNT
    @RequestMapping(value = "/create-equipment",produces = MediaType.APPLICATION_JSON_VALUE,method = RequestMethod.POST)
    public ResponseEntity<Void> createEquipment(@Valid @RequestBody Equipment equipment, BindingResult bindingResult, UriComponentsBuilder uriComponentsBuilder) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);

        }
        equipmentService.save(equipment);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uriComponentsBuilder.path("/customers/{id}").buildAndExpand(equipment.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    //Xóa equipment - PhapNT
    @DeleteMapping("/delete-equipment/{id}")
    public ResponseEntity<Equipment> deleteEquipment(@PathVariable("id")long id){
        Equipment equipments = equipmentService.findById(id);

        if (equipments==null){
            return new ResponseEntity<Equipment>(HttpStatus.NOT_FOUND);
        }
        equipmentService.delete(id);
        return new ResponseEntity<Equipment>(equipments,HttpStatus.OK);
    }

    //Sửa equipment - PhapNT
    @PutMapping("/edit-equipment/{id}")
    public ResponseEntity<Equipment> updateEquipment(@PathVariable("id")int id,@RequestBody Equipment equipment){
        Equipment equipments= equipmentService.findById(id);

        if (equipments==null){
            return new ResponseEntity<Equipment>(HttpStatus.NOT_FOUND);
        }
        equipments.setId(equipment.getId());
        equipments.setName(equipment.getName());
        equipments.setStock(equipment.getStock());
        equipments.setRepairQuantity(equipment.getRepairQuantity());
        equipments.setImageUrl(equipment.getImageUrl());
        return new ResponseEntity<Equipment>(equipments,HttpStatus.OK);
    }

}