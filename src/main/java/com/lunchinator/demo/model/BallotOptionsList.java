package com.lunchinator.demo.model;

import java.util.ArrayList;
import java.util.List;

public class BallotOptionsList {
    private BallotOption[] ballots;

    public BallotOptionsList() {
        ballots = new BallotOption[19];
    }

    public List<BallotOption> getBallotOptions() {
        List<BallotOption> result = new ArrayList<>();
        for(int i = 0; i<ballots.length; i++)
        {
            result.add(ballots[i]);
        }
        return result;
    }
}
