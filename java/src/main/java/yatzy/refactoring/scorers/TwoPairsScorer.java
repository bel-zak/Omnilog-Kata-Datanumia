package yatzy.refactoring.scorers;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class TwoPairsScorer extends CategoryScorer {

    @Override
    public int calculateScore(List<Integer> dice) {
        Map<Integer, Long> occurrences = countOccurrences(dice);

        int pairs = 0;
        int score = 0;

        for (Map.Entry<Integer, Long> entry : occurrences.entrySet()) {
            if (entry.getValue() >= 2) {
                pairs++;
                score += entry.getKey() * 2;
            }
        }

        return (pairs == 2) ? score : 0;
    }
}