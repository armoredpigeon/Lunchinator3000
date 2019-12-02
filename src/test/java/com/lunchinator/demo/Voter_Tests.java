package com.lunchinator.demo;

import com.lunchinator.demo.model.Voter;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class Voter_Tests {

    private final String michaelName = "Michael";
    private final String michaelEmail = "michael@NotARealEmail.com";

    private final String jacobName = "Jacob";
    private final String jacobEmail = "Jacob@NotARealEmail.com";

    private final String samuelName = "Samuel";
    private final String samuelEmail = "Samuel@NotARealEmail.com";

    private final Voter michaelVoter = new Voter(michaelName, michaelEmail);
    private final Voter jacobVoter = new Voter(jacobName, jacobEmail);
    private final Voter samuelVoter = new Voter(samuelName, samuelEmail);

    @Test
    void votersWithEqualValuesShouldBeEqual() {
        Voter comparisonVoter = new Voter(michaelName, michaelEmail);
        assertEquals(michaelVoter.equals(comparisonVoter), true, ".equals() should return true");
        assertEquals(michaelVoter.hashCode(), comparisonVoter.hashCode(), "hash codes should match");
    }

    @Test
    void votersWithUnequalValuesShouldNotBeEqual() {
        assertEquals(michaelVoter.equals(jacobVoter), false, ".equals() should return false");
        assertNotEquals(michaelVoter.hashCode(), jacobVoter.hashCode(), "hash codes should not match");
    }

    @Test
    void michaelShouldSortTheSameAsMichael(){
        Voter comparisonVoter = new Voter(michaelName, michaelEmail);
        assertEquals(michaelVoter.compareTo(comparisonVoter), 0, ".compareTo() should return 0 for same values");
    }

    @Test
    void sameNameDifferentEmailShouldSortDifferently(){
        Voter jacobEmailVoter = new Voter(michaelName, jacobEmail);
        Voter samuelEmailVoter = new Voter(michaelName, samuelEmail);
        assertTrue(michaelVoter.compareTo(jacobEmailVoter) > 0, "michael@... goes after jacob@...");
        assertTrue(michaelVoter.compareTo(samuelEmailVoter) < 0, "samuel@... goes before michael@...");
    }

    @Test
    void sameEmailDifferentNameShouldSortDifferently(){
        Voter jacobVoterMichaelEmail = new Voter(jacobName, michaelEmail);
        Voter samuelVoterMichaelEmail = new Voter(samuelName, michaelEmail);
        assertTrue(michaelVoter.compareTo(jacobVoterMichaelEmail) > 0, "Michael goes after Jacob");
        assertTrue(michaelVoter.compareTo(samuelVoterMichaelEmail) < 0, "Michael goes before Samuel");
    }

    @Test
    void differentVotersShouldSortDifferently(){
        assertTrue(michaelVoter.compareTo(jacobVoter) > 0, "Michael goes after Jacob");
        assertTrue(michaelVoter.compareTo(samuelVoter) < 0, "Michael goes before Samuel");
    }
}
