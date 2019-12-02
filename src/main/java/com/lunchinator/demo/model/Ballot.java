package com.lunchinator.demo.model;

import java.util.UUID;

public class Ballot {
    private final UUID ballotId;

    public Ballot(){
        this.ballotId = UUID.randomUUID();
    }

    public Ballot(UUID ballotId){
        this.ballotId = ballotId;
    }

    public UUID getBallotId(){
        return this.ballotId;
    }
}
