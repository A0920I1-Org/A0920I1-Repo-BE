package com.example.a0920i1_meetingroom_be.repositories;

import com.example.a0920i1_meetingroom_be.models.entity.OrderEquipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderEquipmentRepository extends JpaRepository<OrderEquipment , Long> {

//    @Query(value = "select OrderEquipment .id, OrderEquipment .quantity,Equipment .name,MeetingRoom .name from OrderEquipment" +
//            " join Equipment on OrderEquipment .id= Equipment .id " +
//            "join MeetingRoom on OrderEquipment .id= MeetingRoom .id")
//
//    List<OrderEquipment> findAllOrderEquipment();
}
