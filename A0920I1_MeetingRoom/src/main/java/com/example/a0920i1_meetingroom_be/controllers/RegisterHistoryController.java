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
    @GetMapping("/{accountId}")
    public List<OrderMeeting> getOrderMeeting(@PathVariable("accountId")String accountId){
        return orderMeetingService.getOrderMeetingByAccountId(accountId);
    }

    @PutMapping("/searchRegistrationHistory/{accountId}")
    public List<OrderMeeting> search(
            @RequestBody RegisterHistory registerHistory,
            @PathVariable("accountId")String accountId
    ){
        System.out.println("AccountID:" + accountId);
        return orderMeetingService.findRegisterHistory(registerHistory, accountId);
    }

    @GetMapping("/findOrderById/{idOrder}")
    public OrderMeeting findOrderById(@PathVariable("idOrder")String idOrder){
        System.out.println(idOrder);
        return orderMeetingService.findOrderById(idOrder);
    }

    @PutMapping("/deleteRegister/{idOrder}")
    public void deleteRegister(@RequestBody DeleteRegistration reasonDelete,
                               @PathVariable("idOrder")String idOrder){
        System.out.println(reasonDelete.getReasonDelete());
        System.out.println("Id order in Controller"+idOrder);
         orderMeetingService.deleteRegister(idOrder,reasonDelete.getReasonDelete());
    }

    @GetMapping("/checkIsDelete/{idOrder}")
    public boolean checkIsDelete(@PathVariable("idOrder")String idOrder){
        boolean check = orderMeetingService.checkIsDelete(idOrder);
        System.out.println(check);
        return orderMeetingService.checkIsDelete(idOrder);
    }
}
