package com.example.a0920i1_meetingroom_be.repositories;

import com.example.a0920i1_meetingroom_be.models.dto.accountDto.AccountListDTO;
import com.example.a0920i1_meetingroom_be.models.entity.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {

    @Query(value = "select account.id , account.division , account.email , account.fullname , account.username , account.phone, role.name as role\n" +
            "from account\n" +
            "left join account_role on account.id = account_role.id\n" +
            "left join role on account_role.role_id = role.id\n" +
            "where account.is_delete = 1", nativeQuery = true)
    Page<AccountListDTO> getPageAllAccount(Pageable pageable);

    @Transactional
    @Modifying
    @Query(value = "insert into account(division, email, fullname, username, phone , image_url, is_delete, password) values (?1, ?2, ?3, ?4, ?5, ?6, ?7, ?8)", nativeQuery = true)
    void createAccountDto(String division, String email, String fullname, String username, String phone, String imageUrl, Long isDelete, String password);

    @Query(value = "select * from account where username = ?1 limit 1", nativeQuery = true)
    Account findAccountByUsername(String username);
}

