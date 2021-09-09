package com.example.a0920i1_meetingroom_be.services.Impl;
import com.example.a0920i1_meetingroom_be.models.dto.FeedbackDTO;
import com.example.a0920i1_meetingroom_be.models.entity.FeedBack;
import com.example.a0920i1_meetingroom_be.repositories.FeedBackRepository;
import com.example.a0920i1_meetingroom_be.services.FeedBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedBackServiceImpl implements FeedBackService {

    @Autowired
    private FeedBackRepository feedBackRepository;

    /*public FeedBackServiceImpl(FeedBackRepository feedBackRepository) {
        this.feedBackRepository = feedBackRepository;
    }*/


    @Override
    public List<FeedBack> findAll() {
        return feedBackRepository.findAll();
    }


    @Override
    public FeedBack save(FeedBack feedBack) {
        return feedBackRepository.save(feedBack);
    }

    @Override
    public FeedBack findFeedbackId(long id) {
        return feedBackRepository.findById(id).orElse(null);
    }

    @Override
    public void updateFeedBack(FeedbackDTO feedbackDTO) {
        feedBackRepository.updateFeedBack(feedbackDTO.getId());
    }

    @Override
    public void createFeedBack(FeedbackDTO feedbackDTO) {
        feedBackRepository.createFeedBack(feedbackDTO.getDescription(),feedbackDTO.getDateFeedback(),
                feedbackDTO.isHandle(),feedbackDTO.getFeedBackType(),feedbackDTO.getAccount(),feedbackDTO.getNotification());
    }

}
