package com.example.a0920i1_meetingroom_be.repositories;

import com.example.a0920i1_meetingroom_be.models.entity.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface EquipmentRepository extends JpaRepository<Equipment , Long> {

    // huệ tạo ngày 9/9/2021, chức năng query lấy danh sách tài sản
    @Query(value = "SELECT * FROM equipment u" , nativeQuery = true)
    List<Equipment> listEquipment();

    // huệ tạo ngày 9/9/2021, chức năng query tìm kiếm tài sản theo tên
    @Query(value = "SELECT * FROM equipment where name like %?1%" , nativeQuery = true)
    List<Equipment> findEquipmentByName(String name);



}
