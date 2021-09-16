package com.example.a0920i1_meetingroom_be.repositories;

import com.example.a0920i1_meetingroom_be.models.entity.OrderMeeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface OrderMeetingRepository extends JpaRepository<OrderMeeting , Long> {

    //Xóa (Hoàng)
    @Transactional
    @Modifying
    @Query(value = "delete from order_meeting where order_meeting.meeting_room_id = ?1",nativeQuery = true)
    void deleteOrderMeetingByMeetingRoomId(long id);
}
