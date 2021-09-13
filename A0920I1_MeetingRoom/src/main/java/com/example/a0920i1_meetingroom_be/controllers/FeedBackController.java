package com.example.a0920i1_meetingroom_be.controllers;

import com.example.a0920i1_meetingroom_be.models.dto.FeedbackDTO;
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
@RequestMapping("/feedback")

public class FeedBackController {
    @Autowired
    private FeedBackService feedBackService;
    @Autowired
    private FeedBackTypeService feedBackTypeService;

    @GetMapping("/feedbacklist")
    public ResponseEntity<List<FeedBack>> getAllFeedback() {

        List<FeedBack> feedBackList = feedBackService.findAllFeedback();

        if (feedBackList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {

            return new ResponseEntity<>(feedBackList, HttpStatus.OK);
        }
    }


    @PostMapping("/createFeedback")
    //loi ? cho nay
    public ResponseEntity<FeedbackDTO> createFeedback(@RequestBody FeedbackDTO feedbackDTO) {

        feedBackService.createFeedback( feedbackDTO.getDateFeedback(),feedbackDTO.getDescription(),feedbackDTO.isHandle(),feedbackDTO.getTitle(),feedbackDTO.getAccount(),feedbackDTO.getFeedBackType(),feedbackDTO.getMeetingRoom());
        return new ResponseEntity<>(feedbackDTO,HttpStatus.OK);

    }

    @GetMapping("/feedbacktypelist")
    public ResponseEntity<List<FeedBackType>> getAllFeedbackType() {
        List<FeedBackType> feedBackTypeList = feedBackTypeService.findAllFeedbackType();

        if (feedBackTypeList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(feedBackTypeList, HttpStatus.OK);
        }
    }

}
