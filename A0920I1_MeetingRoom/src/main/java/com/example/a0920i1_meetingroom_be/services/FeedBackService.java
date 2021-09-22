package com.example.a0920i1_meetingroom_be.services;

import com.example.a0920i1_meetingroom_be.models.dto.FeedbackDTO1;
import com.example.a0920i1_meetingroom_be.models.entity.FeedBack;

import java.time.LocalDate;
import java.util.List;
//feedbackSER TriNH
public interface FeedBackService{
    // VietNT  xoa phan hoi
    void deleteFeedback(Long id);
    //VietNT xư ly phan hoi
    void handleFeedback(FeedbackDTO1 feedbackDTO1);
    //VietNT lay tat ca danh sach phan hoi
    List<FeedBack> findAllFeedback();
    //VietNT lay danh sach phan hoi bang id
    FeedBack findFeedbackId(long id);
    void updateFeedBack(Long id);
    void createFeedBack(String content, String description, LocalDate dateFeedback, boolean isHandle, String title,
                        int account, int feedBackType, int meetingroom_id, String imageFeedBackList);
    //VietNT tao phan hoi

    void createFeedback(LocalDate dateFeedback, String description, boolean isHandle, String title, int account, String feedBackType, String meetingRoom);

}