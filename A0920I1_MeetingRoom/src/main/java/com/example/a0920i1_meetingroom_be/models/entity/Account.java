package com.example.a0920i1_meetingroom_be.models.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="id")
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

//    @JsonManagedReference
    @OneToMany(mappedBy = "account")
    private List<AccountRole> accountRoleList;

//    @JsonManagedReference
    @OneToMany(mappedBy = "account")
    private List<FeedBack> feedBackList;

//    @JsonManagedReference
    @OneToMany(mappedBy = "account")
    private List<OrderMeeting> orderMeetingList;


}
