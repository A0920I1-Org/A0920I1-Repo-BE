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

    //VietNT lấy list feedback
    @GetMapping("/feedbacklist")
    public ResponseEntity<List<FeedBack>> getAllFeedback() {

        List<FeedBack> feedBackList = feedBackService.findAllFeedback();

        if (feedBackList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {

            return new ResponseEntity<>(feedBackList, HttpStatus.OK);
        }
    }

    //VietNT  Feedback
    @PostMapping("/createFeedback")

    public ResponseEntity<FeedbackDTO> createFeedback(@RequestBody FeedbackDTO feedbackDTO) {
        if (feedbackDTO == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else {
            feedBackService.createFeedback(feedbackDTO.getDateFeedback(), feedbackDTO.getDescription(), feedbackDTO.isHandle(), feedbackDTO.getTitle(), feedbackDTO.getAccount(), feedbackDTO.getFeedBackType(), feedbackDTO.getMeetingRoom());
            return new ResponseEntity<>(feedbackDTO, HttpStatus.OK);
        }

    }
    //VietNT Delete feedback
    @DeleteMapping("/delete-feedback/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {

        feedBackService.delete(id);
        System.out.println(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
        //VietNT lấy id feedback
    @GetMapping("/findById/{id}")
    public ResponseEntity<FeedBack> findById(@PathVariable long id) {
        System.out.println(id);
        FeedBack feedBack= feedBackService.findById(id);
        if (feedBack==null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(feedBack, HttpStatus.OK);
    }

        //VietNT Handle feedback
    @PatchMapping(value = "/update/{id}")
    public ResponseEntity<FeedBack> updateVaccination(@PathVariable("id") Integer id, @RequestBody FeedbackDTO feedbackDTO) {
        FeedBack feedBack =feedBackService.findById(id);
        if (feedBack == null) {
            return new ResponseEntity<FeedBack>(HttpStatus.NOT_FOUND);
        }
        feedBackService.handleFeedback(feedbackDTO);

        return new ResponseEntity<FeedBack>(feedBack, HttpStatus.OK);
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
