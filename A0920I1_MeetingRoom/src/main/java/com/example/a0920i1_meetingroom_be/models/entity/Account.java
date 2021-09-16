package com.example.a0920i1_meetingroom_be.models.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.Type;
import javax.persistence.*;
import java.util.List;

@Entity

public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String username;
    private String password;
    private String fullname;
    private String division;
    private String phone;
    private String email;

    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean isDelete;

    private String imageUrl;

    @JsonBackReference(value = "acc-accrole")
    @OneToMany(mappedBy = "account")
    private List<AccountRole> accountRoleList;

    @JsonBackReference(value = "acc-feedback")
    @OneToMany(mappedBy = "account")
    private List<FeedBack> feedBackList;

    @JsonBackReference(value = "acc-ordermeeting")
    @OneToMany(mappedBy = "account")
    private List<OrderMeeting> orderMeetingList;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<AccountRole> getAccountRoleList() {
        return accountRoleList;
    }

    public void setAccountRoleList(List<AccountRole> accountRoleList) {
        this.accountRoleList = accountRoleList;
    }

    public List<FeedBack> getFeedBackList() {
        return feedBackList;
    }

    public void setFeedBackList(List<FeedBack> feedBackList) {
        this.feedBackList = feedBackList;
    }

    public List<OrderMeeting> getOrderMeetingList() {
        return orderMeetingList;
    }

    public void setOrderMeetingList(List<OrderMeeting> orderMeetingList) {
        this.orderMeetingList = orderMeetingList;
    }
}
