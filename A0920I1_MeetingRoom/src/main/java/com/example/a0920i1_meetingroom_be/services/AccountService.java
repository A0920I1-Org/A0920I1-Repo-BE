package com.example.a0920i1_meetingroom_be.services;

import com.example.a0920i1_meetingroom_be.models.dto.accountDto.AccountListDTO;
import com.example.a0920i1_meetingroom_be.models.entity.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface AccountService {

    Page<AccountListDTO> getPageAllAccount(Pageable pageable);
    void createAccountDto(String division, String email, String fullname, String username, String phone, String imageUrl, Long isDelete, String password);
    Account findByUsername(String username);
    Account findById(Long id);
    void deleteById(Long id);

    void createAccountRole(Long accountId, Long roleId);
//    void update(EmployeeUpdateDTO employee);
}
