package com.example.a0920i1_meetingroom_be.models.entity;



import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity

public class AccountRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JsonManagedReference(value = "role-accrole")
    @ManyToOne
    @JoinColumn(name = "role_id" , referencedColumnName = "id")
    private Role role;

    @JsonManagedReference(value = "acc-accrole")
    @ManyToOne
    @JoinColumn(name="account_id" , referencedColumnName = "id")
    private Account account;



}
