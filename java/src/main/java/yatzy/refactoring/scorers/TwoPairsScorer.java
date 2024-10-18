package yatzy.refactoring.scorers;

import java.util.List;
import java.util.Map;

/**
 * Classe qui calcule le score pour la catégorie "Two Pairs".
 * Vérifie si le lancer contient deux paires et calcule le score en conséquence.
 */
public class TwoPairsScorer extends CategoryScorer {

    /**
     * Calcule le score pour la catégorie "Deux Paires".
     *
     * @param dice La liste des valeurs des dés.
     * @return Le score total des paires si exactement deux paires sont trouvées, sinon 0.
     */
    @Override
    public int calculateScore(List<Integer> dice) {
        Map<Integer, Long> occurrences = countOccurrences(dice);

        // Faire la somme des scores
        int score = occurrences.entrySet().stream()
            .filter(entry -> entry.getValue() >= 2)
            .mapToInt(entry -> entry.getKey() * 2)
            .sum();

        // Vérifie si on a  exactement deux paires
        long pairs = occurrences.values().stream()
            // Compter combien de valeurs ont au moins 2 occurrences
            .filter(count -> count >= 2)
            .count();

        return (pairs == 2) ? score : 0;
    }
}