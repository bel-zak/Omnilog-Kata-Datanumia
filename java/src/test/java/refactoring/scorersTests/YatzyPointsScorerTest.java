package refactoring.scorersTests;

import java.util.List;


import org.junit.jupiter.api.Test;
import yatzy.refactoring.scorers.YatzyPointsScorer;

import java.util.Arrays;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class YatzyPointsScorerTest {

    @Test
    public void testYatzyScorer() {
        YatzyPointsScorer scorer = new YatzyPointsScorer();
        List<Integer> dice = Arrays.asList(6, 6, 6, 6, 6);
        assertEquals(50, scorer.calculateScore(dice));
    }

    @Test
    public void testNonYatzy() {
        YatzyPointsScorer scorer = new YatzyPointsScorer();
        List<Integer> dice = Arrays.asList(6, 6, 6, 6, 5);
        assertEquals(0, scorer.calculateScore(dice));
    }
}
