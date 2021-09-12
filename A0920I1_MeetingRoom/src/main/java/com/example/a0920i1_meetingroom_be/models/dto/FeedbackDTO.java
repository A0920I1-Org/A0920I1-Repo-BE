package com.example.a0920i1_meetingroom_be.models.dto;

import java.time.LocalDate;


public class FeedbackDTO {
    private Long  id;
    private String description;
    private LocalDate dateFeedback;
    private boolean isHandle;
    private int feedBackType;
    private int account;
    private int meetingRoom;

    public FeedbackDTO() {
    }

    public FeedbackDTO(Long id, String description, LocalDate dateFeedback, boolean isHandle, int feedBackType, int account, int meetingRoom) {
        this.id = id;
        this.description = description;
        this.dateFeedback = dateFeedback;
        this.isHandle = isHandle;
        this.feedBackType = feedBackType;
        this.account = account;
        this.meetingRoom = meetingRoom;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public int getMeetingRoom() {
        return meetingRoom;
    }

    public void setMeetingRoom(int meetingRoom) {
        this.meetingRoom = meetingRoom;
    }
}
