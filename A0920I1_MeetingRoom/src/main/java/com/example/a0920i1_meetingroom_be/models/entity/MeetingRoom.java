package com.example.a0920i1_meetingroom_be.models.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;





@Entity

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



    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "typeMeetingRoom_id", referencedColumnName = "id")
    private TypeMeetingRoom typeMeetingRoom;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "roomStatus_id", referencedColumnName = "id")
    private RoomStatus roomStatus;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "area_id", referencedColumnName = "id")
    private Area area;

    @JsonBackReference
    @OneToMany(mappedBy = "meetingRoom")
    private List<OrderEquipment> orderEquipmentList;

    @JsonBackReference
    @OneToMany(mappedBy = "meetingRoom")
    private List<FeedBack> feedBackList;

    public List<OrderMeeting> getOrderMeetingList() {
        return orderMeetingList;
    }

    public void setOrderMeetingList(List<OrderMeeting> orderMeetingList) {
        this.orderMeetingList = orderMeetingList;
    }

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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
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

    public List<FeedBack> getFeedBackList() {
        return feedBackList;
    }

    public void setFeedBackList(List<FeedBack> feedBackList) {
        this.feedBackList = feedBackList;
    }
}


