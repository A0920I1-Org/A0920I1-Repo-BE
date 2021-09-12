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
@CrossOrigin("http://localhost:4200")
public class TechnicalFeedbackController {

    @Autowired
    private FeedBackService feedBackService;

    @GetMapping("/list")
    public ResponseEntity<List<FeedBack>> getAllFeed() {
        List<FeedBack> feedBacks = feedBackService.findAll();
        return new ResponseEntity<>(feedBacks, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<FeedBack> getFeedbackById(@PathVariable("id") Long id) {
        FeedBack feedBack = feedBackService.findFeedbackId(id);
        return new ResponseEntity<>(feedBack, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Long> updateEmployee(@PathVariable("id") Long id) {
        feedBackService.updateFeedBack(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Void> createFeedbackTech(@RequestBody FeedbackDTO feedbackDTO) {
        feedBackService.createFeedBack(feedbackDTO);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }


}
