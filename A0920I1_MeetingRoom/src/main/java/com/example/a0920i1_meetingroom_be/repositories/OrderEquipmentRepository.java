package com.example.a0920i1_meetingroom_be.repositories;

import com.example.a0920i1_meetingroom_be.models.entity.OrderEquipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderEquipmentRepository extends JpaRepository<OrderEquipment , Long> {

    // huệ tạo ngày 9/9/2021
    @Query(value = "select * from order_equipment " +
            "where order_equipment.meeting_room_id = ?1", nativeQuery = true)
    List<OrderEquipment> showDetailsMeetingRoom(long id);
}
