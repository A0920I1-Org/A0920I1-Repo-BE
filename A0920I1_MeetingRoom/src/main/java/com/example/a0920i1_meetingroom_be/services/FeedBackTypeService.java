package com.example.a0920i1_meetingroom_be.services;

import com.example.a0920i1_meetingroom_be.models.entity.Account;
import com.example.a0920i1_meetingroom_be.models.entity.FeedBackType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FeedBackTypeService {
    List<FeedBackType> findFeedBackTypeAll();
}
