package com.example.a0920i1_meetingroom_be.services;

import com.example.a0920i1_meetingroom_be.models.entity.MeetingRoom;

import java.util.*;

public interface MeetingRoomService {

    // huệ tạo ngày 9/9/2021, chức năng trả về danh sách phòng họp
    List<MeetingRoom> findAll();

    // huệ tạo ngày 9/9/2021, chức năng tạo mới phòng họp
    void saveMeetingRoom(String name, int floors, String image_url, long area_id , long room_status_id, long type_meeting_room_id);

    // huệ tạo ngày 9/9/2021, chức năng trả về phòng họp theo id
    MeetingRoom showDetailMeetingRoom(long id);

}
