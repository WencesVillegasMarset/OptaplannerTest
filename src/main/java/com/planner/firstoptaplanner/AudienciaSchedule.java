package com.planner.firstoptaplanner;

import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty;
import org.optaplanner.core.api.domain.solution.PlanningScore;
import org.optaplanner.core.api.domain.solution.PlanningSolution;
import org.optaplanner.core.api.domain.solution.drools.ProblemFactCollectionProperty;
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;


@PlanningSolution
public class AudienciaSchedule {

    private List<Room> roomList;
    private List<Timeslot> timeslotList;
    private List<Audiencia> audienciaList;
    private HardSoftScore score;

    public AudienciaSchedule(){
        roomList = new ArrayList<>();
        timeslotList = new ArrayList<>();
        audienciaList = new ArrayList<>();
    }

    @ValueRangeProvider(id = "availableRooms")
    @ProblemFactCollectionProperty
    public List<Room> getRoomList() {
        return roomList;
    }

    @ValueRangeProvider(id = "availablePeriods")
    @ProblemFactCollectionProperty
    public List<Timeslot> getTimeslotList() {
        return timeslotList;
    }

    @PlanningEntityCollectionProperty
    public List<Audiencia> getAudienciaList() {
        return audienciaList;
    }
    @PlanningScore
    public HardSoftScore getScore() {
        return score;
    }

    public void setScore(HardSoftScore score) {
        this.score = score;
    }

    @Override
    public String toString() {
        String response = new String();
        for (Audiencia audiencia: this.getAudienciaList()) {
            response += "TimeSlot: " + audiencia.getPeriod().getTimeSlotID() +  " and room: " + audiencia.getRoom().getNumber() + '\n';
        }
        return  response;
    }
}
