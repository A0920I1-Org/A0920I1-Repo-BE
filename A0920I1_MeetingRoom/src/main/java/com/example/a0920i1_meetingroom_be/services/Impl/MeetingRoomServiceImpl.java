package com.example.a0920i1_meetingroom_be.services.Impl;

import com.example.a0920i1_meetingroom_be.models.dto.MeetingRoomDto;
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
    public void updateMeeting(MeetingRoomDto meetingRoomDto) {
        meetingRoomRepository.updateMeeting(meetingRoomDto.getName(),meetingRoomDto.getFloors(),meetingRoomDto.getArea(),meetingRoomDto.getRoomStatus(),meetingRoomDto.getTypeMeetingRoom(),meetingRoomDto.getImageUrl(),meetingRoomDto.getId());
    }


    @Override
    public void deleteMeeting(long id) {
        orderMeetingRepository.deleteOrderMeetingByMeetingRoomId(id);
        orderEquipmentRepository.deleteOrderEquipmentByMeetingRoomId(id);
        meetingRoomRepository.deleteMeetingRoomById(id);
    }


    @Override
    public List<MeetingRoom> searchMeetingRoom(String name ,Integer floors,long area_id , long room_status_id,long type_meeting_room_id,Integer capacity) {
        return meetingRoomRepository.searchMeetingRoom(name, floors, area_id, room_status_id, type_meeting_room_id, capacity);
    }


}
