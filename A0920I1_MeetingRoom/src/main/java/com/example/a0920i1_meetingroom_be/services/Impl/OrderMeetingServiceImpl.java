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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

@Service
public class OrderMeetingServiceImpl implements OrderMeetingService {
    @Autowired
    OrderMeetingRepository orderMeetingRepository;

    @Autowired
    MeetingRoomRepository meetingRoomRepository;

    private List<OrderMeeting> statisticList;
    float daysBetweenBySearch = 0; //bien dem ngay sau khi search theo date or room

    SimpleDateFormat myDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    // HH:mm:ss.SSSXXX
    SimpleDateFormat myTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    public float getDaysBetween(String dateCheckin, String dateCheckout) {
        float daysBetween = 0;
        try {
            Date dateStart = myDateFormat.parse(dateCheckin);
            Date dateEnd = myDateFormat.parse(dateCheckout);
            long getDayDiffBySearch = (dateEnd.getTime() - dateStart.getTime());
            daysBetween = (float) (getDayDiffBySearch / (1000 * 60 * 60 * 24));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return daysBetween;
    }

    @Override
    public List<OrderMeeting> statisticByDate(StatisticByDate statisticByDate) {
        //tinh diff : end - start
        daysBetweenBySearch = getDaysBetween(statisticByDate.getDateCheckin(), statisticByDate.getDateCheckout());

        // statistical by date
        if (statisticByDate.getDateCheckin() == null) {
            statisticList = orderMeetingRepository.statisticByDateCheckinNull(statisticByDate.getDateCheckout());
            return orderMeetingRepository.statisticByDateCheckinNull(statisticByDate.getDateCheckout());
        }
        if (statisticByDate.getDateCheckout() == null) {
            statisticList = orderMeetingRepository.statisticByDateCheckoutNull(statisticByDate.getDateCheckin());
            return orderMeetingRepository.statisticByDateCheckoutNull(statisticByDate.getDateCheckin());
        }
        statisticList = orderMeetingRepository.statisticByDate(statisticByDate.getDateCheckin(), statisticByDate.getDateCheckout());
        return orderMeetingRepository.statisticByDate(
                statisticByDate.getDateCheckin(),
                statisticByDate.getDateCheckout());
    }

    @Override
    public List<OrderMeeting> statisticByRoom(StatisticByRoom statisticByRoom) {
        if (statisticByRoom.getMonth() != null) {
            switch (statisticByRoom.getMonth()) {
                case "1":
                case "3":
                case "5":
                case "7":
                case "8":
                case "10":
                case "12":
                    daysBetweenBySearch = 31;
                    break;
                case "2":
                case "4":
                case "6":
                case "9":
                case "11":
                    daysBetweenBySearch = 30;
                    break;
            }
        } else {
            daysBetweenBySearch = 0;
        }

        if (statisticByRoom.getIdMeetingRoom() == null) {
            statisticByRoom.setIdMeetingRoom("");
        }
        if (statisticByRoom.getIdTypeMeetingRoom() == null) {
            statisticByRoom.setIdTypeMeetingRoom("");
        }
        if (statisticByRoom.getMonth() == null) {
            statisticByRoom.setMonth("");
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


    // xu li lay gio
    public long getTimeDiff(LocalDate dateCheckin, LocalTime timeStart, LocalTime timeEnd) {
        long getTimeDiff = 0;
        try {
            Date timeStartFunc = myTimeFormat.parse(dateCheckin + " " + timeStart);
            Date timeEndFunc = myTimeFormat.parse(dateCheckin + " " + timeEnd);
            getTimeDiff = (((timeEndFunc.getTime() - timeStartFunc.getTime()) / (1000 * 60 * 60)) % 24);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return getTimeDiff;
    }

    public List<ChartStatistical> getChartStatisticalList(List<MeetingRoom> meetingRooms) {
        List<ChartStatistical> chartList = new ArrayList<>();
        for (int i = 0; i < meetingRooms.size(); i++) {
            chartList.add(new ChartStatistical(meetingRooms.get(i).getName(), 0));
        }
        return chartList;
    }

    // xu li tinh hieu suat
    public float calculatorPerformance(float getTimeDiff,
                                       float daysBetweenBySearch,
                                       float daysBetweenForCalculator) {
        float numberHoursUses = getTimeDiff * daysBetweenForCalculator;
        float numberHoursUsesForSearch = 24 * daysBetweenBySearch;
        return ((numberHoursUses / numberHoursUsesForSearch) % 100);
    }


    @Override
    public List<ChartStatistical> calculatorPerformanceByDate() {
        List<MeetingRoom> meetingRoom = meetingRoomRepository.findAll();
        List<ChartStatistical> chartStatisticalList = getChartStatisticalList(meetingRoom);
        long[] holdTotalHours = new long[chartStatisticalList.size()];
        float[] holDays = new float[chartStatisticalList.size()];
//        // xu li time tinh performance
        if (statisticList != null) {
            for (int i = 0; i < statisticList.size(); i++) {
                for (int j = 0; j < chartStatisticalList.size(); j++) {
                    if (statisticList.get(i).getMeetingRoom().getName().equals(chartStatisticalList.get(j).getNameMeetingRoom())) {
                        try {
                            //thoi gian su dung (theo don vi giờ)
                            long getTimeDiff = getTimeDiff(
                                    statisticList.get(i).getDateCheckin(),
                                    statisticList.get(i).getTimeStart(),
                                    statisticList.get(i).getTimeEnd());
                            holdTotalHours[j] += getTimeDiff;

                            //tinh toan days register
                            float daysBetweenForCalculator = getDaysBetween(
                                    String.valueOf(statisticList.get(i).getDateCheckin()),
                                    String.valueOf(statisticList.get(i).getDateCheckout()));
                            holDays[j] += daysBetweenForCalculator;
                            break;

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

        for (int i = 0; i < chartStatisticalList.size(); i++) {
            float performance = calculatorPerformance(holdTotalHours[i], daysBetweenBySearch, holDays[i]);
            chartStatisticalList.get(i).setPerformance(performance);
        }
        return chartStatisticalList;
    }

    @Override
    public List<ChartStatistical> totalsOfUses() {
        List<ChartStatistical> chartStatisticalList = new ArrayList<>();
        List<MeetingRoom> meetingRoom = meetingRoomRepository.findAll();

        // get name of meeting room push list statistic for display chart
        for (int i = 0; i < meetingRoom.size(); i++) {
            chartStatisticalList.add(new ChartStatistical(meetingRoom.get(i).getName(), 0));
        }

        //calculator totals of uses, each meeting room
        if (statisticList != null) {
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
        if (registerHistory.getIdMeetingRoom() == null) {
            registerHistory.setIdMeetingRoom("");
        }
        if (registerHistory.getIdStatusRoom() == null) {
            registerHistory.setIdStatusRoom("");
        }
        if (registerHistory.getIdTypeRoom() == null) {
            registerHistory.setIdTypeRoom("");
        }
        if (registerHistory.getCreateDate() == null) {
            registerHistory.setCreateDate("");
        }
        if ((registerHistory.getDateCheckin() == null) && (registerHistory.getDateCheckout() == null)) {
            return orderMeetingRepository.findRegisterHistoryDateCheckinAndCheckoutNull(
                    registerHistory.getIdMeetingRoom(),
                    registerHistory.getIdStatusRoom(),
                    registerHistory.getIdTypeRoom(),
                    registerHistory.getCreateDate(),
                    accountId
            );
        }
        if (registerHistory.getDateCheckin() == null) {
            return orderMeetingRepository.findRegisterHistoryDateCheckinNull(
                    registerHistory.getIdMeetingRoom(),
                    registerHistory.getDateCheckout(),
                    registerHistory.getIdStatusRoom(),
                    registerHistory.getIdTypeRoom(),
                    registerHistory.getCreateDate(),
                    accountId
            );
        }
        if (registerHistory.getDateCheckout() == null) {
            return orderMeetingRepository.findRegisterHistoryDateCheckoutNull(
                    registerHistory.getIdMeetingRoom(),
                    registerHistory.getDateCheckin(),
                    registerHistory.getIdStatusRoom(),
                    registerHistory.getIdTypeRoom(),
                    registerHistory.getCreateDate(),
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
    public void deleteOrderMeeting(String idOrder, String reasonDelete) {
        Date deleteTime = Calendar.getInstance().getTime();
        orderMeetingRepository.deleteRegister(idOrder, reasonDelete, deleteTime);
    }

    @Override
    public boolean checkIsDelete(String idOrder) {
        OrderMeeting orderMeeting = orderMeetingRepository.checkIsDelete(idOrder).get(0);
        LocalDate dateNow = LocalDate.now();
        float checkDay = getDaysBetween(String.valueOf(orderMeeting.getDateCheckout()), String.valueOf(dateNow));
        if (orderMeeting.getDeleteTime() == null && checkDay < 0) {
            return false;
        }
        return true;
    }

    @Override
    public List<OrderMeeting> getRegisterHistoryByIdMeetingRoom(String idMeetingRoom) {
        return orderMeetingRepository.getRegisterHistoryByIdMeetingRoom(idMeetingRoom);
    }
}

