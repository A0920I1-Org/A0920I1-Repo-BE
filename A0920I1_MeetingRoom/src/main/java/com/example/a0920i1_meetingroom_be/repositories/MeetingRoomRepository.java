package com.example.a0920i1_meetingroom_be.repositories;

import com.example.a0920i1_meetingroom_be.models.entity.Area;
import com.example.a0920i1_meetingroom_be.models.entity.MeetingRoom;
import com.example.a0920i1_meetingroom_be.models.entity.RoomStatus;
import com.example.a0920i1_meetingroom_be.models.entity.TypeMeetingRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.swing.*;
import java.util.List;

@Repository
public interface MeetingRoomRepository extends JpaRepository<MeetingRoom, Long> {
    @Query(value = "SELECT m FROM MeetingRoom m")
    List<MeetingRoom> findAllMeetingRoom();

    @Query(value = "SELECT m FROM MeetingRoom m WHERE m.id = ?1")
    MeetingRoom findByIdMeetingRoom(long id);

//       @Query(value = "UPDATE MeetingRoom m SET m.name = :name , m.floors = :floors, m.area = :area , m.roomStatus = :roomStatus , m.typeMeetingRoom = :typeMeetingRoom , m.image_url = : image_url WHERE m.id = :id")
//    void updateMeetingRoom(@Param("name") String name ,@Param("floors") Integer floors ,@Param("area") Area area ,@Param("roomStatus") RoomStatus roomStatus ,@Param("typeMeetingRoom") TypeMeetingRoom typeMeetingRoom ,@Param("image_url") String image_url,@Param("id") long id);

}
