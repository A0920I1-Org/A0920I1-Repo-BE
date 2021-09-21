package com.example.a0920i1_meetingroom_be.services.Impl;

import com.example.a0920i1_meetingroom_be.models.dto.ChartStatistical;
import com.example.a0920i1_meetingroom_be.models.dto.RegisterHistory;
import com.example.a0920i1_meetingroom_be.models.dto.StatisticByDate;
import com.example.a0920i1_meetingroom_be.models.dto.StatisticByRoom;
import com.example.a0920i1_meetingroom_be.models.entity.MeetingRoom;
import com.example.a0920i1_meetingroom_be.models.entity.OrderMeeting;
import com.example.a0920i1_meetingroom_be.repositories.MeetingRoomRepository;
import com.example.a0920i1_meetingroom_be.repositories.OrderMeetingRepository;
import com.example.a0920i1_meetingroom_be.services.OrderMeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    //AnhLT
    private List<OrderMeeting> statisticList;
    float daysBetweenBySearch = 0; //bien dem ngay sau khi search theo date or room
    //AnhLT
    SimpleDateFormat myDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    // HH:mm:ss.SSSXXX
    SimpleDateFormat myTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    //AnhLT
    // get diff between two days
    public float getDaysBetween(String dateCheckin, String dateCheckout) {
        float daysBetween = 0;
        try {
            if(dateCheckin==null||dateCheckout==null|| dateCheckin.equals("") | dateCheckout.equals("")){
                return daysBetween;
            }
            Date dateStart = myDateFormat.parse(dateCheckin);
            Date dateEnd = myDateFormat.parse(dateCheckout);
            long getDayDiffBySearch = (dateEnd.getTime() - dateStart.getTime());
            daysBetween = (float) (getDayDiffBySearch / (1000.0 * 60.0 * 60.0 * 24.0));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return daysBetween;
    }
    //AnhLT
    // display list statictical by date
    @Override
    public List<OrderMeeting> statisticByDate(StatisticByDate statisticByDate) {
        //tinh diff : end - start
        daysBetweenBySearch = getDaysBetween(statisticByDate.getDateCheckin(), statisticByDate.getDateCheckout());

        // statistical by date
        // user do not enter input data dateCheckin
        if (statisticByDate.getDateCheckin() == null|| statisticByDate.getDateCheckin().equals("")) {
            statisticList = orderMeetingRepository.statisticByDateCheckinNull(statisticByDate.getDateCheckout());
            return statisticList;
        }
        // user do not enter input data dateCheckout
        if (statisticByDate.getDateCheckout() == null || statisticByDate.getDateCheckout().equals("")) {
            statisticList = orderMeetingRepository.statisticByDateCheckoutNull(statisticByDate.getDateCheckin());
            return statisticList;
        }
        // two input dateCheckout dateCheckin valid
        statisticList = orderMeetingRepository.statisticByDate(statisticByDate.getDateCheckin(), statisticByDate.getDateCheckout());
        return statisticList;
    }
    //AnhLT
    @Override
    public List<OrderMeeting> statisticByRoom(StatisticByRoom statisticByRoom) {
        // test user have did enter date in box Month
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
                default:break;
            }
        } else {
            daysBetweenBySearch = 0;
        }

        // test , have user did enter date NS field
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
        return statisticList;
    }
    //AnhLT
    // xu li lay gio
    // diff time between two at time
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
    //AnhLT
    // create data for display chart statistic with field name room, performance, totals of uses
    public List<ChartStatistical> getChartStatisticalList(List<MeetingRoom> meetingRooms) {
        List<ChartStatistical> chartList = new ArrayList<>();
        for (int i = 0; i < meetingRooms.size(); i++) {
            chartList.add(new ChartStatistical(meetingRooms.get(i).getName(), 0));
        }
        return chartList;
    }
    //AnhLT
    // xu li tinh hieu suat
    // recipe = number hours customer used div total number hours (user enters data with start date and end date) x 100
    public float calculatorPerformance(float numberHoursUses,
                                       float daysBetweenBySearch) {
        float numberHoursUsesForSearch = 24 * daysBetweenBySearch;
        return ((numberHoursUses / numberHoursUsesForSearch) * 100);
    }
    //AnhLT
    // set performance calculated into the chart list
    @Override
    public List<ChartStatistical> setPerformanceWithChartList() {
        List<MeetingRoom> meetingRoom = meetingRoomRepository.findAll();
        List<ChartStatistical> chartStatisticalList = getChartStatisticalList(meetingRoom);

        //extra array
        long[] holdTotalHours = new long[chartStatisticalList.size()];
        float[] holDays = new float[chartStatisticalList.size()];
        float[] numberHoursUses = new float[chartStatisticalList.size()];
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
                            holDays[j] += daysBetweenForCalculator + 1;

                            numberHoursUses[j] += getTimeDiff * daysBetweenForCalculator;

                            break;

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

        //set into the chart list
        for (int i = 0; i < chartStatisticalList.size(); i++) {
            float performance = calculatorPerformance(numberHoursUses[i], daysBetweenBySearch);
            chartStatisticalList.get(i).setPerformance(performance);
        }
        return chartStatisticalList;
    }

    //AnhLT
    // calculator totals of user each meeting room
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

    //register history

    // two variable with url, admin access screen register history with idMeetingRoom
    // user access screen register history with idAccount
    private String idAccount;
    private String idMeetingRoom;
    //AnhLT
    // user access
    @Override
    public List<OrderMeeting> getOrderMeetingByAccountId(String accountId) {
        idAccount=accountId;
        return orderMeetingRepository.getOrderMeetingByAccountId(accountId);
    }
    //AnhLT
    // find order in DB => trans data for screen delete, display information
    @Override
    public OrderMeeting findOrderById(String idOrder) {
        return orderMeetingRepository.findOrderMeetingByIdOrder(idOrder);
    }
    //AnhLT
    // func search register
    @Override
    public List<OrderMeeting> searchRegisterHistoryBy(RegisterHistory registerHistory) {
        if (registerHistory.getNameRoom() == null) {
            registerHistory.setNameRoom("");
        }
        if (registerHistory.getStatusRoom() == null) {
            registerHistory.setStatusRoom("");
        }
        if (registerHistory.getIdTypeMeetingRoom() == null) {
            registerHistory.setIdTypeMeetingRoom("");
        }
        if (registerHistory.getCreateDate() == null) {
            registerHistory.setCreateDate("");
        }
        if ((registerHistory.getDateCheckin() == null) && (registerHistory.getDateCheckout() == null)) {
            if (idAccount==null){
                return orderMeetingRepository.findRegisterHistoryDateCheckinAndCheckoutNullIdMeetingRoom(
                        registerHistory.getNameRoom(),
                        registerHistory.getStatusRoom(),
                        registerHistory.getIdTypeMeetingRoom(),
                        registerHistory.getCreateDate(),
                        idMeetingRoom
                );
            }else {
                return orderMeetingRepository.findRegisterHistoryDateCheckinAndCheckoutNullIdAccount(
                        registerHistory.getNameRoom(),
                        registerHistory.getStatusRoom(),
                        registerHistory.getIdTypeMeetingRoom(),
                        registerHistory.getCreateDate(),
                        idAccount
                );
            }
        }
        if (registerHistory.getDateCheckin() == null) {
            if (idAccount==null){
                return orderMeetingRepository.findRegisterHistoryDateCheckinNullIdMeetingRoom(
                        registerHistory.getNameRoom(),
                        registerHistory.getDateCheckout(),
                        registerHistory.getStatusRoom(),
                        registerHistory.getIdTypeMeetingRoom(),
                        registerHistory.getCreateDate(),
                        idMeetingRoom
                );
            }
            else {
                return orderMeetingRepository.findRegisterHistoryDateCheckinNullIdAccount(
                        registerHistory.getNameRoom(),
                        registerHistory.getDateCheckout(),
                        registerHistory.getStatusRoom(),
                        registerHistory.getIdTypeMeetingRoom(),
                        registerHistory.getCreateDate(),
                        idAccount
                );
            }
        }
        if (registerHistory.getDateCheckout() == null) {
            if (idAccount==null){
                return orderMeetingRepository.findRegisterHistoryDateCheckoutNullIdMeetingRoom(
                        registerHistory.getNameRoom(),
                        registerHistory.getDateCheckin(),
                        registerHistory.getStatusRoom(),
                        registerHistory.getIdTypeMeetingRoom(),
                        registerHistory.getCreateDate(),
                        idMeetingRoom
                );
            }
            return orderMeetingRepository.findRegisterHistoryDateCheckoutNullIdAccount(
                    registerHistory.getNameRoom(),
                    registerHistory.getDateCheckin(),
                    registerHistory.getStatusRoom(),
                    registerHistory.getIdTypeMeetingRoom(),
                    registerHistory.getCreateDate(),
                    idAccount
            );
        }
        if (idAccount==null){
            return orderMeetingRepository.findRegisterHistoryByIdMeetingRoom(
                    registerHistory.getNameRoom(),
                    registerHistory.getDateCheckin(),
                    registerHistory.getDateCheckout(),
                    registerHistory.getStatusRoom(),
                    registerHistory.getIdTypeMeetingRoom(),
                    registerHistory.getCreateDate(),
                    idMeetingRoom
            );
        }
        else {
            return orderMeetingRepository.findRegisterHistoryByIdAccount(
                    registerHistory.getNameRoom(),
                    registerHistory.getDateCheckin(),
                    registerHistory.getDateCheckout(),
                    registerHistory.getStatusRoom(),
                    registerHistory.getIdTypeMeetingRoom(),
                    registerHistory.getCreateDate(),
                    idAccount
            );
        }
    }
    //AnhLT
    // func when user unsubcribe
    @Override
    public void deleteOrderMeeting(String idOrder, String reasonDelete) {
        Date deleteTime = Calendar.getInstance().getTime();
        orderMeetingRepository.deleteRegister(idOrder, reasonDelete, deleteTime);
    }

    //AnhLT
    // check were the order delete?
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
    //AnhLT
    // admin access register history
    @Override
    public List<OrderMeeting> getRegisterHistoryByIdMeetingRoom(String idRoom) {
        idMeetingRoom = idRoom;
        return orderMeetingRepository.getRegisterHistoryByIdMeetingRoom(idMeetingRoom);
    }

}

