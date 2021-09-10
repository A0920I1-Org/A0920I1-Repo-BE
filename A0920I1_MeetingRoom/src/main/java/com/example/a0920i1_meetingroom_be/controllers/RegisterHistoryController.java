package com.example.a0920i1_meetingroom_be.controllers;

import com.example.a0920i1_meetingroom_be.models.dto.DeleteRegistration;
import com.example.a0920i1_meetingroom_be.models.dto.RegisterHistory;
import com.example.a0920i1_meetingroom_be.models.entity.OrderMeeting;
import com.example.a0920i1_meetingroom_be.services.OrderMeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/registerHistory")
public class RegisterHistoryController {
    @Autowired
    OrderMeetingService orderMeetingService;

    // need information account => account id
    @GetMapping("/account/{idAccount}")
    public List<OrderMeeting> getOrderMeetingListByIdAccount(@PathVariable("idAccount")String idAccount){
        System.out.println("register account : " + idAccount);
        return orderMeetingService.getOrderMeetingByAccountId(idAccount);
    }

    @PutMapping("/searchRegistrationHistory/{idAccount}")
    public List<OrderMeeting> searchOrderMeeting(
            @RequestBody RegisterHistory registerHistory,
            @PathVariable("idAccount")String accountId
    ){
        System.out.println("AccountID:" + accountId);
        return orderMeetingService.findRegisterHistory(registerHistory, accountId);
    }

    @GetMapping("/findOrderById/{idOrder}")
    public OrderMeeting findOrderMeetingById(@PathVariable("idOrder")String idOrderMeeting){
        System.out.println(idOrderMeeting);
        return orderMeetingService.findOrderById(idOrderMeeting);
    }

    @PutMapping("/deleteRegister/{idOrder}")
    public void deleteOrderMeeting(@RequestBody DeleteRegistration reasonDelete,
                               @PathVariable("idOrder")String idOrder){
        System.out.println(reasonDelete.getReasonDelete());
        System.out.println("Id order in Controller"+idOrder);
         orderMeetingService.deleteOrderMeeting(idOrder,reasonDelete.getReasonDelete());
    }

    @GetMapping("/checkIsDelete/{idOrder}")
    public boolean checkIsDelete(@PathVariable("idOrder")String idOrder){
        boolean check = orderMeetingService.checkIsDelete(idOrder);
        System.out.println(check);
        return orderMeetingService.checkIsDelete(idOrder);
    }

    @GetMapping("/meetingRoom/{idMeetingRoom}")
    public List<OrderMeeting> regiserHistoryByMeetingRoom(@PathVariable("idMeetingRoom")String idMeetingRoom){
        System.out.println("register " + idMeetingRoom);
        return orderMeetingService.getRegisterHistoryByIdMeetingRoom(idMeetingRoom);
    }

}
