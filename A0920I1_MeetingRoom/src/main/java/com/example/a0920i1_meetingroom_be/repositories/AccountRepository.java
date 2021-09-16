package com.example.a0920i1_meetingroom_be.repositories;

import com.example.a0920i1_meetingroom_be.models.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
//account TriNH

@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {
    @Query(value = "select * from account", nativeQuery = true)
    List<Account> getAllAccount();
}

