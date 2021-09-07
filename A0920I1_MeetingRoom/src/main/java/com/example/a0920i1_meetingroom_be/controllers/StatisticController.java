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

    @PutMapping("/statisticByDate")
    public List<OrderMeeting> statisticByDate(@RequestBody StatisticByDate statisticByDate){
        System.out.println("controller statistic by date");
        return orderMeetingService.statisticByDate(statisticByDate);
    }
    @PutMapping("/statisticByRoom")
    public List<OrderMeeting> statisticByDate(@RequestBody StatisticByRoom statisticByRoom){
        return orderMeetingService.statisticByRoom(statisticByRoom);
    }
    @GetMapping("/totalsOfUses")
    public List<ChartStatistical> totalsOfUses(){
        List<ChartStatistical> list = orderMeetingService.calculatorPerformanceByDate();
        List<ChartStatistical> list1 = orderMeetingService.totalsOfUses();
        for (int i=0; i< list.size();i++){
            list.get(i).setUses(list1.get(i).getUses());
            System.out.println(list.get(i).getUses());
        }
        return list;
    }

    //sua lai url for by date
    @GetMapping("/performance")
    public List<ChartStatistical> calculatorPerformanceByDate(){
        return orderMeetingService.calculatorPerformanceByDate();
    }

}
