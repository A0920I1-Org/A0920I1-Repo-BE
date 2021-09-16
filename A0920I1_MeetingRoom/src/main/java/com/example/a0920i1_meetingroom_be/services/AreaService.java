package com.example.a0920i1_meetingroom_be.services;

import com.example.a0920i1_meetingroom_be.models.entity.Area;

import java.util.List;

public interface AreaService {
    // huệ tạo ngày 9/9/2021, chức năng trả về danh sách khu vực
    List<Area> findAll();
}
