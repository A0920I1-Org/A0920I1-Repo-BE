package com.example.a0920i1_meetingroom_be.services;

import com.example.a0920i1_meetingroom_be.models.entity.MeetingRoom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.*;

public interface MeetingRoomService {
    Page<MeetingRoom> findAllMeetingRoom(Pageable pageable);
    List<MeetingRoom> findAll();
    void saveMeetingRoom(String name, int floors, String image_url, long area_id , long room_status_id, long type_meeting_room_id);
    MeetingRoom showDetailMeetingRoom(long id);

}
