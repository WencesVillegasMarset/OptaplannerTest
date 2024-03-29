package com.planner.firstoptaplanner;

import org.optaplanner.core.api.score.Score;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.core.impl.score.director.easy.EasyScoreCalculator;

import java.util.HashSet;


public class ScoreCalculator implements EasyScoreCalculator<AudienciaSchedule> {

    @Override
    public Score calculateScore(AudienciaSchedule audienciaSchedule) {
        int hardScore = 0;
        int softScore = 0;

        HashSet<String> occupiedRooms = new HashSet<>();
        for (Audiencia audiencia: audienciaSchedule.getAudienciaList()) {
            if(audiencia.getPeriod() != null && audiencia.getRoom() != null) {
                String roomInUse = audiencia.getPeriod().toString() + ":" + audiencia.getRoom().toString();
                if (occupiedRooms.contains(roomInUse)) {
                    hardScore += -1;
                } else {
                    occupiedRooms.add(roomInUse);
                }
            } else {
                hardScore += -1;
            }
        }

        return HardSoftScore.valueOf(hardScore, softScore);
    }

}
