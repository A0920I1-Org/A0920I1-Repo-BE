package com.example.a0920i1_meetingroom_be.services;

import com.example.a0920i1_meetingroom_be.models.dto.accountDto.AccountListDTO;
import com.example.a0920i1_meetingroom_be.models.dto.accountDto.AccountQueryDto;
import com.example.a0920i1_meetingroom_be.models.dto.accountDto.AccountUpdateDTO;
import com.example.a0920i1_meetingroom_be.models.entity.Account;
import com.example.a0920i1_meetingroom_be.models.entity.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AccountService {

    Page<AccountListDTO> getPageAllAccount(Pageable pageable);
    void createAccountDto(String division, String email, String fullname, String username, String phone, String imageUrl, Long isDelete, String password);
    Account findByUsername(String username);
    void deleteById(Long id);
    AccountQueryDto findAccountUpdateById(Long id);

    List<Role> findAll();

    void update(AccountUpdateDTO account);

    void createAccountRole(Long accountId, Long roleId);

    List<Account> getAllAccount();


//    TuHC
    Account findAccountByUsername(String username);

//    Account findAccountByEmail(String email);
//    Optional<Account> findAccountById(Long id);

}
