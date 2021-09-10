package com.example.a0920i1_meetingroom_be.repositories;

import com.example.a0920i1_meetingroom_be.models.entity.Equipment;
import com.example.a0920i1_meetingroom_be.models.entity.MeetingRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface MeetingRoomRepository extends JpaRepository<MeetingRoom, Long> {

    @Query(value = "select u from MeetingRoom u where u.id = ?1")
    List<MeetingRoom> showDetailMeetingRoom(long id);



    // huệ tạo ngày 9/9/2021
    @Query(value = "select * from equipment " , nativeQuery = true)
    List<Equipment> listOrderEquipment();

    // huệ tạo ngày 9/9/2021
    @Transactional
    @Modifying
    @Query(value = "insert into meeting_room(name, floors , image_url, area_id ,room_status_id, type_meeting_room_id) " +
            "values (?1, ?2, ?3, ?4, ?5, ?6)", nativeQuery = true)
    void saveMeeting(String name, int floors, String image_Url, long area_id , long room_status_id, long type_meeting_room_id);
}
