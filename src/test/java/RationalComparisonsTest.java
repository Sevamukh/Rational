import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class RationalComparisonsTest {

    private Rational fraction, fraction2;

    @Test
    public void equalForTwoEqualFractions() {
        fraction = new Rational(1, 2);
        fraction2 = new Rational(1, 2);
        assertEquals("Ошибка проверки на равенство одинаковых дробей", fraction, fraction2);
    }

    @Test
    public void equalForTwoDifferentFractions() {
        fraction = new Rational(1, 2);
        fraction2 = new Rational(1, 3);
        assertNotEquals("Ошибка проверки на равенство разных дробей", fraction, fraction2);
    }

    @Test
    public void lessForTwoFractionsWithSameDenominator() {
        fraction = new Rational(1, 3);
        fraction2 = new Rational(2, 3);
        assertEquals(
                "Ошибка сравнения на 'меньше' дробей c одинаковыми знаменателями",
                List.of(true, false, false),
                List.of(fraction.less(fraction2), fraction2.less(fraction), fraction.less(fraction))
        );
    }

    @Test
    public void lessForTwoFractionsWithSameNumerator() {
        fraction = new Rational(1, 3);
        fraction2 = new Rational(1, 2);
        assertEquals(
                "Ошибка сравнения на 'меньше' дробей c одинаковыми числителями",
                List.of(true, false, false),
                List.of(fraction.less(fraction2), fraction2.less(fraction), fraction.less(fraction))
        );
    }

    @Test
    public void lessForTwoFractionsWithDifferentNumeratorAndDenominator() {
        fraction = new Rational(2, 5);
        fraction2 = new Rational(1, 2);
        assertEquals(
                "Ошибка сравнения на 'меньше' дробей",
                List.of(true, false, false),
                List.of(fraction.less(fraction2), fraction2.less(fraction), fraction.less(fraction))
        );
    }

    @Test
    public void lessOrEqual() {
        fraction = new Rational(1, 3);
        fraction2 = new Rational(1, 2);
        assertEquals(
                "Ошибка сравнения дробей на 'меньше или равно'",
                List.of(true, false, true),
                List.of(fraction.lessOrEqual(fraction2), fraction2.lessOrEqual(fraction), fraction.lessOrEqual(fraction))
        );
    }
}
