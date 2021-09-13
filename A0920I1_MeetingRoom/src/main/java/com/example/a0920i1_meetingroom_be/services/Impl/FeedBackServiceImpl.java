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

    @Override
    public List<FeedBack> findAll() {
        return feedBackRepository.findAll();
    }

    @Override
    public FeedBack findFeedbackId(long id) {
        return feedBackRepository.findById(id).orElse(null);
    }

    @Override
    public void updateFeedBack(Long id) {
        feedBackRepository.updateFeedBack(id);
    }

    @Override
    public FeedbackDTO createFeedBack(FeedbackDTO feedbackDTO) {
        feedBackRepository.createFeedBack(feedbackDTO.getContent(),feedbackDTO.getDescription(),feedbackDTO.getDateFeedback(),feedbackDTO.isHandle(),
                feedbackDTO.getTitle(),feedbackDTO.getAccount(),feedbackDTO.getFeedBackType(),feedbackDTO.getMeetingRoom(),feedbackDTO.getImageFeedBackList());
        return feedbackDTO;
    }


}
