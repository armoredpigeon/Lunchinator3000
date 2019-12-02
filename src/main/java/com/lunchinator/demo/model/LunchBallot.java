package com.lunchinator.demo.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.List;

public class LunchBallot extends Ballot {
    private final LocalDateTime endTime;
    private final List<Voter> voters;
    private final LocalDateTime defaultEndTime = LocalDateTime.of(LocalDate.now(), LocalTime.of(11, 45));

    public BallotOption winner;
    public List<BallotOption> choices;
    private BallotOption suggestion;

    public LunchBallot(@JsonProperty("voters") List<Voter> voters,
                       @JsonProperty("endTime") LocalDateTime endTime){
        //stretch goal: if the endTime is before now, we could/should reject it.
        super();
        this.voters = voters;
        this.endTime = endTime;
    }

    @JsonCreator
    public LunchBallot(@JsonProperty("voters") List<Voter> voters,
                       @JsonProperty("endTime") String endTime){
        super();
        this.voters = voters;
        LocalDateTime selectedEndTime = this.defaultEndTime;
        try {
            if (endTime.matches("\\d{4}(-\\d{2}){2}T\\d{2}(:\\d{2}){2}")) {
                selectedEndTime = LocalDateTime.parse(endTime);
            } else if (endTime.matches("(\\d{2}/){2}\\d{4} \\d{2}:\\d{2}")) {
                String[] endTimeParts = endTime.split(" ");
                LocalDate parsedEndDate = LocalDate.parse(endTimeParts[0]);
                LocalTime parsedEndTime = LocalTime.parse(endTimeParts[1]);
                selectedEndTime = LocalDateTime.of(parsedEndDate, parsedEndTime);
            }
        }
        catch (DateTimeParseException err){
            //make sure the endTime is a reasonable value
            selectedEndTime = this.defaultEndTime;
        }
        this.endTime = selectedEndTime;
    }

    public LunchBallot(@JsonProperty("voters") List<Voter> voters){
        super();
        this.voters = voters;
        this.endTime = this.defaultEndTime;
    }

    public LocalDateTime getEndTime(){
        return endTime;
    }

    public List<Voter> getVoters() { return voters; }

    public BallotOption getWinner() {
        return winner;
    }

    public void setWinner(BallotOption winner) {
        this.winner = winner;
    }

    public List<BallotOption> getChoices() {
        return choices;
    }

    public void setChoices(List<BallotOption> choices) {
        if(this.choices.isEmpty()) {
            this.choices = choices;
        }
    }

    public BallotOption getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(BallotOption suggestion) {
        this.suggestion = suggestion;
    }

    public Ballot toBallot(){
        Ballot result = new Ballot(getBallotId());
        return result;
    }
}