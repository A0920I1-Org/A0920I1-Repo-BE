package com.example.a0920i1_meetingroom_be.services.Impl;


import com.example.a0920i1_meetingroom_be.models.dto.FeedbackDTO1;
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
    public FeedBack findFeedbackId(long id) {
        return feedBackRepository.findFeedbackById(id);
    }

    @Override
    public void updateFeedBack(Long id) {
        feedBackRepository.updateFeedBack(id);
    }

    @Override
    public void createFeedBack(String content, String description, LocalDate dateFeedback, boolean isHandle, String title, int account, int feedBackType, int meetingroom_id, String imageFeedBackList) {
        System.out.println(account);
        feedBackRepository.createFeedBack(content,description,dateFeedback,isHandle,title,account,feedBackType,meetingroom_id,imageFeedBackList);
    }

    @Override
    public void createFeedback(LocalDate dateFeedback, String description, boolean isHandle, String title, int account, String feedBackType, String meetingRoom) {
        feedBackRepository.createFeedback(dateFeedback,description,isHandle,title,account,feedBackType,meetingRoom);
    }


    public List<FeedBack> findAllFeedback() {
        return feedBackRepository.feedbackList();
    }


    @Override
    public void deleteFeedback(Long id) {
        feedBackRepository.deleteFeedbackById(id);
    }

    @Override
    public void handleFeedback(FeedbackDTO1 feedbackDTO1) {
        feedBackRepository.handleFeedback(feedbackDTO1.getDateFeedback(),feedbackDTO1.getDescription(),feedbackDTO1.isHandle(),feedbackDTO1.getTitle(),String.valueOf(feedbackDTO1.getAccount()),Integer.parseInt(feedbackDTO1.getFeedBackType()),String.valueOf(feedbackDTO1.getMeetingRoom()),feedbackDTO1.getContent(),String.valueOf(feedbackDTO1.getId()));
    }

}