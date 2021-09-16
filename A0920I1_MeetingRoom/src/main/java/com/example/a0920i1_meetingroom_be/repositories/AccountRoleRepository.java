package com.example.a0920i1_meetingroom_be.repositories;

import com.example.a0920i1_meetingroom_be.models.entity.AccountRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface AccountRoleRepository extends JpaRepository<AccountRole,Long> {
    @Transactional
    @Modifying
    @Query(value = "insert into account_role(account_id, role_id) values (?1, ?2)", nativeQuery = true)
    void createAccountRole(long accountId, long roleId);
}
