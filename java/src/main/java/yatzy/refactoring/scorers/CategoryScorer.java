package yatzy.refactoring.scorers;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
/**
 * Classe abstraite représentant un calculateurs de score pour les catégories de Yatzy.
 * Les sous-classes doivent implémenter la méthode {@link #calculateScore(List<Integer>)} pour fournir
 * leur propre logique de calcul de score.
 */

public abstract class CategoryScorer {
    /**
     * Calcule le score pour un lancer de dés donné.
     *
     * @param dice La liste des valeurs des dés.
     * @return Le score calculé.
     */
    public abstract int calculateScore(List<Integer> dice);

    /**
     * Compte les occurrences de chaque valeur dans la liste des dés.
     *
     * @param dice La liste des valeurs des dés.
     * @return Un map associant chaque valeur à son nombre d'occurrences.
     */
    protected Map<Integer, Long> countOccurrences(List<Integer> dice) {
        return dice.stream().collect(Collectors.groupingBy(d -> d, Collectors.counting()));
    }
    /**
     * Calcule la somme des valeurs dans la liste des dés.
     *
     * @param dice La liste des valeurs des dés.
     * @return La somme des valeurs.
     */

    protected int sum(List<Integer> dice) {
        return dice.stream().mapToInt(Integer::intValue).sum();
    }
}
