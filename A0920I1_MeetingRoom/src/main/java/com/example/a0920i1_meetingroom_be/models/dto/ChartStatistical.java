package com.example.a0920i1_meetingroom_be.models.dto;

public class ChartStatistical {
    private String nameMeetingRoom;
    private int uses;
    private double performance;

    public ChartStatistical(String nameMeetingRoom, double performance) {
        this.nameMeetingRoom = nameMeetingRoom;
        this.performance = performance;
    }

    public double getPerformance() {
        return performance;
    }

    public void setPerformance(double performance) {
        this.performance = performance;
    }

    public ChartStatistical(String nameMeetingRoom, int uses) {
        this.nameMeetingRoom = nameMeetingRoom;
        this.uses = uses;
    }

    public ChartStatistical(String nameMeetingRoom) {
        this.nameMeetingRoom = nameMeetingRoom;
    }

    public String getNameMeetingRoom() {
        return nameMeetingRoom;
    }

    public void setNameMeetingRoom(String nameMeetingRoom) {
        this.nameMeetingRoom = nameMeetingRoom;
    }

    public int getUses() {
        return uses;
    }

    public void setUses(int uses) {
        this.uses = uses;
    }
}
