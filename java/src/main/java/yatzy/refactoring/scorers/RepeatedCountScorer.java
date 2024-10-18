package yatzy.refactoring.scorers;


import java.util.List;
import java.util.Map;

/**
 * Classe qui calcule le score basé sur un nombre d'occurrences spécifique.
 * Le score est la valeur du nombre multipliée par le nombre d'occurrences.
 */
public class RepeatedCountScorer extends CategoryScorer {
    private final int count;
    /**
     * Constructeur qui définit le nombre d'occurrences à vérifier.
     *
     * @param count Le nombre d'occurrences requis pour le score.
     */
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