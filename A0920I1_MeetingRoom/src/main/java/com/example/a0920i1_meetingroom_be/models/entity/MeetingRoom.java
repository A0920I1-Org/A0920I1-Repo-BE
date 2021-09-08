package com.example.a0920i1_meetingroom_be.models.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class MeetingRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private Integer floors;
    private String imageUrl;

    @OneToMany(mappedBy = "meetingRoom")
    @JsonBackReference
    private List<OrderMeeting> orderMeetingList;

    @ManyToOne
    @JoinColumn(name = "typeMeetingRoom_id" , referencedColumnName = "id")
    private TypeMeetingRoom typeMeetingRoom;

    @ManyToOne
    @JoinColumn(name = "roomStatus_id" , referencedColumnName = "id")
    private RoomStatus roomStatus;

    @ManyToOne
    @JoinColumn(name = "area_id" , referencedColumnName = "id")
    private Area area;

    @JsonBackReference
    @OneToMany(mappedBy = "meetingRoom")
    private List<OrderEquipment> orderEquipmentList;

    @OneToMany(mappedBy = "meetingRoom")
    private List<FeedBack> feedBackList;


}
