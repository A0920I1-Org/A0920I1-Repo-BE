package com.example.a0920i1_meetingroom_be.services;


import com.example.a0920i1_meetingroom_be.models.dto.MeetingRoomDto;
import com.example.a0920i1_meetingroom_be.models.entity.MeetingRoom;
import java.util.List;

public interface MeetingRoomService {

    // danh sách phòng hop (Hoàng)
    List<MeetingRoom> findAllMeetingRoom();

    //lấy phòng họp theo id (Hoàng)
    MeetingRoom findMeetingRoomById(long id);

    //chỉnh sửa phòng họp (Hoàng)
    void updateMeeting(MeetingRoomDto meetingRoomDto);

    // xóa phòng họp (Hoàng)
    void deleteMeeting(long id);

    // tìm kiếm phòng họp (Hoàng)
    List<MeetingRoom> searchMeetingRoom(String name ,Integer floors,long area_id , long room_status_id,long type_meeting_room_id,Integer capacity );


    // huệ tạo ngày 9/9/2021, chức năng tạo mới phòng họp
    void saveMeetingRoom(String name, int floors, String image_url, long area_id , long room_status_id, long type_meeting_room_id);


}
