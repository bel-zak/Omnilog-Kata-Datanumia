package yatzy.refactoring.main;

import yatzy.refactoring.models.YatzyCategory;
import yatzy.refactoring.service.YatzyCalculatorImpl;

import java.util.Arrays;
import java.util.List;

public class Game {
    public static void main(String[] args) {
        YatzyCalculatorImpl calculator = new YatzyCalculatorImpl();
        List<Integer> dice = Arrays.asList(3, 3, 5, 5, 1); // Exemple de dés

        YatzyCategory bestCategory = calculator.getBestCategory(dice);
        System.out.println("La meilleure catégorie à jouer est : " + bestCategory);
    }
}