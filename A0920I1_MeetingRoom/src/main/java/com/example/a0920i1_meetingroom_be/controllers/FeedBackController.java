package com.example.a0920i1_meetingroom_be.controllers;


import com.example.a0920i1_meetingroom_be.models.dto.FeedbackDTO1;
import com.example.a0920i1_meetingroom_be.models.entity.FeedBack;
import com.example.a0920i1_meetingroom_be.models.entity.FeedBackType;
import com.example.a0920i1_meetingroom_be.services.FeedBackService;
import com.example.a0920i1_meetingroom_be.services.FeedBackTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping(value = "/feedback")

public class FeedBackController {
    @Autowired
    private FeedBackService  feedBackService;
    @Autowired
    private FeedBackTypeService feedBackTypeService;

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
        if (feedbackDTO1 == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else {
            feedBackService.createFeedback(feedbackDTO1.getDateFeedback(),feedbackDTO1.getDescription(),false,feedbackDTO1.getTitle(),feedbackDTO1.getAccount(),feedbackDTO1.getMeetingRoom(),feedbackDTO1.getFeedBackType());
            return new ResponseEntity<>(feedbackDTO1, HttpStatus.OK);
        }

    }
    //VietNT Delete feedback
    @DeleteMapping(value = "/delete-feedback/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {

        feedBackService.delete(id);
        System.out.println(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
        //VietNT lấy id feedback
    @GetMapping(value = "/findById/{id}")
    public ResponseEntity<FeedBack> findById(@PathVariable long id) {
        System.out.println(id);
        FeedBack feedBack= feedBackService.findFeedbackId(id);
        if (feedBack==null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(feedBack, HttpStatus.OK);
    }

        //VietNT Handle feedback
    @PatchMapping(value = "/update/{id}")
    public ResponseEntity<FeedBack> updateVaccination(@PathVariable("id") Integer id, @RequestBody FeedbackDTO1 feedbackDTO1) {
        FeedBack feedBack =feedBackService.findFeedbackId(id);
        if (feedBack == null) {
            return new ResponseEntity<FeedBack>(HttpStatus.NOT_FOUND);
        }
        feedBackService.
                handleFeedback(feedbackDTO1);

        return new ResponseEntity<FeedBack>(feedBack, HttpStatus.OK);
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

}
