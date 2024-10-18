package yatzy.refactoring.scorers;

import java.util.List;

public class NumberScorer extends CategoryScorer {
    private final int targetNumber;

    public NumberScorer(int targetNumber) {
        this.targetNumber = targetNumber;
    }

    @Override
    public int calculateScore(List<Integer> dice) {
        return dice.stream().filter(die -> die == targetNumber).mapToInt(Integer::intValue).sum();
    }
}
