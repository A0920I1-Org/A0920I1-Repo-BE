package com.example.a0920i1_meetingroom_be.repositories;

import com.example.a0920i1_meetingroom_be.models.entity.OrderEquipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface OrderEquipmentRepository extends JpaRepository<OrderEquipment , Long> {
    @Transactional
    @Modifying
    @Query(value = "delete from order_equipment where order_equipment.equipment_id = ?1",nativeQuery = true)
    void deleteOrderEquipmentById(long id);
}
