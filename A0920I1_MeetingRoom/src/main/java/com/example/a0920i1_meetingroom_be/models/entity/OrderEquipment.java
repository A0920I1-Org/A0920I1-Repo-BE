package com.example.a0920i1_meetingroom_be.models.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class OrderEquipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "equipment_id" , referencedColumnName = "id")
    private Equipment equipment;

    @ManyToOne
    @JoinColumn(name = "meetingRoom_id" , referencedColumnName = "id")
    private MeetingRoom meetingRoom;

//    public long getId() {
//        return id;
//    }

//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public Equipment getEquipment() {
//        return equipment;
//    }
//
//    public void setEquipment(Equipment equipment) {
//        this.equipment = equipment;
//    }
//
//    public MeetingRoom getMeetingRoom() {
//        return meetingRoom;
//    }
//
//    public void setMeetingRoom(MeetingRoom meetingRoom) {
//        this.meetingRoom = meetingRoom;
//    }
}
