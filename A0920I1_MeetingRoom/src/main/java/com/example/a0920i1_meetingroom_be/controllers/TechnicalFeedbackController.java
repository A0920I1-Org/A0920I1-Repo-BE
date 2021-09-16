package com.example.a0920i1_meetingroom_be.controllers;

import com.example.a0920i1_meetingroom_be.models.dto.FeedbackDTO;
import com.example.a0920i1_meetingroom_be.models.entity.FeedBack;
import com.example.a0920i1_meetingroom_be.services.FeedBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/feedback")
@CrossOrigin(origins ="http://localhost:4200")
//chuc nang TriNH
public class TechnicalFeedbackController {

    @Autowired
    private FeedBackService feedBackService;
//chuc nang list TriNH
    @GetMapping("/list")
    public ResponseEntity<List<FeedBack>> getAllFeed() {
        List<FeedBack> feedBacks = feedBackService.findAll();
        return new ResponseEntity<>(feedBacks, HttpStatus.OK);
    }
//chuc nang findID TriNH

    @GetMapping("/find/{id}")
    public ResponseEntity<FeedBack> getFeedbackById(@PathVariable("id") Long id) {
        FeedBack feedBack = feedBackService.findFeedbackId(id);
        return new ResponseEntity<>(feedBack, HttpStatus.OK);
    }
//chuc nang update TriNH

    @PutMapping("/update/{id}")
    public ResponseEntity<Long> updateEmployee(@PathVariable("id") Long id) {
        feedBackService.updateFeedBack(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
//chuc nang add TriNH
    @PostMapping("/add")
    public ResponseEntity<FeedbackDTO> createFeedbackTech(@RequestBody FeedbackDTO feedbackDTO) {
        System.out.println(feedbackDTO.getAccount());
        feedBackService.createFeedBack(feedbackDTO.getContent(),feedbackDTO.getDescription(),
                feedbackDTO.getDateFeedback(),feedbackDTO.isHandle(),feedbackDTO.getTitle(),feedbackDTO.getAccount(),
                feedbackDTO.getFeedBackType(),feedbackDTO.getMeetingRoom(),feedbackDTO.getImageFeedBackList());
        return new ResponseEntity<>(HttpStatus.CREATED);

    }


}
