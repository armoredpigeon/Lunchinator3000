package com.lunchinator.demo.dao;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.lunchinator.demo.model.Ballot;
import com.lunchinator.demo.model.BallotOption;
import com.lunchinator.demo.model.BallotOptionsList;
import jdk.nashorn.internal.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Array;
import java.util.*;

@Repository("fakeOptionDao")
public class FakeBallotOptionDataAccessService implements BallotOptionDao {
    private static Map<Integer, BallotOption> ballotOptionsTable = new HashMap<>();

    private final RestTemplate restTemplate;

    @Autowired
    public FakeBallotOptionDataAccessService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public int insertBallotOption(BallotOption ballotOption) {
        ballotOptionsTable.put(ballotOption.getId(), ballotOption);
        return 1;
    }

    @Override
    public int saveBallotOptions(List<BallotOption> ballotOptions) {
        ballotOptionsTable = new HashMap<>();
        for(BallotOption option : ballotOptions){
            ballotOptionsTable.put(option.getId(), option);
        }
        return 1;
    }

    @Override
    public List<BallotOption> getAllBallotOptions() {
        if(ballotOptionsTable.isEmpty()){
            String ballotOptionsString = restTemplate.getForObject("https://interview-project-17987.herokuapp.com/api/reviews", String.class);
//            List<BallotOption> ballotOptionsList;
//            ballotOptionsList = JSON(ballotOptionsString);
//            List<BallotOption> options = new ArrayList<>();
////            for(BallotOption item : ballotOptionsList.getBallotOptions()){
////                options.add(item);
////            }

//            saveBallotOptions(options);
        }
        return (List<BallotOption>) ballotOptionsTable.values();
    }

    @Override
    public BallotOption getBallotOptionById(int ballotId) {
        return ballotOptionsTable.get(ballotId);
    }
}
