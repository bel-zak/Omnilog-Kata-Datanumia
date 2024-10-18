package refactoring.serviceTests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import yatzy.refactoring.interfaces.IYatzyCalculator;
import yatzy.refactoring.models.YatzyCategory;
import yatzy.refactoring.service.YatzyCalculatorImpl;

import java.util.Arrays;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class YatzyCalculatorImplTest {

    private IYatzyCalculator yatzyCalculator;

    @BeforeEach
    public void setUp() {
        yatzyCalculator = new YatzyCalculatorImpl();
    }

    @Test
    public void testCalculateChance() {
        List<Integer> dice = Arrays.asList(2, 3, 4, 5, 1);
        assertEquals(15, yatzyCalculator.calculate(YatzyCategory.CHANCE, dice));
    }

    @Test
    public void testCalculateFullHouse() {
        List<Integer> dice = Arrays.asList(3, 3, 3, 5, 5);
        assertEquals(19, yatzyCalculator.calculate(YatzyCategory.FULL_HOUSE, dice));
    }

    @Test
    public void testCalculateYatzy() {
        List<Integer> dice = Arrays.asList(6, 6, 6, 6, 6);
        assertEquals(50, yatzyCalculator.calculate(YatzyCategory.YATZY, dice));
    }

    @Test
    public void testCalculateSmallStraight() {
        List<Integer> dice = Arrays.asList(1, 2, 3, 4, 5);
        assertEquals(15, yatzyCalculator.calculate(YatzyCategory.SMALL_STRAIGHT, dice));
    }

    @Test
    public void testCalculateLargeStraight() {
        List<Integer> dice = Arrays.asList(2, 3, 4, 5, 6);
        assertEquals(20, yatzyCalculator.calculate(YatzyCategory.LARGE_STRAIGHT, dice));
    }

    @Test
    public void testCalculateTwoPairs() {
        List<Integer> dice = Arrays.asList(3, 3, 5, 5, 6);
        assertEquals(16, yatzyCalculator.calculate(YatzyCategory.TWO_PAIRS, dice));
    }

    @Test
    public void testCalculateInvalidCategory() {
        List<Integer> dice = Arrays.asList(1, 2, 3, 4, 5);
        assertThrows(IllegalArgumentException.class, () -> yatzyCalculator.calculate(null, dice));
    }
}