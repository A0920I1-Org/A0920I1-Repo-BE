package com.example.a0920i1_meetingroom_be.services;
import com.example.a0920i1_meetingroom_be.models.dto.FeedbackDTO;
import com.example.a0920i1_meetingroom_be.models.entity.FeedBack;

import java.util.List;
import java.util.Optional;

public interface FeedBackService{
    List<FeedBack> findAll();
    FeedBack save(FeedBack feedBack);
    FeedBack findFeedbackId(long id);
    void updateFeedBack(FeedbackDTO feedbackDTO);
    void createFeedBack(FeedbackDTO feedbackDTO);
}
