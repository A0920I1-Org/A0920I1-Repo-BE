package com.example.a0920i1_meetingroom_be.services;

import com.example.a0920i1_meetingroom_be.models.dto.MeetingRoomDto;
import com.example.a0920i1_meetingroom_be.models.entity.MeetingRoom;
import java.util.List;

public interface MeetingRoomService {
    List<MeetingRoom> findAllMeetingRoom();
    MeetingRoom findById(long id);

    void updateMeeting(MeetingRoomDto meetingRoomDto);

    void deleteMeeting(long id);


    List<MeetingRoom> searchMeetingRoom(String name ,Integer floors,long area_id , long room_status_id,long type_meeting_room_id,Integer capacity );

}
