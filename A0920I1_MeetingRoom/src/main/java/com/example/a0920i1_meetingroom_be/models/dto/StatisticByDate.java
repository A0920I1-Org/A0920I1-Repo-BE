package com.example.a0920i1_meetingroom_be.models.dto;
//AnhLT
public class StatisticByDate {
    private String dateCheckin;
    private String dateCheckout;

    public StatisticByDate(String dateCheckin, String dateCheckout) {
        this.dateCheckin = dateCheckin;
        this.dateCheckout = dateCheckout;
    }

    public String getDateCheckin() {
        return dateCheckin;
    }

    public void setDateCheckin(String dateCheckin) {
        this.dateCheckin = dateCheckin;
    }

    public String getDateCheckout() {
        return dateCheckout;
    }

    public void setDateCheckout(String dateCheckout) {
        this.dateCheckout = dateCheckout;
    }
}
