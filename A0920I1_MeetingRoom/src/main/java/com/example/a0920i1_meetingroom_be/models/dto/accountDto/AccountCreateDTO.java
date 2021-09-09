package com.example.a0920i1_meetingroom_be.models.dto.accountDto;

import lombok.Data;

@Data
public class AccountCreateDTO {
//    division, email, fullname, username, phone , imageurl, is_delete, password
    String division;
    String email;
    String fullName;
    String username;
    String phone;
    String imageUrl;
    Long isDelete;
    String password;
    Long roleId;
}
