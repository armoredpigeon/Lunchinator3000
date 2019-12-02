package com.lunchinator.demo.dao;

import com.lunchinator.demo.model.LunchBallot;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("fakeBallotDao")
public class FakeLunchBallotDataAccessService implements LunchBallotDao {
    private static Map<UUID, LunchBallot> lunchBallotTable = new HashMap<>();

    @Override
    public int insertLunchBallot(LunchBallot lunchBallot) {
        lunchBallotTable.put(lunchBallot.getBallotId(), lunchBallot);
        return 1;
    }

    @Override
    public LunchBallot getBallotByUUID(UUID ballotId) {
        return lunchBallotTable.get(ballotId);
    }

    @Override
    public List<LunchBallot> getAllBallots(){
        return (List<LunchBallot>) lunchBallotTable.values();
    }
}
