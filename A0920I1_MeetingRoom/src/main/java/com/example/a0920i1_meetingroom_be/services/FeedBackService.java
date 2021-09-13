package com.example.a0920i1_meetingroom_be.services;

import com.example.a0920i1_meetingroom_be.models.entity.FeedBack;


import java.time.LocalDate;
import java.util.List;

public interface FeedBackService {
    List<FeedBack> findAllFeedback();
    void createFeedback(LocalDate dateFeedback, String description, boolean isHandle,String title,  int account, int feedBackType, int meetingRoom);

}
