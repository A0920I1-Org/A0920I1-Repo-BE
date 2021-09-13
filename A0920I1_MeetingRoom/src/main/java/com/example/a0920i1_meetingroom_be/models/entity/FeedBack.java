package com.example.a0920i1_meetingroom_be.models.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@Getter
@Setter
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

    @ManyToOne
    @JoinColumn(name = "feedBackType_id", referencedColumnName = "id")
    private FeedBackType feedBackType;
    @ManyToOne
    @JoinColumn(name = "meetingroom_id", referencedColumnName = "id")
    private MeetingRoom meetingRoom;

    @ManyToOne
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private Account account;

    private String content;


}