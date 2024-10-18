package refactoring.scorersTests;

import java.util.List;



import org.junit.jupiter.api.Test;
import yatzy.refactoring.scorers.TwoPairsScorer;

import java.util.Arrays;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class TwoPairsScorerTest {

    @Test
    public void testTwoPairsScorer() {
        TwoPairsScorer scorer = new TwoPairsScorer();
        List<Integer> dice = Arrays.asList(3, 3, 5, 5, 1);
        assertEquals(16, scorer.calculateScore(dice));
    }

    @Test
    public void testInvalidTwoPairs() {
        TwoPairsScorer scorer = new TwoPairsScorer();
        List<Integer> dice = Arrays.asList(3, 3, 4, 5, 6);
        assertEquals(0, scorer.calculateScore(dice));
    }
}