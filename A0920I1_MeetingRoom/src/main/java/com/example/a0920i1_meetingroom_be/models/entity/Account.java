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

    @JsonBackReference
    @OneToMany(mappedBy = "account")
    private List<AccountRole> accountRoleList;

    @JsonBackReference
    @OneToMany(mappedBy = "account")
    private List<FeedBack> feedBackList;

    @JsonBackReference
    @OneToMany(mappedBy = "account")
    private List<OrderMeeting> orderMeetingList;

}
