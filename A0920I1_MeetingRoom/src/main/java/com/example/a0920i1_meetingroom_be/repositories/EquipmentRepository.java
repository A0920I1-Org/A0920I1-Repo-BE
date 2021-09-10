package com.example.a0920i1_meetingroom_be.repositories;


import com.example.a0920i1_meetingroom_be.models.entity.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipmentRepository extends JpaRepository<Equipment , Long> {
//    @Query(value = "SELECT * FROM equipment" , nativeQuery = true)
//    List<Equipment> findAllEquipment();


}
