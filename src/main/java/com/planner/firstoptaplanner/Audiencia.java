package com.planner.firstoptaplanner;

import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.variable.PlanningVariable;

@PlanningEntity
public class Audiencia {
    private Room room;
    private Timeslot period;

    public void setRoom(Room room) {
        this.room = room;
    }

    public void setPeriod(Timeslot period) {
        this.period = period;
    }

    @PlanningVariable(valueRangeProviderRefs = {"availablePeriods"})
    public Timeslot getPeriod() {
        return period;
    }

    @PlanningVariable(valueRangeProviderRefs = {"availableRooms"})
    public Room getRoom() {
        return room;
    }




}
