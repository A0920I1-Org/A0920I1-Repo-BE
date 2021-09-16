package com.example.a0920i1_meetingroom_be.repositories;

import com.example.a0920i1_meetingroom_be.models.dto.accountDto.AccountListDTO;
import com.example.a0920i1_meetingroom_be.models.dto.accountDto.AccountQueryDto;
import com.example.a0920i1_meetingroom_be.models.entity.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//account TriNH
@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {

    @Query(value = "select account.id , account.division , account.email , account.fullname , account.username , account.phone, account_role.role_id as role\n" +
            "from `account`\n" +
            "left join account_role on account.id = account_role.id\n" +
            "left join role on account_role.role_id = role.id\n" +
            "where account.is_delete = 1", nativeQuery = true)
    Page<AccountListDTO> getPageAllAccount(Pageable pageable);

    @Transactional
    @Modifying
    @Query(value = "insert into account(division, email, fullname, username, phone , image_url, is_delete, password) values (?1, ?2, ?3, ?4, ?5, ?6, ?7, ?8)", nativeQuery = true)
    void createAccountDto(String division, String email, String fullname, String username, String phone, String imageUrl, Long isDelete, String password);

    @Query(value = "select * from `account` where username = ?1 limit 1", nativeQuery = true)
    Account findAccountByUsername(String username);

    @Transactional
    @Modifying
    @Query(value = "update `account`  as m set m.division = ?1,m.email = ?2,m.fullname = ?3,m.username = ?4,m.phone=?5,m.image_url=?6 where m.id = ?7", nativeQuery = true)
    void updateAccount(String division, String email, String fullname, String username, String phone, String imageUrl, Long id);

    @Query(value = "select account.id as id, account.division as division, account.email as email, account.fullname as fullname, " +
            "account.username as username, account.phone as phone, account.image_url as imageUrl, account_role.role_id as roleId" +
            " from `account`" +
            " left join `account_role` on account_role.account_id = account.id where account.id=?1 limit 1",
            nativeQuery = true)
    AccountQueryDto findAccountUpdateById(Long id);

    @Transactional
    @Modifying
    @Query(value = "update `account` set account.is_delete = 0 where account.id=?1", nativeQuery = true)
    void deleteAccountById(Long id);

    @Query(value = "select * from account", nativeQuery = true)
    List<Account> getAllAccount();


    @Query(value = "SELECT * FROM meetingroom.account where username = ?1", nativeQuery = true)
    Account findByUsername(String username);

    @Query(value = "SELECT * FROM meetingroom.account", nativeQuery = true)
    List<Account> findAll();

    Account findByEmail(String email);

    boolean existsByEmail(String email);

}

