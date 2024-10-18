package yatzy.refactoring.service;

import yatzy.refactoring.interfaces.IYatzyCalculator;
import yatzy.refactoring.models.YatzyCategory;
import yatzy.refactoring.scorers.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class YatzyCalculatorImpl implements IYatzyCalculator {

    private final Map<YatzyCategory, CategoryScorer> scorers;

    public YatzyCalculatorImpl() {
        scorers = new HashMap<>();
        initializeScorers();
    }

    private void initializeScorers() {
        scorers.put(YatzyCategory.CHANCE, new ChanceScorer());
        scorers.put(YatzyCategory.FULL_HOUSE, new FullHouseScorer());
        scorers.put(YatzyCategory.ONES, new NumberScorer(1));
        scorers.put(YatzyCategory.TWOS, new NumberScorer(2));
        scorers.put(YatzyCategory.THREES, new NumberScorer(3));
        scorers.put(YatzyCategory.FOURS, new NumberScorer(4));
        scorers.put(YatzyCategory.FIVES, new NumberScorer(5));
        scorers.put(YatzyCategory.SIXES, new NumberScorer(6));
        scorers.put(YatzyCategory.PAIR, new RepeatedCountScorer(2));
        scorers.put(YatzyCategory.TWO_PAIRS, new TwoPairsScorer());
        scorers.put(YatzyCategory.THREE_OF_A_KIND, new RepeatedCountScorer(3));
        scorers.put(YatzyCategory.FOUR_OF_A_KIND, new RepeatedCountScorer(4));
        scorers.put(YatzyCategory.SMALL_STRAIGHT, new StraightScorer(1));
        scorers.put(YatzyCategory.LARGE_STRAIGHT, new StraightScorer(2));
        scorers.put(YatzyCategory.YATZY, new YatzyPointsScorer());
    }

    @Override
    public int calculate(YatzyCategory category, List<Integer> dice) {
        CategoryScorer scorer = scorers.get(category);
        if (scorer == null) {
            throw new IllegalArgumentException("Catégorie non prise en charge : " + category);
        }
        return scorer.calculateScore(dice);
    }
}