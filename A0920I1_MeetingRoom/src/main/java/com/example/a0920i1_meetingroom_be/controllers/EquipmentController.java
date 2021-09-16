package com.example.a0920i1_meetingroom_be.controllers;

import com.example.a0920i1_meetingroom_be.models.dto.EquipmentDto;
import com.example.a0920i1_meetingroom_be.models.entity.Equipment;
import com.example.a0920i1_meetingroom_be.models.entity.MeetingRoom;
import com.example.a0920i1_meetingroom_be.models.entity.OrderEquipment;
import com.example.a0920i1_meetingroom_be.services.EquipmentService;
import com.example.a0920i1_meetingroom_be.services.MeetingRoomService;
import com.example.a0920i1_meetingroom_be.services.OrderEquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class EquipmentController {

    @Autowired
    OrderEquipmentService orderEquipmentService;
    @Autowired
    EquipmentService equipmentService;
    @Autowired
    MeetingRoomService meetingRoomService;

    //Hiển thị danh sách OrderEquipment - PhapNT.
    @GetMapping("/order-equipment")
    public ResponseEntity<List<OrderEquipment>> listAllOrderEquipment() {
        List<OrderEquipment> orderEquipments = orderEquipmentService.findAllOrderEquipment();
        if (orderEquipments.isEmpty()) {
            return new ResponseEntity<List<OrderEquipment>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<OrderEquipment>>(orderEquipments, HttpStatus.OK);
    }
    //findId orderBy - PhapNT
    @GetMapping("/byOrder-equipment/{id}")
    public ResponseEntity<List<OrderEquipment> > getByOrderEquipment(@PathVariable("id") long id){
        List<OrderEquipment> orderEquipment = orderEquipmentService.findByOrderEquipment(id);
        return new ResponseEntity<List<OrderEquipment> >(orderEquipment,HttpStatus.OK);
    }

    //Hiển thị danh sách Equipment _ PhapNT.
    @GetMapping("/list-equipment")
    public ResponseEntity<List<Equipment>> listAllEquipment() {
        List<Equipment> equipments = equipmentService.getAllEquipment();
        if (equipments.isEmpty()) {
            return new ResponseEntity<List<Equipment>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Equipment>>(equipments, HttpStatus.OK);
    }

    //Hiển thị danh sách MeetingRoom - PhapNT.
    @GetMapping("/meeting-room")
    public ResponseEntity<List<MeetingRoom>> listAllMeetingRoom() {
        List<MeetingRoom> meetingRooms = meetingRoomService.getAllMeetingRoom();
        if (meetingRooms.isEmpty()) {
            return new ResponseEntity<List<MeetingRoom>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<MeetingRoom>>(meetingRooms, HttpStatus.OK);
    }

    // Tạo mới equipment - PhapNT.
    @PostMapping("/create-equipment")
    public ResponseEntity<Void> createEquipment(@Valid @RequestBody EquipmentDto equipmentDto, BindingResult bindingResult,
                                                UriComponentsBuilder uriComponentsBuilder) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);

        }
        equipmentService.createEquipment(equipmentDto);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uriComponentsBuilder.path("/customers/{id}").buildAndExpand(equipmentDto).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    //Hiển thị chi tiết equipment- PhapNT.
    @GetMapping("/detail-equipment/{id}")
    public ResponseEntity<Equipment> viewDetailEquipment(@PathVariable("id") long id){
        Equipment equipments = equipmentService.showDetailEquipment(id);
        return new ResponseEntity<Equipment>(equipments,HttpStatus.OK);
    }
    //Xóa danh sách equipment-PhapNT.
    @DeleteMapping("/delete-equipment/{id}")
    public ResponseEntity<Equipment> deleteEquipment (@PathVariable("id")long id){
        equipmentService.deleteEquipmentById(id);
        return new ResponseEntity<Equipment>(HttpStatus.OK);
    }
// findId equipment - PhapNT
    @GetMapping("/findById/{id}")
    public ResponseEntity<Equipment> findById(@PathVariable("id") long id){
        Equipment equipment= equipmentService.findById(id);
        return new ResponseEntity<Equipment>(equipment,HttpStatus.OK);
    }
//update - PhapNT
    @PutMapping("/update-equipment/{id}")
    public ResponseEntity<?> updateEquipment(@PathVariable("id") long id, @RequestBody EquipmentDto equipmentDto){
        equipmentService.updateEquipment(equipmentDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
//search - PhapNT
    @GetMapping("/searchNameEquipment")
    public ResponseEntity<List<Equipment>> searchNameEquipment(@RequestParam String name) {
        List<Equipment> equipment = equipmentService.searchName(name);
        return new ResponseEntity<>(equipment, HttpStatus.OK);
    }
}
