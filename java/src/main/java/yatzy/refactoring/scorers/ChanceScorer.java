package yatzy.refactoring.scorers;

import java.util.List;

public class ChanceScorer extends CategoryScorer {
    @Override
    public int calculateScore(List<Integer> dice) {
        return sum(dice);
    }
}
