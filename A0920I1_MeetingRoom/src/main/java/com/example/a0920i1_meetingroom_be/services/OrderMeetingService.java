package com.example.a0920i1_meetingroom_be.services;

import com.example.a0920i1_meetingroom_be.models.dto.RegisterHistory;
import com.example.a0920i1_meetingroom_be.models.dto.StatisticByDate;
import com.example.a0920i1_meetingroom_be.models.dto.StatisticByRoom;
import com.example.a0920i1_meetingroom_be.models.dto.ChartStatistical;
import com.example.a0920i1_meetingroom_be.models.entity.OrderMeeting;

import java.util.List;

public interface OrderMeetingService {
    List<OrderMeeting> statisticByDate(StatisticByDate statisticByDate);
    List<OrderMeeting> statisticByRoom(StatisticByRoom statisticByRoom);
    List<ChartStatistical> calculatorPerformanceByDate();
    List<ChartStatistical> totalsOfUses();
    List<OrderMeeting> getOrderMeetingByAccountId(String idAccount);
    OrderMeeting findOrderById(String idOrderMeeting);
    List<OrderMeeting> findRegisterHistory(RegisterHistory registerHistory, String idAccount);
    void deleteOrderMeeting(String idOrder, String reasonDelete);
    boolean checkIsDelete(String idOrder);

    List<OrderMeeting> getRegisterHistoryByIdMeetingRoom(String idMeetingRoom);
}
