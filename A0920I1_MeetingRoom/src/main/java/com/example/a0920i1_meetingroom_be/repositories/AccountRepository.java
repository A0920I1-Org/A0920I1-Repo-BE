package com.example.a0920i1_meetingroom_be.repositories;

import com.example.a0920i1_meetingroom_be.models.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {
    @Query(value = "SELECT * FROM meetingroom.account where username = ?1", nativeQuery = true)
    Account findByUsername(String username);

    @Query(value = "SELECT * FROM meetingroom.account", nativeQuery = true)
    List<Account> findAll();

}

