package com.example.a0920i1_meetingroom_be.services.Impl;

import com.example.a0920i1_meetingroom_be.models.dto.RegisterHistory;
import com.example.a0920i1_meetingroom_be.models.dto.StatisticByDate;
import com.example.a0920i1_meetingroom_be.models.dto.StatisticByRoom;
import com.example.a0920i1_meetingroom_be.models.dto.ChartStatistical;
import com.example.a0920i1_meetingroom_be.models.entity.MeetingRoom;
import com.example.a0920i1_meetingroom_be.models.entity.OrderMeeting;
import com.example.a0920i1_meetingroom_be.repositories.MeetingRoomRepository;
import com.example.a0920i1_meetingroom_be.repositories.OrderMeetingRepository;
import com.example.a0920i1_meetingroom_be.services.OrderMeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderMeetingServiceImpl implements OrderMeetingService {
    @Autowired
    OrderMeetingRepository orderMeetingRepository;

    @Autowired
    MeetingRoomRepository meetingRoomRepository;

    private List<OrderMeeting> statisticList;
//    Long getDayDiff;
//    private final DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd "+"HH:mm:ss");

    @Override
    public List<OrderMeeting> statisticByDate(StatisticByDate statisticByDate) {
        System.out.println("impl statistic by date");
//        try{
//            getDayDiff = (simpleDateFormat.parse(statisticByDate.getDateCheckin()+" 00:00:00").getTime() -simpleDateFormat.parse(statisticByDate.getDateCheckout()+" 00:00:00").getTime());
//            System.out.println("So ngay :"+getDayDiff);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
        System.out.println(statisticByDate.getDateCheckin());
        System.out.println(statisticByDate.getDateCheckout());

        if (statisticByDate.getDateCheckin() == null) {
            System.out.println("checkin null and checkout = " + statisticByDate.getDateCheckout());
            statisticList = orderMeetingRepository.statisticByDateCheckinNull(statisticByDate.getDateCheckout());
            return orderMeetingRepository.statisticByDateCheckinNull(statisticByDate.getDateCheckout());
        }
        if (statisticByDate.getDateCheckout() == null) {
            System.out.println("checkout null and checkin = " + statisticByDate.getDateCheckin());
            statisticList = orderMeetingRepository.statisticByDateCheckoutNull(statisticByDate.getDateCheckin());
            return orderMeetingRepository.statisticByDateCheckoutNull(statisticByDate.getDateCheckin());
        }
        System.out.println("checkin checkout");
        statisticList = orderMeetingRepository.statisticByDate(statisticByDate.getDateCheckin(),statisticByDate.getDateCheckout());
        return orderMeetingRepository.statisticByDate(
                statisticByDate.getDateCheckin(),
                statisticByDate.getDateCheckout());
    }

    @Override
    public List<OrderMeeting> statisticByRoom(StatisticByRoom statisticByRoom) {
        System.out.println("statisticByRoom");
        System.out.println(statisticByRoom.getIdMeetingRoom());
        System.out.println(statisticByRoom.getIdTypeMeetingRoom());
        System.out.println(statisticByRoom.getMonth());
        if (statisticByRoom.getIdMeetingRoom()==null){
            statisticByRoom.setIdMeetingRoom("");
            System.out.println(statisticByRoom.getIdMeetingRoom());
        }
        if (statisticByRoom.getIdTypeMeetingRoom()==null){
            statisticByRoom.setIdTypeMeetingRoom("");
            System.out.println(statisticByRoom.getIdTypeMeetingRoom());
        }
        if (statisticByRoom.getMonth()==null){
            statisticByRoom.setMonth("");
            System.out.println(statisticByRoom.getMonth());
        }
        statisticList = orderMeetingRepository.statisticByRoom(
                statisticByRoom.getIdTypeMeetingRoom(),
                statisticByRoom.getIdMeetingRoom(),
                statisticByRoom.getMonth()
        );
        return orderMeetingRepository.statisticByRoom(
                statisticByRoom.getIdTypeMeetingRoom(),
                statisticByRoom.getIdMeetingRoom(),
                statisticByRoom.getMonth());
    }

    @Override
    public List<ChartStatistical> calculatorPerformanceByDate() {
//            List<ChartStatistical> chartStatisticalList = new ArrayList<>();

//        List<MeetingRoom> meetingRoom = meetingRoomRepository.findAll();
//        for (int i = 0; i < meetingRoom.size(); i++) {
//            chartStatisticalList.add(new ChartStatistical(meetingRoom.get(i).getName(), 0));
//            System.out.println(chartStatisticalList.get(i).getNameMeetingRoom());
//            System.out.println(chartStatisticalList.get(i).getUses());
//        }
//        // xu li time tinh performance
//
//        if (statisticList != null) {
//
//            for (int i = 0; i < statisticList.size(); i++) {
//                for (int j = 0; j < chartStatisticalList.size(); j++) {
//                    if (statisticList.get(i).getMeetingRoom().getName().equals(chartStatisticalList.get(j).getNameMeetingRoom())) {
//
//                        break;
//                    }
//                }
//            }
//        }
        return new ArrayList<>();
    }

    @Override
    public List<ChartStatistical> totalsOfUses() {
            List<ChartStatistical> chartStatisticalList = new ArrayList<>();
        List<MeetingRoom> meetingRoom = meetingRoomRepository.findAll();
        for (int i = 0; i < meetingRoom.size(); i++) {
            chartStatisticalList.add(new ChartStatistical(meetingRoom.get(i).getName(), 0));
        }
        if (statisticList != null) {
            System.out.println("vào đây không ta");
            for (OrderMeeting orderMeeting : statisticList) {
                for (ChartStatistical chartStatistical : chartStatisticalList) {
                    if (orderMeeting.getMeetingRoom().getName().equals(chartStatistical.getNameMeetingRoom())) {
                        chartStatistical.setUses(chartStatistical.getUses() + 1);
                        break;
                    }
                }
            }
        }
        return chartStatisticalList;
    }

    @Override
    public List<OrderMeeting> getOrderMeetingByAccountId(String accountId) {
        return orderMeetingRepository.getOrderMeetingByAccountId(accountId);
    }

    @Override
    public OrderMeeting findOrderById(String idOrder) {
        return orderMeetingRepository.findOrderMeetingByIdOrder(idOrder);
    }

    @Override
    public List<OrderMeeting> findRegisterHistory(RegisterHistory registerHistory, String accountId) {
        if (registerHistory.getIdMeetingRoom()==null){
            registerHistory.setIdMeetingRoom("");
        }
        if (registerHistory.getIdStatusRoom()==null){
            registerHistory.setIdStatusRoom("");
        }
        if (registerHistory.getIdTypeRoom()==null){
            registerHistory.setIdTypeRoom("");
        }
        if (registerHistory.getCreateDate()==null){
            registerHistory.setCreateDate("");
        }
        if (registerHistory.getDateCheckin()==null){
            return orderMeetingRepository.findRegisterHistoryDateCheckinNull(
              registerHistory.getIdMeetingRoom() ,
              registerHistory.getDateCheckout(),
              registerHistory.getIdStatusRoom(),
              registerHistory.getIdTypeRoom(),
              registerHistory.getCreateDate()  ,
              accountId
            );
        }
        if (registerHistory.getDateCheckout()==null){
            return orderMeetingRepository.findRegisterHistoryDateCheckoutNull(
                    registerHistory.getIdMeetingRoom() ,
                    registerHistory.getDateCheckin(),
                    registerHistory.getIdStatusRoom(),
                    registerHistory.getIdTypeRoom(),
                    registerHistory.getCreateDate() ,
                    accountId
            );
        }
        return orderMeetingRepository.findRegisterHistory(
                registerHistory.getIdMeetingRoom(),
                registerHistory.getDateCheckin(),
                registerHistory.getDateCheckout(),
                registerHistory.getIdStatusRoom(),
                registerHistory.getIdTypeRoom(),
                registerHistory.getCreateDate(),
                accountId
        );
    }

    @Override
    public void deleteRegister(String idOrder, String reasonDelete) {
        orderMeetingRepository.deleteRegister(idOrder,reasonDelete);
    }


}
