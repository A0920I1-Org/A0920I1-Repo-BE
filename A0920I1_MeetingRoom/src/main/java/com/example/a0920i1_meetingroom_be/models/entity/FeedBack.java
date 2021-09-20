package com.example.a0920i1_meetingroom_be.models.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

import java.util.List;


@Entity
public class FeedBack {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String description;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dateFeedback;
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean isHandle;

    @JsonManagedReference(value = "feed_back_type")
    @ManyToOne
    @JoinColumn(name = "feedBackType_id", referencedColumnName = "id")
    private FeedBackType feedBackType;


    @JsonManagedReference(value = "account")
    @ManyToOne
    @JoinColumn(name="account_id" , referencedColumnName = "id")
    private Account account;

    @OneToOne(mappedBy = "feedBack")
    private Notification notification;


    @JsonBackReference
    @OneToMany(mappedBy = "feedBack")
    private List<ImageFeedBack> imageFeedBackList;

    @ManyToOne
    @JoinColumn(name = "meetingroom_id", referencedColumnName = "id")
    private MeetingRoom meetingRoom;

    public FeedBack() {
    }

    public FeedBack(long id, String title, String description, LocalDate dateFeedback, boolean isHandle, FeedBackType feedBackType, Account account, Notification notification, MeetingRoom meetingRoom, String content) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.dateFeedback = dateFeedback;
        this.isHandle = isHandle;
        this.feedBackType = feedBackType;
        this.account = account;
        this.notification = notification;
        this.meetingRoom = meetingRoom;
        this.content = content;
    }

    public FeedBack(long id, String title, String description, LocalDate dateFeedback, boolean isHandle, FeedBackType feedBackType, Account account, Notification notification, List<ImageFeedBack> imageFeedBackList, MeetingRoom meetingRoom, String content) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.dateFeedback = dateFeedback;
        this.isHandle = isHandle;
        this.feedBackType = feedBackType;
        this.account = account;
        this.notification = notification;
        this.imageFeedBackList = imageFeedBackList;
        this.meetingRoom = meetingRoom;
        this.content = content;
    }

    private String content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isHandle() {
        return isHandle;
    }

    public void setHandle(boolean handle) {
        isHandle = handle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public boolean isIsHandle() {
        return isHandle;
    }

    public void setIsHandle(boolean isHandle) {
        this.isHandle = isHandle;
    }

    public FeedBackType getFeedBackType() {
        return feedBackType;
    }

    public void setFeedBackType(FeedBackType feedBackType) {
        this.feedBackType = feedBackType;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Notification getNotification() {
        return notification;
    }

    public void setNotification(Notification notification) {
        this.notification = notification;
    }

    public List<ImageFeedBack> getImageFeedBackList() {
        return imageFeedBackList;
    }

    public void setImageFeedBackList(List<ImageFeedBack> imageFeedBackList) {
        this.imageFeedBackList = imageFeedBackList;
    }

    public MeetingRoom getMeetingRoom() {
        return meetingRoom;
    }

    public void setMeetingRoom(MeetingRoom meetingRoom) {
        this.meetingRoom = meetingRoom;
    }

}

