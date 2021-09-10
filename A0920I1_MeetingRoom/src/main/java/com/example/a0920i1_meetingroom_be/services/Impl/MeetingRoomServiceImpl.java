package com.example.a0920i1_meetingroom_be.services.Impl;

import com.example.a0920i1_meetingroom_be.models.entity.MeetingRoom;
import com.example.a0920i1_meetingroom_be.repositories.MeetingRoomRepository;
import com.example.a0920i1_meetingroom_be.repositories.OrderEquipmentRepository;
import com.example.a0920i1_meetingroom_be.repositories.OrderMeetingRepository;
import com.example.a0920i1_meetingroom_be.services.MeetingRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeetingRoomServiceImpl implements MeetingRoomService {
    @Autowired
    private MeetingRoomRepository meetingRoomRepository ;

    @Autowired
    private OrderEquipmentRepository orderEquipmentRepository;

    @Autowired
    private OrderMeetingRepository orderMeetingRepository;

    @Override
    public List<MeetingRoom> findAllMeetingRoom() {
        return this.meetingRoomRepository.findAllMeetingRoom();
    }

    @Override
    public MeetingRoom findById(long id) {
        return this.meetingRoomRepository.findByIdMeetingRoom(id);
    }

    @Override
    public void updateMeeting(String name, int floors, long area_id, long room_status_id, long type_meeting_room_id, String image_url,long id) {
        meetingRoomRepository.updateMeeting(name, floors, area_id, room_status_id, type_meeting_room_id, image_url, id);
    }

    @Override
    public void deleteMeeting(long id) {
        orderMeetingRepository.deleteOrderMeetingByMeetingRoomId(id);
        orderEquipmentRepository.deleteOrderEquipmentByMeetingRoomId(id);
        meetingRoomRepository.deleteMeetingRoomById(id);
    }

}
