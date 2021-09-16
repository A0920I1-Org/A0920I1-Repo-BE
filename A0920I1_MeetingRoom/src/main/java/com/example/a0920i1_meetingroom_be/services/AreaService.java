package com.example.a0920i1_meetingroom_be.services;

import com.example.a0920i1_meetingroom_be.models.entity.Area;

import java.util.List;

public interface AreaService {
    // lấy danh sách khu vực (Hoàng)
    List<Area> findAllArea();
}
