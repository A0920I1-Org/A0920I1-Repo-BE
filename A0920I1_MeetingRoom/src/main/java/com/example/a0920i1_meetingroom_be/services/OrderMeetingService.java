package com.example.a0920i1_meetingroom_be.services;

import com.example.a0920i1_meetingroom_be.models.dto.ChartStatistical;
import com.example.a0920i1_meetingroom_be.models.dto.RegisterHistory;
import com.example.a0920i1_meetingroom_be.models.dto.StatisticByDate;
import com.example.a0920i1_meetingroom_be.models.dto.StatisticByRoom;
import com.example.a0920i1_meetingroom_be.models.entity.OrderMeeting;

import java.util.List;

public interface OrderMeetingService {

    //AnhLT
    List<OrderMeeting> statisticByDate(StatisticByDate statisticByDate);
    //AnhLT
    List<OrderMeeting> statisticByRoom(StatisticByRoom statisticByRoom);
    //AnhLT
    List<ChartStatistical> setPerformanceWithChartList();
    //AnhLT
    List<ChartStatistical> totalsOfUses();
    //AnhLT
    List<OrderMeeting> getOrderMeetingByAccountId(String idAccount);
    //AnhLT
    OrderMeeting findOrderById(String idOrderMeeting);
    //AnhLT
    List<OrderMeeting> searchRegisterHistoryBy(RegisterHistory registerHistory);
    //AnhLT
    void deleteOrderMeeting(String idOrder, String reasonDelete);
    //AnhLT
    boolean checkIsDelete(String idOrder);
    //AnhLT
    List<OrderMeeting> getRegisterHistoryByIdMeetingRoom(String idMeetingRoom);

}
