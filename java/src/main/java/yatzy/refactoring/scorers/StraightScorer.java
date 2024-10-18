package yatzy.refactoring.scorers;

import java.util.List;

public class StraightScorer extends CategoryScorer {
    private final int startingNumber;

    public StraightScorer(int startingNumber) {
        this.startingNumber = startingNumber;
    }

    @Override
    public int calculateScore(List<Integer> dice) {
        int expectedSum = (startingNumber == 1) ? 15 : 20;
        boolean isStraight = dice.stream().distinct().count() == 5 &&
            dice.stream().mapToInt(Integer::intValue).sum() == expectedSum;

        return isStraight ? expectedSum : 0;
    }
}
