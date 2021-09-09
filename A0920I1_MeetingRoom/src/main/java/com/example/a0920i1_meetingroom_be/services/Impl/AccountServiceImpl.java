package com.example.a0920i1_meetingroom_be.services.Impl;

import com.example.a0920i1_meetingroom_be.models.dto.accountDto.AccountListDTO;
import com.example.a0920i1_meetingroom_be.models.entity.Account;
import com.example.a0920i1_meetingroom_be.repositories.AccountRepository;
import com.example.a0920i1_meetingroom_be.repositories.AccountRoleRepository;
import com.example.a0920i1_meetingroom_be.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private AccountRoleRepository accountRoleRepository;

    @Override
    public Page<AccountListDTO> getPageAllAccount(Pageable pageable) {
        return accountRepository.getPageAllAccount(pageable);
    }

    @Override
    public void createAccountDto(String division, String email, String fullname, String username, String phone, String imageUrl, Long isDelete, String password) {
        accountRepository.createAccountDto(division, email, fullname, username, phone, imageUrl, isDelete, password);
    }

    @Override
    public Account findByUsername(String username) {
        return accountRepository.findAccountByUsername(username);
    }

    @Override
    public Account findById(Long id) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void createAccountRole(Long accountId, Long roleId) {
        accountRoleRepository.createAccountRole(accountId,roleId);
    }
}
