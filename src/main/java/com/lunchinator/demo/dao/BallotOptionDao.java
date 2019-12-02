package com.lunchinator.demo.dao;

import com.lunchinator.demo.model.BallotOption;

import java.util.List;

public interface BallotOptionDao {
    int insertBallotOption(BallotOption ballotOption);
    int saveBallotOptions(List<BallotOption> ballotOptions);
    List<BallotOption> getAllBallotOptions();
    BallotOption getBallotOptionById(int ballotId);
}
