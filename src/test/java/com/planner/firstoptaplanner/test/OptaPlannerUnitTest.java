package com.planner.firstoptaplanner.test;

//import com.planner.firstoptaplanner.AudienciaSchedule;
//import com.planner.firstoptaplanner.AudienciaAssignment;
//import com.planner.firstoptaplanner.Timeslot;
import com.planner.firstoptaplanner.*;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.optaplanner.core.api.solver.Solver;
import org.optaplanner.core.api.solver.SolverFactory;

public class OptaPlannerUnitTest {

    static AudienciaSchedule unsolvedAudienciaSchedule;

    @BeforeAll
    public static void setUp() {

        unsolvedAudienciaSchedule = new AudienciaSchedule();

        for(int i = 0; i < 10; i++){
            unsolvedAudienciaSchedule.get().add(new AudienciaAssignment());
        }
        List<Room> roomList = new List()<>;
        for (int i = 0; i < 4; i++) {
            roomList.add(new Room(new Integer(i)));
        }
        List<Timeslot> timeslotList = new List()<>;

        for (int i = 0; i < 4; i++) {
            timeslotList.add(new Timeslot(i));
        }
        unsolvedAudienciaSchedule.getPeriodList().addAll(timeslotList);
        unsolvedAudienciaSchedule.getRoomList().addAll(roomList);
    }

    @Test
    public void test_whenCustomJavaSolver() {

        SolverFactory<AudienciaSchedule> solverFactory = SolverFactory.createFromXmlResource("audienciaScheduleSolverConfiguration.xml");
        Solver<AudienciaSchedule> solver = solverFactory.buildSolver();
        AudienciaSchedule solvedAudienciaSchedule = solver.solve(unsolvedAudienciaSchedule);

        Assert.assertNotNull(solvedAudienciaSchedule.getScore());
        Assert.assertEquals(-4, solvedAudienciaSchedule.getScore().getHardScore());
    }

    @Test
    public void test_whenDroolsSolver() {

        SolverFactory<AudienciaSchedule> solverFactory = SolverFactory.createFromXmlResource("audienciaScheduleSolverConfigDrools.xml");
        Solver<AudienciaSchedule> solver = solverFactory.buildSolver();
        AudienciaSchedule solvedAudienciaSchedule = solver.solve(unsolvedAudienciaSchedule);

        Assert.assertNotNull(solvedAudienciaSchedule.getScore());
        Assert.assertEquals(0, solvedAudienciaSchedule.getScore().getHardScore());
    }
}