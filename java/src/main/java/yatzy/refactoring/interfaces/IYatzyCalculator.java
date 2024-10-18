package yatzy.refactoring.interfaces;

import yatzy.refactoring.models.YatzyCategory;

import java.util.List;

public interface IYatzyCalculator {

    /**
     * Calcule le score pour une catégorie Yatzy donnée.
     *
     * @param category La catégorie de Yatzy pour laquelle le score doit être calculé.
     * @param dice     Les dés utilisés dans le jeu sous forme de liste d'entiers.
     * @return Le score calculé pour la catégorie donnée.
     */
    int calculate(YatzyCategory category, List<Integer> dice);
}