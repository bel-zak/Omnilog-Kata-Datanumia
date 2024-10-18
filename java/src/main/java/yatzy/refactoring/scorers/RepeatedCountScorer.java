package yatzy.refactoring.scorers;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class RepeatedCountScorer extends CategoryScorer {
    private final int count;

    public RepeatedCountScorer(int count) {
        this.count = count;
    }

    @Override
    public int calculateScore(List<Integer> dice) {
        Map<Integer, Long> occurrences = countOccurrences(dice);
        return occurrences.entrySet().stream()
            .filter(entry -> entry.getValue() >= count)
            .mapToInt(entry -> entry.getKey() * count)
            .findFirst()
            .orElse(0);
    }
}