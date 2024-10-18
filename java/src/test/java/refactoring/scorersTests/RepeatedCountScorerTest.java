package refactoring.scorersTests;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import yatzy.refactoring.scorers.RepeatedCountScorer;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RepeatedCountScorerTest {

    @Test
    public void testThreeOfAKindScorer() {
        RepeatedCountScorer scorer = new RepeatedCountScorer(3);
        List<Integer> dice = Arrays.asList(3, 3, 3, 4, 5);
        assertEquals(9, scorer.calculateScore(dice));
    }

    @Test
    public void testFourOfAKindScorer() {
        RepeatedCountScorer scorer = new RepeatedCountScorer(4);
        List<Integer> dice = Arrays.asList(6, 6, 6, 6, 1);
        assertEquals(24, scorer.calculateScore(dice));
    }

    @Test
    public void testInvalidThreeOfAKind() {
        RepeatedCountScorer scorer = new RepeatedCountScorer(3);
        List<Integer> dice = Arrays.asList(2, 2, 4, 5, 6);
        assertEquals(0, scorer.calculateScore(dice));
    }
}