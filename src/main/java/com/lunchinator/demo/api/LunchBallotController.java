package com.lunchinator.demo.api;

import com.lunchinator.demo.model.Ballot;
import com.lunchinator.demo.model.BallotOption;
import com.lunchinator.demo.model.LunchBallot;
import com.lunchinator.demo.service.LunchBallotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/")
@RestController
public class LunchBallotController {
    private final LunchBallotService lunchBallotService;

    @Autowired
    public LunchBallotController(LunchBallotService lunchBallotService){
        this.lunchBallotService = lunchBallotService;
    }

    @PostMapping(path="create-ballot")
    public ResponseEntity<Ballot> createLunchPollService(@RequestBody LunchBallot lunchBallot){
        lunchBallotService.addLunchBallot(lunchBallot);
        return new ResponseEntity<>(lunchBallot.toBallot(), HttpStatus.OK);
    }

    @GetMapping(path="ballot/{ballotId}")
    public ResponseEntity<LunchBallot> getBallotById(@RequestParam UUID ballotId){
        LunchBallot result = lunchBallotService.getBallotById(ballotId);

        //todo: get choices

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
