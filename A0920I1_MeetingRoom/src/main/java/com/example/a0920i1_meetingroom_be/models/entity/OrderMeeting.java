package com.example.a0920i1_meetingroom_be.models.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Data
@NoArgsConstructor
public class OrderMeeting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dateCheckin;
    
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dateCheckout;

    @ManyToOne
    @JoinColumn(name = "meetingRoom_id" , referencedColumnName = "id")
    private MeetingRoom meetingRoom;

    @ManyToOne
    @JoinColumn(name = "account_id" , referencedColumnName = "id")
    private Account account;

    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalTime timeStart;

    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalTime timeEnd;

    private String description;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime deleteTime;

    private String reasonDelete;

    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean isConfirm;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate createDate;

}
