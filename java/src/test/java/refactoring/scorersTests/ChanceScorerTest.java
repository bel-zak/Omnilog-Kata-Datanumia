package refactoring.scorersTests;


import org.junit.jupiter.api.Test;
import yatzy.refactoring.scorers.ChanceScorer;

import java.util.Arrays;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChanceScorerTest {

    @Test
    public void testChanceScore() {
        ChanceScorer scorer = new ChanceScorer();
        List<Integer> dice = Arrays.asList(1, 2, 3, 4, 5);
        assertEquals(15, scorer.calculateScore(dice));
    }
}