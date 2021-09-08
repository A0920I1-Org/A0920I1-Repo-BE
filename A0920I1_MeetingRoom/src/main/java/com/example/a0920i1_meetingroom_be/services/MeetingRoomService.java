package com.example.a0920i1_meetingroom_be.services;

import com.example.a0920i1_meetingroom_be.models.entity.Equipment;
import com.example.a0920i1_meetingroom_be.models.entity.MeetingRoom;
import com.example.a0920i1_meetingroom_be.models.entity.OrderEquipment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.*;

public interface MeetingRoomService {
    Page<MeetingRoom> findAllMeetingRoom(Pageable pageable);
    List<MeetingRoom> findAll();
    void saveMeetingRoom(MeetingRoom meetingRoom);
    List<MeetingRoom> showDetailMeetingRoom(long id);

    List<Equipment> listOrderEquipment();
}
