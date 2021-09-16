package com.example.a0920i1_meetingroom_be.repositories;

import com.example.a0920i1_meetingroom_be.models.entity.Area;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
@Service
public interface AreaRepository extends JpaRepository<Area , Long> {
    //lấy danh sách khu vực (Hoàng)
    @Query(value = "SELECT * FROM area " , nativeQuery = true)
    List<Area> findAllArea();
}
