package com.example.a0920i1_meetingroom_be.services.Impl;

import com.example.a0920i1_meetingroom_be.models.entity.Area;
import com.example.a0920i1_meetingroom_be.repositories.AreaRepository;
import com.example.a0920i1_meetingroom_be.services.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {
    @Autowired
    private AreaRepository areaRepository;

    // (Hoàng)
    @Override
    public List<Area> findAllArea() {
        return areaRepository.findAllArea();

    }
}
