package com.example.a0920i1_meetingroom_be.repositories;

import com.example.a0920i1_meetingroom_be.models.entity.OrderEquipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface OrderEquipmentRepository extends JpaRepository<OrderEquipment , Long> {

    //xóa (Hoàng)
    @Transactional
    @Modifying
    @Query(value = "delete from order_equipment where order_equipment.meeting_room_id = ?1",nativeQuery = true )
    void deleteOrderEquipmentByMeetingRoomId(long id);

}
