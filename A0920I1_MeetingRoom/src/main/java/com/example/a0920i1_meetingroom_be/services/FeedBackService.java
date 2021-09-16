package com.example.a0920i1_meetingroom_be.services;

import com.example.a0920i1_meetingroom_be.models.dto.FeedbackDTO1;
import com.example.a0920i1_meetingroom_be.models.entity.FeedBack;

import java.time.LocalDate;
import java.util.List;
//feedbackSER TriNH
public interface FeedBackService{
    void delete(Long id);
    void handleFeedback(FeedbackDTO1 feedbackDTO);
    List<FeedBack> findAllFeedback();
    FeedBack findFeedbackId(long id);
    void updateFeedBack(Long id);
    void createFeedBack(String content, String description, LocalDate dateFeedback, boolean isHandle, String title,
                        int account, int feedBackType, int meetingroom_id, String imageFeedBackList);

    void createFeedback(LocalDate dateFeedback, String description, boolean isHandle, String title, int account, int feedBackType, int meetingRoom);

}