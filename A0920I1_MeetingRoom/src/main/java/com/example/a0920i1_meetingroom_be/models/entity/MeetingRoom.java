package com.example.a0920i1_meetingroom_be.models.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;


@Entity
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class MeetingRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private Integer floors;

    private String image_url;

//    @Type(type = "org.hibernate.type.NumericBooleanType")
//    private Boolean status;

    @JsonBackReference(value = "order_meeting_id")
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

    @JsonBackReference(value = "order_equipment_id")
    @OneToMany(mappedBy = "meetingRoom")
    private List<OrderEquipment> orderEquipmentList;

    public MeetingRoom() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getFloors() {
        return floors;
    }

    public void setFloors(Integer floors) {
        this.floors = floors;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public List<OrderMeeting> getOrderMeetingList() {
        return orderMeetingList;
    }

    public void setOrderMeetingList(List<OrderMeeting> orderMeetingList) {
        this.orderMeetingList = orderMeetingList;
    }

    public TypeMeetingRoom getTypeMeetingRoom() {
        return typeMeetingRoom;
    }

    public void setTypeMeetingRoom(TypeMeetingRoom typeMeetingRoom) {
        this.typeMeetingRoom = typeMeetingRoom;
    }

    public RoomStatus getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(RoomStatus roomStatus) {
        this.roomStatus = roomStatus;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public List<OrderEquipment> getOrderEquipmentList() {
        return orderEquipmentList;
    }

    public void setOrderEquipmentList(List<OrderEquipment> orderEquipmentList) {
        this.orderEquipmentList = orderEquipmentList;
    }
}
