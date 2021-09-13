package com.example.a0920i1_meetingroom_be.repositories;

import com.example.a0920i1_meetingroom_be.models.entity.TypeMeetingRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TypeMeetingRoomRepository extends JpaRepository<TypeMeetingRoom , Long> {
//    @Query(value = "SELECT * FROM type_meeting_room " , nativeQuery = true)
//    List<TypeMeetingRoom> findAllTypeMeetingRoom();

}
