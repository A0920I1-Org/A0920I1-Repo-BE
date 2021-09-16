package com.example.a0920i1_meetingroom_be.services;

import com.example.a0920i1_meetingroom_be.models.entity.Role;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RoleService {

    List<Role> findAll();

}
