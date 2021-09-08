package com.example.a0920i1_meetingroom_be.repositories;

import com.example.a0920i1_meetingroom_be.models.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {
    Account findByUsername(String username);


//    @Query("select role.name, username " +
//            "from account a2 " +
//            "inner join account_role on a2.id = account_role.id " +
//            "inner join role on account_role.id = role.id " +
//            "where username = :username")
//    UserRole findRoleByUsername(@Param("username") String username);
}

