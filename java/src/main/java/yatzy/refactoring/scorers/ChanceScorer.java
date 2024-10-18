package yatzy.refactoring.scorers;

import java.util.List;
/**
 * Classe qui calcule le score pour la catégorie "Chance".
 * Le score est la somme de toutes les valeurs des dés.
 */
public class ChanceScorer extends CategoryScorer {
    @Override
    public int calculateScore(List<Integer> dice) {
        return sum(dice);
    }
}
