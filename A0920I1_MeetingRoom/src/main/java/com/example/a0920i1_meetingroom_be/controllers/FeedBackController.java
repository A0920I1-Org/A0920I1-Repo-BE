package com.example.a0920i1_meetingroom_be.controllers;


import com.example.a0920i1_meetingroom_be.models.dto.FeedbackDTO1;
import com.example.a0920i1_meetingroom_be.models.entity.*;
import com.example.a0920i1_meetingroom_be.services.AccountService;
import com.example.a0920i1_meetingroom_be.services.FeedBackService;
import com.example.a0920i1_meetingroom_be.services.FeedBackTypeService;
import com.example.a0920i1_meetingroom_be.services.MeetingRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping(value = "/api")

public class FeedBackController {
    @Autowired
    private FeedBackService feedBackService;
    @Autowired
    private FeedBackTypeService feedBackTypeService;
    @Autowired
    private MeetingRoomService meetingRoomService;
    @Autowired
    private AccountService accountService;



    //VietNT lấy list feedback
    @GetMapping(value = "/feedbacklist")
    public ResponseEntity<List<FeedBack>> getAllFeedback() {

        List<FeedBack> feedBackList = feedBackService.findAllFeedback();

        if (feedBackList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {

            return new ResponseEntity<>(feedBackList, HttpStatus.OK);
        }
    }

    //VietNT  Feedback
    @PostMapping(value = "/createFeedback")

    public ResponseEntity<FeedbackDTO1> createFeedback(@RequestBody FeedbackDTO1 feedbackDTO1) {
        if (feedbackDTO1 == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {

            feedBackService.createFeedback(feedbackDTO1.getDateFeedback(),feedbackDTO1.getDescription(),feedbackDTO1.isHandle(),feedbackDTO1.getTitle(),feedbackDTO1.getAccount(),String.valueOf(feedbackDTO1.getMeetingRoom()),String.valueOf(feedbackDTO1.getFeedBackType()));
            return new ResponseEntity<>(feedbackDTO1, HttpStatus.OK);
        }

    }

    //VietNT Delete feedback
    @DeleteMapping(value = "/delete-feedback/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {

        feedBackService.deleteFeedback(id);
        System.out.print(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //VietNT lấy id feedback
    @GetMapping(value = "/findFeedbackById/{id}")
    public ResponseEntity<?> findFeedbackById(@PathVariable long id) {

        System.out.print(id);

        FeedBack feedBack = feedBackService.findFeedbackId(id);

        if (feedBack == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {

            return new ResponseEntity<FeedBack>(feedBack, HttpStatus.OK);
        }


    }

    //VietNT Handle feedback
    @PutMapping(value = "/update/{id}")
    public ResponseEntity<FeedBack> updateVaccination(@PathVariable("id") long id, @RequestBody FeedbackDTO1 feedbackDTO1) {

        FeedBack feedBack = feedBackService.findFeedbackId(id);

        if (feedBack == null) {
            return new ResponseEntity<FeedBack>(HttpStatus.NOT_FOUND);
        }else {
            feedBack.setHandle(true);
            feedBackService.handleFeedback(feedbackDTO1);


            return new ResponseEntity<FeedBack>(feedBack, HttpStatus.OK);
        }
    }


    @GetMapping(value = "/feedbacktypelist")
    public ResponseEntity<List<FeedBackType>> getAllFeedbackType() {
        List<FeedBackType> feedBackTypeList = feedBackTypeService.findAllFeedbackType();

        if (feedBackTypeList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(feedBackTypeList, HttpStatus.OK);
        }
    }

    //VietNT lấy phòng họp
    @GetMapping(value = "/feedbackMeetingRoom")
    public ResponseEntity<List<MeetingRoom>> getAllListMeetingRoom() {
        List<MeetingRoom> meetingRooms = meetingRoomService.findAllMeetingRoom();
        if (meetingRooms.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(meetingRooms, HttpStatus.OK);
        }
    }
    //Viet lấy Account
    @GetMapping(value = "/feedbackAccount")
    public ResponseEntity<List<Account>> getAllAccountList(){
        List<Account> accountList = this.accountService.getAllAccount();
        if (accountList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(accountList, HttpStatus.OK);
    }

}