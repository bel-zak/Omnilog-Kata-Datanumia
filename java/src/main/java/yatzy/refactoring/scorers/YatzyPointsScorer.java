package yatzy.refactoring.scorers;

import java.util.List;

public class YatzyPointsScorer extends CategoryScorer {

    @Override
    public int calculateScore(List<Integer> dice) {
        boolean allSame = dice.stream().distinct().count() == 1;
        return allSame ? 50 : 0;
    }
}
