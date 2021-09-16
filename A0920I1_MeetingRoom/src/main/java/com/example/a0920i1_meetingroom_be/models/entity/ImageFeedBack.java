package com.example.a0920i1_meetingroom_be.models.entity;

import javax.persistence.*;

@Entity
public class ImageFeedBack {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "feedBack_id" , referencedColumnName = "id")
    private FeedBack feedBack;


}
