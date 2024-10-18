package yatzy.refactoring.scorers;

import java.util.List;
import java.util.Map;
/**
 * Classe qui calcule le score pour la catégorie "Full House".
 * Un Full House est obtenu lorsque le lancer contient un brelan et une paire.
 */
public class FullHouseScorer extends CategoryScorer {
    @Override
    public int calculateScore(List<Integer> dice) {
        Map<Integer, Long> occurrences = countOccurrences(dice);
        boolean hasThreeOfAKind = occurrences.containsValue(3L);
        boolean hasPair = occurrences.containsValue(2L);

        if (hasThreeOfAKind && hasPair) {
            return sum(dice);
        }
        return 0;
    }
}
