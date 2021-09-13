package com.example.a0920i1_meetingroom_be.models.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Getter
@Setter
public class MeetingRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private Integer floors;

    @Type(type = "org.hibernate.type.NumericBooleanType")
    private Boolean status;

    @OneToMany(mappedBy = "meetingRoom")
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
    @JsonBackReference
    @OneToMany(mappedBy = "meetingRoom")
    private List<FeedBack> feedBackList;


}
