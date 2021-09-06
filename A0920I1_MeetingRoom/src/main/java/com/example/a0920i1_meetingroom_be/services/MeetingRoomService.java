package com.example.a0920i1_meetingroom_be.services;

import com.example.a0920i1_meetingroom_be.models.entity.MeetingRoom;

import java.util.*;

public interface MeetingRoomService {
    void saveMeetingRoom(MeetingRoom meetingRoom);
    List<MeetingRoom> showDetailMeetingRoom(long id);
}
