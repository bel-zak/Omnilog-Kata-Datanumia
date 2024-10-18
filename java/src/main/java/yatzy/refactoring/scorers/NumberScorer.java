package yatzy.refactoring.scorers;

import java.util.List;
/**
 * Classe qui calcule le score pour une catégorie basée sur un nombre cible.
 * Le score est la somme des valeurs égales au nombre cible.
 */
public class NumberScorer extends CategoryScorer {
    private final int targetNumber;
    /**
     * Constructeur qui définit le nombre cible.
     *
     * @param targetNumber Le nombre pour lequel le score sera calculé.
     */
    public NumberScorer(int targetNumber) {
        this.targetNumber = targetNumber;
    }

    @Override
    public int calculateScore(List<Integer> dice) {
        return dice.stream().filter(die -> die == targetNumber).mapToInt(Integer::intValue).sum();
    }
}
