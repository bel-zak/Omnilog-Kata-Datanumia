package yatzy.refactoring.scorers;

import java.util.List;
/**
 * Classe qui calcule le score pour la catégorie "Yatzy".
 * Un Yatzy est obtenu lorsque tous les dés montrent la même valeur.
 */
public class YatzyPointsScorer extends CategoryScorer {

    @Override
    public int calculateScore(List<Integer> dice) {
        boolean allSame = dice.stream().distinct().count() == 1;
        return allSame ? 50 : 0;
    }
}
