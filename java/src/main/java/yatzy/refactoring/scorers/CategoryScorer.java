package yatzy.refactoring.scorers;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class CategoryScorer {

    public abstract int calculateScore(List<Integer> dice);


    protected Map<Integer, Long> countOccurrences(List<Integer> dice) {
        return dice.stream().collect(Collectors.groupingBy(d -> d, Collectors.counting()));
    }


    protected int sum(List<Integer> dice) {
        return dice.stream().mapToInt(Integer::intValue).sum();
    }
}
