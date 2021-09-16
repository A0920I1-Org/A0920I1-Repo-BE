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
    @Query(value = "delete from order_equipment where order_equipment.meeting_room_id = ?1",nativeQuery = true )
    void deleteOrderEquipmentByMeetingRoomId(long id);


    // huệ tạo ngày 9/9/2021
    @Query(value = "select * from order_equipment " +
            "where meeting_room_id = ?1", nativeQuery = true)
    OrderEquipment showDetailsMeetingRoom(long id);

    @Modifying
    @Transactional
    @Query(value ="insert into order_equipment (quantity, equipment_id, meeting_room_id) " +
            "values(?1, ?2,?3)", nativeQuery = true)
    void insertOrderEquipment(long quantity, long equipment_id, long meeting_room_id);

    @Query(value = "select * from order_equipment where order_equipment.meeting_room_id = ?1", nativeQuery = true)
    List<OrderEquipment> listEquipmentByIdMeetingRoom(long id);

}
