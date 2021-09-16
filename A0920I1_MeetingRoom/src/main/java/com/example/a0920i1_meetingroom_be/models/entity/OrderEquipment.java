package com.example.a0920i1_meetingroom_be.models.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;


import javax.persistence.*;

@Entity
//@Data
//@NoArgsConstructor
public class OrderEquipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long quantity;


    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "equipment_id", referencedColumnName = "id")
    private Equipment equipment;


    @JsonManagedReference
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "meetingRoom_id" , referencedColumnName = "id")
    private MeetingRoom meetingRoom;

}
