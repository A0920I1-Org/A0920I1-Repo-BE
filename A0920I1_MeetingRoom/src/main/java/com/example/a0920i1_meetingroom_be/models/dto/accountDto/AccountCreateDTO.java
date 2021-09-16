package com.example.a0920i1_meetingroom_be.models.dto.accountDto;

import lombok.Data;

@Data
public class AccountCreateDTO {

    String division;
    String email;
    String fullName;
    String username;
    String phone;
    String imageUrl;
    String password;
    Long roleId;
}
