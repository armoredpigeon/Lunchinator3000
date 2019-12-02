package com.lunchinator.demo;

import com.lunchinator.demo.model.BallotOption;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class BallotOption_Tests {

    private final int costaVidaId = 1;
    private final String costaVidaName = "Costa Vida";
    private final BallotOption costaVidaOption = new BallotOption(costaVidaId, costaVidaName);

    private final int habitBurgerId = 2;
    private final String habitBurgerName = "Habit Burger";
    private final BallotOption habitBurgerOption = new BallotOption(habitBurgerId, habitBurgerName);

    private final int zupasId = 3;
    private final String zupasName = "Zupas";
    private final BallotOption zupasOption = new BallotOption(zupasId, zupasName);

    @Test
    void ballotOptionShouldEqualAnotherWithSameProps(){
        BallotOption otherOption = new BallotOption(costaVidaId, costaVidaName);
        assertTrue(costaVidaOption.equals(otherOption), "same properties should mean same object");
    }

    @Test
    void ballotOptionShouldNotEqualAnotherWithDifferentProps(){
        BallotOption costaVidaIdZupasName = new BallotOption(costaVidaId, zupasName);
        BallotOption zupasIdCostaVidaName = new BallotOption(zupasId, costaVidaName);
        assertFalse(costaVidaOption.equals(habitBurgerOption), "different properties should mean same object");
        assertFalse(costaVidaOption.equals(costaVidaIdZupasName), "a different name means a different object");
        assertFalse(costaVidaOption.equals(zupasIdCostaVidaName), "a different id means a different object");
    }

}
