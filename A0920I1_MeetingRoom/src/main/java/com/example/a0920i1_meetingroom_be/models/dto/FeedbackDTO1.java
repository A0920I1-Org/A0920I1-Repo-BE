package com.example.a0920i1_meetingroom_be.models.dto;

import java.time.LocalDate;

public class FeedbackDTO1 {
    private long id;
    private String title;
    private String description;
    private LocalDate dateFeedback;
    private boolean isHandle;
    private int feedBackType;
    private int meetingRoom;
    private int account;
    private String content;

    public FeedbackDTO1() {
    }

    public FeedbackDTO1(long id, String title, String description, LocalDate dateFeedback, boolean isHandle, int feedBackType, int meetingRoom, int account, String content) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.dateFeedback = dateFeedback;
        this.isHandle = isHandle;
        this.feedBackType = feedBackType;
        this.meetingRoom = meetingRoom;
        this.account = account;
        this.content = content;
    }

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

    public int getMeetingRoom() {
        return meetingRoom;
    }

    public void setMeetingRoom(int meetingRoom) {
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
