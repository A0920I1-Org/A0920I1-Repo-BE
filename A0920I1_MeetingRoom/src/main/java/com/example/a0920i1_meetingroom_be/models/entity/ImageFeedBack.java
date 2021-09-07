package com.example.a0920i1_meetingroom_be.models.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class ImageFeedBack {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "feedBack_id" , referencedColumnName = "id")
    private FeedBack feedBack;


}
