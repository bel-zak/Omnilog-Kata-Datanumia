package refactoring.scorersTests;

import java.util.List;

import org.junit.jupiter.api.Test;
import yatzy.refactoring.scorers.StraightScorer;

import java.util.Arrays;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class StraightScorerTest {

    @Test
    public void testSmallStraightScorer() {
        StraightScorer scorer = new StraightScorer(1);
        List<Integer> dice = Arrays.asList(1, 2, 3, 4, 5);
        assertEquals(15, scorer.calculateScore(dice));
    }

    @Test
    public void testLargeStraightScorer() {
        StraightScorer scorer = new StraightScorer(2);
        List<Integer> dice = Arrays.asList(2, 3, 4, 5, 6);
        assertEquals(20, scorer.calculateScore(dice));
    }

    @Test
    public void testInvalidStraight() {
        StraightScorer scorer = new StraightScorer(1);
        List<Integer> dice = Arrays.asList(1, 2, 2, 4, 5);
        assertEquals(0, scorer.calculateScore(dice));
    }
}
