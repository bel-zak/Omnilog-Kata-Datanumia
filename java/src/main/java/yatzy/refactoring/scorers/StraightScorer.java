package yatzy.refactoring.scorers;

import java.util.List;
/**
 * Classe qui calcule le score pour une catégorie de suite (Straight).
 * Le score est basé sur la vérification d'une suite spécifique de dés.
 */
public class StraightScorer extends CategoryScorer {
    private final int startingNumber;
    /**
     * Constructeur qui définit le nombre de départ de la suite.
     *
     * @param startingNumber Le nombre de départ pour la suite (1 pour petite suite, 2 pour grande suite).
     */
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
