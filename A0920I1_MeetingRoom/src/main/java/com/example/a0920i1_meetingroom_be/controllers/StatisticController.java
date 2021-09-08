package com.example.a0920i1_meetingroom_be.controllers;

import com.example.a0920i1_meetingroom_be.models.dto.StatisticByDate;
import com.example.a0920i1_meetingroom_be.models.dto.StatisticByRoom;
import com.example.a0920i1_meetingroom_be.models.dto.ChartStatistical;
import com.example.a0920i1_meetingroom_be.models.entity.OrderMeeting;
import com.example.a0920i1_meetingroom_be.services.OrderMeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/statistical")
public class StatisticController {
    @Autowired
    OrderMeetingService orderMeetingService;

    //thong ke theo ngay
    @PutMapping("/statistic-by-date")
    public List<OrderMeeting> statisticByDate(@RequestBody StatisticByDate statisticByDate){
        System.out.println("controller statistic by date");
        return orderMeetingService.statisticByDate(statisticByDate);
    }

    // thong ke theo phong
    @PutMapping("/statistic-by-room")
    public List<OrderMeeting> statisticByDate(@RequestBody StatisticByRoom statisticByRoom){
        return orderMeetingService.statisticByRoom(statisticByRoom);
    }

    // tinh toan hieu suat va so lan su dung cua moi phong
    @GetMapping("/cal-performance-totals-of-uses")
    public List<ChartStatistical> calPerformanceAndUses(){
        List<ChartStatistical> list = orderMeetingService.calculatorPerformanceByDate();
        List<ChartStatistical> list1 = orderMeetingService.totalsOfUses();
        for (int i=0; i< list.size();i++){
            list.get(i).setUses(list1.get(i).getUses());
            System.out.println(list.get(i).getUses());
        }
        return list;
    }


}
