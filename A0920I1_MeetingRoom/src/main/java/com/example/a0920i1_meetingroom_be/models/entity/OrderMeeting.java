package com.example.a0920i1_meetingroom_be.models.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
//Data
//@NoArgsConstructor@
public class OrderMeeting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "meetingRoom_id" , referencedColumnName = "id")
    private MeetingRoom meetingRoom;

    @ManyToOne
    @JoinColumn(name = "account_id" , referencedColumnName = "id")
    private Account account;

//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public MeetingRoom getMeetingRoom() {
//        return meetingRoom;
//    }
//
//    public void setMeetingRoom(MeetingRoom meetingRoom) {
//        this.meetingRoom = meetingRoom;
//    }
//
//    public Account getAccount() {
//        return account;
//    }
//
//    public void setAccount(Account account) {
//        this.account = account;
//    }

    public OrderMeeting() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public MeetingRoom getMeetingRoom() {
        return meetingRoom;
    }

    public void setMeetingRoom(MeetingRoom meetingRoom) {
        this.meetingRoom = meetingRoom;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
