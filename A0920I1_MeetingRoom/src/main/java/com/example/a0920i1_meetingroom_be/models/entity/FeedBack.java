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

    private String content;
}

