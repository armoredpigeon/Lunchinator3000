package com.lunchinator.demo.dao;

import com.lunchinator.demo.model.LunchBallot;

import java.util.List;
import java.util.UUID;


public interface LunchBallotDao {
    int insertLunchBallot(LunchBallot lunchBallot);
    LunchBallot getBallotByUUID(UUID ballotId);
    List<LunchBallot> getAllBallots();
    //todo: Want to re-think the structure around how I'd do it in a database, so that it's... less dumb
    //todo: So lunchBallot doesn't need a suggestion or winner (those can be calculated when needed)
    //todo: suggestion can come from best rating among choices
    //todo: winner can come from one with most votes when endTime has passed
    //todo: voting would have it check whether endTime has passed and assemble a response appropriately
    //todo: LunchBallot needs a UUID, choices, voters, votes, endTime
    //todo: I'd split those up and have a table of restaurants, etc.
    //todo: need to write the voting part
}