package com.example.a0920i1_meetingroom_be.models.dto;

import com.example.a0920i1_meetingroom_be.models.entity.Account;
import com.example.a0920i1_meetingroom_be.models.entity.FeedBackType;
import com.example.a0920i1_meetingroom_be.models.entity.Notification;

import java.time.LocalDate;

public class FeedbackDTO {
    private String  id;
    private String description;
    private LocalDate dateFeedback;
    private boolean isHandle;
    private int feedBackType;
    private int account;
    private int notification;

    public FeedbackDTO(String id, String description, LocalDate dateFeedback, boolean isHandle, int feedBackType, int account, int notification) {
        this.id = id;
        this.description = description;
        this.dateFeedback = dateFeedback;
        this.isHandle = isHandle;
        this.feedBackType = feedBackType;
        this.account = account;
        this.notification = notification;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDateFeedback() {
        return dateFeedback;
    }

    public void setDateFeedback(LocalDate dateFeedback) {
        this.dateFeedback = dateFeedback;
    }

    public boolean isHandle() {
        return isHandle;
    }

    public void setHandle(boolean handle) {
        isHandle = handle;
    }

    public int getFeedBackType() {
        return feedBackType;
    }

    public void setFeedBackType(int feedBackType) {
        this.feedBackType = feedBackType;
    }

    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }

    public int getNotification() {
        return notification;
    }

    public void setNotification(int notification) {
        this.notification = notification;
    }
}
