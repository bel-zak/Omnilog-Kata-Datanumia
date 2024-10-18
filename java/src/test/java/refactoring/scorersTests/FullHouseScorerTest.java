package refactoring.scorersTests;

import java.util.List;


import org.junit.jupiter.api.Test;
import yatzy.refactoring.scorers.FullHouseScorer;

import java.util.Arrays;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class FullHouseScorerTest {

    @Test
    public void testFullHouseScore() {
        FullHouseScorer scorer = new FullHouseScorer();
        List<Integer> dice = Arrays.asList(2, 2, 3, 3, 3);
        assertEquals(13, scorer.calculateScore(dice));
    }

    @Test
    public void testInvalidFullHouse() {
        FullHouseScorer scorer = new FullHouseScorer();
        List<Integer> dice = Arrays.asList(2, 2, 4, 4, 6);
        assertEquals(0, scorer.calculateScore(dice));
    }
}
