package yatzy.refactoring.service;

import yatzy.refactoring.interfaces.IYatzyCalculator;
import yatzy.refactoring.models.YatzyCategory;
import yatzy.refactoring.scorers.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * Classe principale qui implémente le calcul des scores de Yatzy.
 * Elle utilise des calculateurs de catégories spécifiques pour chaque catégorie de score.
 */
public class YatzyCalculatorImpl implements IYatzyCalculator {

    private final Map<YatzyCategory, CategoryScorer> scorers;
    /**
     * Constructeur qui initialise les calculateurs de score pour chaque catégorie de Yatzy.
     */
    public YatzyCalculatorImpl() {
        scorers = new HashMap<>();
        initializeScorers();
    }
    /**
     * Initialise les calculateurs de score pour chaque catégorie.
     */
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

    /**
     * Trouve la meilleure catégorie à jouer en fonction des dés donnés.
     *
     * @param dice Les dés utilisés dans le jeu sous forme de liste d'entiers.
     * @return La catégorie Yatzy avec le score le plus élevé.
     */
    public YatzyCategory getBestCategory(List<Integer> dice) {
        YatzyCategory bestCategory = null;
        int highestScore = 0;

        for (Map.Entry<YatzyCategory, CategoryScorer> entry : scorers.entrySet()) {
            int score = entry.getValue().calculateScore(dice);
            if (score > highestScore) {
                highestScore = score;
                bestCategory = entry.getKey();
            }
        }

        return bestCategory;
    }
}
