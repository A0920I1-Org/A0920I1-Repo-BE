package com.example.a0920i1_meetingroom_be.controllers;

import com.example.a0920i1_meetingroom_be.models.dto.DeleteRegistration;
import com.example.a0920i1_meetingroom_be.models.dto.RegisterHistory;
import com.example.a0920i1_meetingroom_be.models.entity.OrderMeeting;
import com.example.a0920i1_meetingroom_be.services.OrderMeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping("/registerHistory")
public class RegisterHistoryController {
    @Autowired
    OrderMeetingService orderMeetingService;
    //AnhLT
    // need information account => account id with role user
    @GetMapping("/account/{idAccount}")
    public List<OrderMeeting> getOrderMeetingListByIdAccount(@PathVariable("idAccount")String idAccount){
        return orderMeetingService.getOrderMeetingByAccountId(idAccount);
    }
    //AnhLT
    //search
    @PutMapping("/searchRegistrationHistory/")
    public List<OrderMeeting> searchOrderMeeting(
            @RequestBody RegisterHistory registerHistory){
        return orderMeetingService.searchRegisterHistoryBy(registerHistory);
    }
    //AnhLT
    // find order trans screen details delete of order
    @GetMapping("/findOrderById/{idOrder}")
    public OrderMeeting findOrderMeetingById(@PathVariable("idOrder")String idOrderMeeting){
        return orderMeetingService.findOrderById(idOrderMeeting);
    }
    //AnhLT
    // delete order
    @PutMapping("/deleteRegister/{idOrder}")
    public void deleteOrderMeeting(@RequestBody DeleteRegistration reasonDelete,
                                   @PathVariable("idOrder")String idOrder){
        orderMeetingService.deleteOrderMeeting(idOrder,reasonDelete.getReasonDelete());
    }
    //AnhLT
    // test , is order delete?
    @GetMapping("/checkIsDelete/{idOrder}")
    public boolean checkIsDelete(@PathVariable("idOrder")String idOrder){
        return orderMeetingService.checkIsDelete(idOrder);
    }
    //AnhLT
    // display register history by id meeting room with role admin
    @GetMapping("/meetingRoom/{idMeetingRoom}")
    public List<OrderMeeting> registerHistoryByIdMeetingRoom(@PathVariable("idMeetingRoom")String idMeetingRoom){
        return orderMeetingService.getRegisterHistoryByIdMeetingRoom(idMeetingRoom);
    }

}
