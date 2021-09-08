package com.example.a0920i1_meetingroom_be.models.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class TypeMeetingRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private Integer capacity;

    @JsonBackReference
    @OneToMany(mappedBy = "typeMeetingRoom")
    private List<MeetingRoom> meetingRoomList;

//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public Integer getCapacity() {
//        return capacity;
//    }
//
//    public void setCapacity(Integer capacity) {
//        this.capacity = capacity;
//    }
//
//    public List<MeetingRoom> getMeetingRoomList() {
//        return meetingRoomList;
//    }
//
//    public void setMeetingRoomList(List<MeetingRoom> meetingRoomList) {
//        this.meetingRoomList = meetingRoomList;
//    }
}
