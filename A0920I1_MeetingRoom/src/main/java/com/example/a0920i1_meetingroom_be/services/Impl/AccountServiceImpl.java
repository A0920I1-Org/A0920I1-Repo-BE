package com.example.a0920i1_meetingroom_be.services.Impl;

import com.example.a0920i1_meetingroom_be.models.entity.Account;
import com.example.a0920i1_meetingroom_be.repositories.AccountRepository;
import com.example.a0920i1_meetingroom_be.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account findAccountByUsername(String username) {
        return accountRepository.findByUsername(username);
    }
}
