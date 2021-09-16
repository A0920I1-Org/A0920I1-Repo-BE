package com.example.a0920i1_meetingroom_be.services;
import com.example.a0920i1_meetingroom_be.models.entity.FeedBack;

import java.time.LocalDate;
import java.util.List;
//feedbackSER TriNH
public interface FeedBackService{
    List<FeedBack> findAll();
    FeedBack findFeedbackId(long id);
    void updateFeedBack(Long id);
    void createFeedBack(String content, String description, LocalDate dateFeedback, boolean isHandle, String title,
                        int account, int feedBackType, int meetingroom_id, String imageFeedBackList);
}
