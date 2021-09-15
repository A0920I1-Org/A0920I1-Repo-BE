package com.example.a0920i1_meetingroom_be.services;

import com.example.a0920i1_meetingroom_be.models.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public interface AccountService {
    Account findAccountByUsername(String username);
    List<Account> findAllAccount();

//    Account findAccountByEmail(String email);
//    Optional<Account> findAccountById(Long id);

}
