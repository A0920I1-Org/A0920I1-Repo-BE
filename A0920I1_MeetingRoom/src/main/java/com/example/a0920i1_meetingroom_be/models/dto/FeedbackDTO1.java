package com.example.a0920i1_meetingroom_be.models.dto;

import java.time.LocalDate;

public class FeedbackDTO1 {
    private long id;
    private String title;
    private String description;
    private LocalDate dateFeedback;
    private boolean handle;
    private String feedBackType;
    private String meetingRoom;
    private int account;
    private String content;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
        return handle;
    }

    public void setHandle(boolean handle) {
        this.handle = handle;
    }

    public String getFeedBackType() {
        return feedBackType;
    }

    public void setFeedBackType(String feedBackType) {
        this.feedBackType = feedBackType;
    }

    public String getMeetingRoom() {
        return meetingRoom;
    }

    public void setMeetingRoom(String meetingRoom) {
        this.meetingRoom = meetingRoom;
    }

    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}