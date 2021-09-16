package com.example.a0920i1_meetingroom_be.models.dto.accountDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AccountUpdateDTO {

    String division;
    String email;
    String fullname;
    String username;
    String phone;
    String imageUrl;
    Long roleId;
    Long id;

}
