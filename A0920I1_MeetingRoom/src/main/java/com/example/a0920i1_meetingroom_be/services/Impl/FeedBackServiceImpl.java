package com.example.a0920i1_meetingroom_be.services.Impl;
import com.example.a0920i1_meetingroom_be.models.entity.FeedBack;
import com.example.a0920i1_meetingroom_be.repositories.FeedBackRepository;
import com.example.a0920i1_meetingroom_be.services.FeedBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class FeedBackServiceImpl implements FeedBackService {
    @Autowired
    private FeedBackRepository feedBackRepository;

    @Override
    public List<FeedBack> findAllFeedback() {
        return feedBackRepository.feedbackList();
    }

    @Override
    public void createFeedback(LocalDate dateFeedback, String description, boolean isHandle, String title, int account, int feedBackType, int meetingRoom) {
        feedBackRepository.createFeedback( dateFeedback, description, isHandle,title, account,feedBackType, meetingRoom);
    }


}
