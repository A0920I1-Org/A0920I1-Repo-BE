package com.example.a0920i1_meetingroom_be.services;
import com.example.a0920i1_meetingroom_be.models.dto.FeedbackDTO;
import com.example.a0920i1_meetingroom_be.models.entity.FeedBack;

import java.util.List;

public interface FeedBackService{
    List<FeedBack> findAll();
    FeedBack findFeedbackId(long id);
    void updateFeedBack(Long id);
    FeedbackDTO createFeedBack(FeedbackDTO feedbackDTO);
}
