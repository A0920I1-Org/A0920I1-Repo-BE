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

    // need information account => account id
    @GetMapping("/account/{idAccount}")
    public List<OrderMeeting> getOrderMeetingListByIdAccount(@PathVariable("idAccount")String idAccount){
        return orderMeetingService.getOrderMeetingByAccountId(idAccount);
    }

    @PutMapping("/searchRegistrationHistory/{idAccount}")
    public List<OrderMeeting> searchOrderMeeting(
            @RequestBody RegisterHistory registerHistory,
            @PathVariable("idAccount")String accountId
    ){
        return orderMeetingService.findRegisterHistory(registerHistory, accountId);
    }

    @GetMapping("/findOrderById/{idOrder}")
    public OrderMeeting findOrderMeetingById(@PathVariable("idOrder")String idOrderMeeting){
        return orderMeetingService.findOrderById(idOrderMeeting);
    }

    @PutMapping("/deleteRegister/{idOrder}")
    public void deleteOrderMeeting(@RequestBody DeleteRegistration reasonDelete,
                                   @PathVariable("idOrder")String idOrder){
        orderMeetingService.deleteOrderMeeting(idOrder,reasonDelete.getReasonDelete());
    }

    @GetMapping("/checkIsDelete/{idOrder}")
    public boolean checkIsDelete(@PathVariable("idOrder")String idOrder){
        return orderMeetingService.checkIsDelete(idOrder);
    }

    @GetMapping("/meetingRoom/{idMeetingRoom}")
    public List<OrderMeeting> regiserHistoryByMeetingRoom(@PathVariable("idMeetingRoom")String idMeetingRoom){
        return orderMeetingService.getRegisterHistoryByIdMeetingRoom(idMeetingRoom);
    }

}
