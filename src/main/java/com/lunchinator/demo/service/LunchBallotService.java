package com.lunchinator.demo.service;

import com.lunchinator.demo.dao.BallotOptionDao;
import com.lunchinator.demo.dao.LunchBallotDao;
import com.lunchinator.demo.model.Ballot;
import com.lunchinator.demo.model.BallotOption;
import com.lunchinator.demo.model.BallotOptionsList;
import com.lunchinator.demo.model.LunchBallot;
import com.lunchinator.demo.repo.RestaurantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class LunchBallotService {

    private final LunchBallotDao lunchBallotDao;
    private final BallotOptionDao ballotOptionDao;

    @Autowired
    public LunchBallotService(@Qualifier("fakeBallotDao") LunchBallotDao lunchBallotDao,
                              @Qualifier("fakeOptionDao") BallotOptionDao ballotOptionDao){
        this.lunchBallotDao = lunchBallotDao;
        this.ballotOptionDao = ballotOptionDao;
    }

    public int addLunchBallot(LunchBallot lunchBallot){
        lunchBallot.setChoices(this.getLunchBallotOptions());
        lunchBallot.setSuggestion(this.getSuggestedOption(lunchBallot.getChoices()));
        return lunchBallotDao.insertLunchBallot(lunchBallot);
    }

    public LunchBallot getBallotById(UUID ballotId){
        return lunchBallotDao.getBallotByUUID(ballotId);
    }

    private List<BallotOption> getLunchBallotOptions(){
        List<BallotOption> wholeOptionList = ballotOptionDao.getAllBallotOptions();
        BallotOption[] wholeOptionArray = (BallotOption[])wholeOptionList.toArray();
        List<BallotOption> optionsForBallot = new ArrayList<>();

        if(wholeOptionList.size() > 5) {
            Random rand = new Random();
            while (optionsForBallot.size() != 5) {
                int randomIndex = rand.nextInt(wholeOptionArray.length);
                if (!optionsForBallot.contains(wholeOptionArray[randomIndex])) {
                    optionsForBallot.add(wholeOptionArray[randomIndex]);
                }
            }
        }
        else {
            optionsForBallot = wholeOptionList;
            Collections.shuffle(optionsForBallot);
        }

        return optionsForBallot;
    }

    private BallotOption getSuggestedOption(List<BallotOption> options){
        BallotOption resultOption = null;
        for(BallotOption option : options){
            if(resultOption == null || resultOption.getAverageReview() < option.getAverageReview()){
                resultOption = option;
            }
        }
        return resultOption;
    }
}
