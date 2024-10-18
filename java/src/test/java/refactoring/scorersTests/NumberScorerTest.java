package refactoring.scorersTests;

import java.util.List;

import org.junit.jupiter.api.Test;
import yatzy.refactoring.scorers.NumberScorer;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberScorerTest {

    @Test
    public void testOnesScorer() {
        NumberScorer scorer = new NumberScorer(1);
        List<Integer> dice = Arrays.asList(1, 2, 1, 4, 5);
        assertEquals(2, scorer.calculateScore(dice));
    }

    @Test
    public void testTwosScorer() {
        NumberScorer scorer = new NumberScorer(2);
        List<Integer> dice = Arrays.asList(1, 2, 2, 4, 5);
        assertEquals(4, scorer.calculateScore(dice));
    }
}
