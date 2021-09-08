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
            daysBetween = (getDayDiffBySearch / (1000 * 60 * 60 * 24));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return daysBetween;
    }

    @Override
    public List<OrderMeeting> statisticByDate(StatisticByDate statisticByDate) {
        System.out.println("impl statistic by date");
        //tinh diff : end - start
        daysBetweenBySearch = getDaysBetween(statisticByDate.getDateCheckin(), statisticByDate.getDateCheckout());
        System.out.println("tong so ngay cua search : " + daysBetweenBySearch);

        // statistical by date
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
        statisticList = orderMeetingRepository.statisticByDate(statisticByDate.getDateCheckin(), statisticByDate.getDateCheckout());
        return orderMeetingRepository.statisticByDate(
                statisticByDate.getDateCheckin(),
                statisticByDate.getDateCheckout());
    }

    @Override
    public List<OrderMeeting> statisticByRoom(StatisticByRoom statisticByRoom) {
        System.out.println("statisticByRoom");
        if (statisticByRoom.getMonth()!=null) {
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
        }else {
            daysBetweenBySearch = 0;
        }

        if (statisticByRoom.getIdMeetingRoom() == null) {
            statisticByRoom.setIdMeetingRoom("");
            System.out.println(statisticByRoom.getIdMeetingRoom());
        }
        if (statisticByRoom.getIdTypeMeetingRoom() == null) {
            statisticByRoom.setIdTypeMeetingRoom("");
            System.out.println(statisticByRoom.getIdTypeMeetingRoom());
        }
        if (statisticByRoom.getMonth() == null) {
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


    // xu li lay gio
    public long getTimeDiff(LocalDate dateCheckin, LocalTime timeStart, LocalTime timeEnd){
        long getTimeDiff = 0;
        try{
            Date timeStartFunc = myTimeFormat.parse(dateCheckin + " " +timeStart );
            Date timeEndFunc = myTimeFormat.parse(dateCheckin+" "+timeEnd);
            getTimeDiff = (((timeEndFunc.getTime() - timeStartFunc.getTime()) / (1000 * 60 * 60)) % 24);
        }catch (Exception e){
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
                                       float daysBetweenForCalculator){
        float numberHoursUses = getTimeDiff * daysBetweenForCalculator;
        System.out.println("So gio su dung : "+numberHoursUses);
        System.out.println("So ngay theo search : " + daysBetweenBySearch);
        float numberHoursUsesForSearch = 24 * daysBetweenBySearch;
        System.out.println("So gio tong :" + numberHoursUsesForSearch);
        System.out.println("Performance :" +((numberHoursUses / numberHoursUsesForSearch) % 100));
        return ((numberHoursUses / numberHoursUsesForSearch) % 100);
    }


    @Override
    public List<ChartStatistical> calculatorPerformanceByDate() {
        System.out.println("Calculator performance by date");
        List<MeetingRoom> meetingRoom = meetingRoomRepository.findAll();
        List<ChartStatistical> chartStatisticalList = getChartStatisticalList(meetingRoom);
        long[] holdTotalHours = new long[chartStatisticalList.size()];
        float[] holDays =new float[chartStatisticalList.size()];
//        // xu li time tinh performance
        if (statisticList != null) {
            System.out.println("vao day k?");
            for (int i = 0; i < statisticList.size(); i++) {
                for (int j = 0; j < chartStatisticalList.size(); j++) {
                    if (statisticList.get(i).getMeetingRoom().getName().equals(chartStatisticalList.get(j).getNameMeetingRoom())) {
                        try {
                            //thoi gian su dung (theo don vi giờ)
                            long getTimeDiff = getTimeDiff(
                                    statisticList.get(i).getDateCheckin(),
                                    statisticList.get(i).getTimeStart(),
                                    statisticList.get(i).getTimeEnd());
                            System.out.println("number of hours : " + getTimeDiff);
                            holdTotalHours[j] += getTimeDiff;
                            System.out.println(holdTotalHours[j]);
                            //tinh toan days register
                            float daysBetweenForCalculator = getDaysBetween(
                                    String.valueOf(statisticList.get(i).getDateCheckin()),
                                    String.valueOf(statisticList.get(i).getDateCheckout()));
                            System.out.println("Ngay trong DB : " + daysBetweenForCalculator);
                            holDays[j] += daysBetweenForCalculator;
                            System.out.println(holDays[j]);
                            break;

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

        for (int i = 0; i < chartStatisticalList.size(); i++) {
            System.out.println("so gio :" +holdTotalHours[i]);
            System.out.println("so ngay : " + holDays[i]);
            float performance = calculatorPerformance(holdTotalHours[i],daysBetweenBySearch,holDays[i]);
            chartStatisticalList.get(i).setPerformance(performance);
            System.out.println(chartStatisticalList.get(i).getPerformance());
        }


        for (int i = 0; i < chartStatisticalList.size(); i++) {
            System.out.println(chartStatisticalList.get(i).getNameMeetingRoom());
            System.out.println(chartStatisticalList.get(i).getPerformance());
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
    public void deleteRegister(String idOrder, String reasonDelete) {
        System.out.println("ID Order : " + idOrder);
        System.out.println("reason delete: " + reasonDelete);
        Date deleteTime = Calendar.getInstance().getTime();
        orderMeetingRepository.deleteRegister(idOrder, reasonDelete, deleteTime);
    }

    @Override
    public boolean checkIsDelete(String idOrder) {
        OrderMeeting orderMeeting = orderMeetingRepository.checkIsDelete(idOrder).get(0);
        LocalDate dateNow = LocalDate.now();
        System.out.println("Ngay hien tai " + dateNow);
        float checkDay = getDaysBetween(String.valueOf(orderMeeting.getDateCheckout()), String.valueOf(dateNow));
        System.out.println("so sanh ngay hien tai va ngay checkout da het han chua?: " + checkDay);
        if(orderMeeting.getDeleteTime()==null && checkDay < 0){
            return false;
        }
        return true;
    }


}
