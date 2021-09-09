package com.example.a0920i1_meetingroom_be.services.Impl;

import com.example.a0920i1_meetingroom_be.models.entity.FeedBack;
import com.example.a0920i1_meetingroom_be.models.entity.FeedBackType;
import com.example.a0920i1_meetingroom_be.repositories.FeedBackTypeRepository;
import com.example.a0920i1_meetingroom_be.services.FeedBackTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedBackTypeServiceImpl implements FeedBackTypeService {

    @Autowired
    private FeedBackTypeRepository feedBackTypeRepository;

   /* public FeedBackTypeServiceImpl(FeedBackTypeRepository feedBackTypeRepository) {
        this.feedBackTypeRepository = feedBackTypeRepository;
    }*/

    @Override
    public List<FeedBackType> findFeedBackTypeAll() {
        return feedBackTypeRepository.findAll();
    }
}
