package com.example.a0920i1_meetingroom_be.models.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class FeedBack {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dateFeedback;

    private String description;

    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean isHandle;

    @ManyToOne
    @JoinColumn(name = "feedBackType_id", referencedColumnName = "id")
    private FeedBackType feedBackType;

    @ManyToOne
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private Account account;

    @OneToOne(mappedBy = "feedBack")
    private Notification notification;

    @JsonBackReference
    @OneToMany(mappedBy = "feedBack")
    private List<ImageFeedBack> imageFeedBackList;

    @ManyToOne
    @JoinColumn(name = "meetingRoom_id", referencedColumnName = "id")
    private MeetingRoom meetingRoom;

    private String content;

}
