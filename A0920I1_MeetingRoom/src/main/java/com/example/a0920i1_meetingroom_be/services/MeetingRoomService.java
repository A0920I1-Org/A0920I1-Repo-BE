package com.example.a0920i1_meetingroom_be.services;

import com.example.a0920i1_meetingroom_be.models.entity.Area;
import com.example.a0920i1_meetingroom_be.models.entity.MeetingRoom;
import com.example.a0920i1_meetingroom_be.models.entity.RoomStatus;
import com.example.a0920i1_meetingroom_be.models.entity.TypeMeetingRoom;
import org.springframework.data.repository.query.Param;

import javax.swing.*;
import java.util.List;

public interface MeetingRoomService {
    List<MeetingRoom> findAllMeetingRoom();
    MeetingRoom findById(long id);
    void updateMeeting(String name , int floors , long area_id , long room_status_id , long type_meeting_room_id , String image_url,long id);

    void deleteMeeting(long id);
}
