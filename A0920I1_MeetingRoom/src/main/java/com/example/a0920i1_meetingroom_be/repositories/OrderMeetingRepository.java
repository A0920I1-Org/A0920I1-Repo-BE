package com.example.a0920i1_meetingroom_be.repositories;

import com.example.a0920i1_meetingroom_be.models.entity.OrderMeeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderMeetingRepository extends JpaRepository<OrderMeeting , Long> {
}
