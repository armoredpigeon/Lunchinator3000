package com.lunchinator.demo.model;

import java.util.ArrayList;
import java.util.List;

public class BallotOptionsList {
    private List<BallotOption> ballots;

    public BallotOptionsList() {
        ballots = new ArrayList<>();
    }

    public List<BallotOption> getBallotOptions() {
        return ballots;
    }
}
