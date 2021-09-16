package com.example.a0920i1_meetingroom_be.repositories;

import com.example.a0920i1_meetingroom_be.models.entity.MeetingRoom;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

//lay danh sach meetingroom TriNH

@Repository
public interface MeetingRoomRepository extends JpaRepository<MeetingRoom, Long> {

    @Transactional
    @Modifying
    @Query(value = "delete from order_equipment where id = ?1",nativeQuery = true)
    void deleteEquipmentById(long id);


    // hiển thị tất cả phòng họp (HoangLV)
    @Query(value = "SELECT m FROM MeetingRoom m")
    List<MeetingRoom> findAllMeetingRoom();

    //lấy  phòng họp theo Id (Hoàng)
    @Query(value = "select * from meeting_room " +
            "where meeting_room.id = ?1", nativeQuery = true)
    MeetingRoom findByIdMeetingRoom(long id);


    //Chỉnh sửa phòng họp (Hoàng)
    @Transactional
    @Modifying
    @Query(value = "update meetingroom.meeting_room set name = ?1,  floors = ?2, area_id = ?3 , room_status_id = ?4 , type_meeting_room_id = ?5 , image_url = ?6  where id = ?7", nativeQuery = true)
    void updateMeeting(String name , int floors , long area_id , long room_status_id , long type_meeting_room_id , String image_url,long id);

    //Xóa phòng họp theo Id (Hoàng)
    @Transactional
    @Modifying
    @Query( value = " delete from meeting_room where meeting_room.id = ?1 " , nativeQuery = true)
    void deleteMeetingRoomById(long id);


    //Tìm kiếm đầy đủ các trường (Hoàng)
    @Query(value = "select * from meeting_room join type_meeting_room on type_meeting_room.id = type_meeting_room_id" +
            " where meeting_room.name like %?1% " +
            "and floors like %?2% " +
            "and meeting_room.area_id like %?3% " +
            "and meeting_room.room_status_id like %?4% " +
            "and meeting_room.type_meeting_room_id like %?5% " +
            "and type_meeting_room.capacity like %?6%" , nativeQuery = true)
    List<MeetingRoom> searchMeetingRoom(String name ,Integer floors,long area_id , long room_status_id,long type_meeting_room_id,Integer capacity );

    // huệ tạo ngày 9/9/2021, thêm mới 1 phòng họp
    @Transactional
    @Modifying
    @Query(value = "insert into meeting_room(name, floors , image_url, area_id ,room_status_id, type_meeting_room_id) " +
            "values (?1, ?2, ?3, ?4, ?5, ?6)", nativeQuery = true)
    void saveMeeting(String name, int floors, String image_Url, long area_id , long room_status_id, long type_meeting_room_id);

}
