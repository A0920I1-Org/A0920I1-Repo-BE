package com.example.a0920i1_meetingroom_be.models.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;
import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
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
    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private List<AccountRole> accountRoleList;

    @JsonBackReference
    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private List<FeedBack> feedBackList;

    @JsonBackReference
    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private List<OrderMeeting> orderMeetingList;
}
