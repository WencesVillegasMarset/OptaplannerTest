package com.planner.firstoptaplanner;
import com.planner.firstoptaplanner.*;


import org.optaplanner.core.api.solver.Solver;

import java.util.ArrayList;
import java.util.Arrays;
import org.optaplanner.core.api.solver.SolverFactory;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        AudienciaSchedule unsolvedAudienciaSchedule;

        unsolvedAudienciaSchedule = new AudienciaSchedule();

        for(int i = 0; i < 3; i++){
            unsolvedAudienciaSchedule.getAudienciaList().add(new Audiencia());
        }
        ArrayList<Room> roomList = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            roomList.add(new Room(new Integer(i)));
        }
        ArrayList<Timeslot> timeslotList = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            timeslotList.add(new Timeslot(i));
        }
        unsolvedAudienciaSchedule.getTimeslotList().addAll(timeslotList);
        unsolvedAudienciaSchedule.getRoomList().addAll(roomList);
        SolverFactory<AudienciaSchedule> solverFactory = SolverFactory.createFromXmlResource("audienciaScheduleSolverConfiguration.xml");
        Solver<AudienciaSchedule> solver = solverFactory.buildSolver();
        AudienciaSchedule solvedAudienciaSchedule = solver.solve(unsolvedAudienciaSchedule);
        System.out.println(solvedAudienciaSchedule);

    }
}
