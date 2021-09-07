package com.example.a0920i1_meetingroom_be.services;

import com.example.a0920i1_meetingroom_be.models.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;

public interface AccountService {
    Account findAccountByUsername(String username);
}
