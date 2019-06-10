package com.planner.firstoptaplanner;

import java.time.LocalDateTime;

public class Timeslot {

    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private int timeSlotID;

    public Timeslot(int timeSlotID) {
        this.timeSlotID = timeSlotID;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }

    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(LocalDateTime endDateTime) {
        this.endDateTime = endDateTime;
    }

    public int getTimeSlotID() {
        return timeSlotID;
    }

    public void setTimeSlotID(int timeSlotID) {
        this.timeSlotID = timeSlotID;
    }
}
