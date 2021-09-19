package com.example.a0920i1_meetingroom_be.repositories;

import com.example.a0920i1_meetingroom_be.models.entity.RoomStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomStatusRepository extends JpaRepository<RoomStatus , Long> {

    //hiển thị danh sách trạng thái phòng (Hoàng)
    @Query(value = "SELECT * FROM room_status " , nativeQuery = true)
    List<RoomStatus> findAllRoomStatus();
}
