import org.junit.*;

import java.util.List;

import static org.junit.Assert.*;

public class RationalTest {

    private Rational fraction, fraction2;

    @Test
    public void defaultConstructor() {
        fraction = new Rational();
        assertEquals("Конструктор по-умолчанию возвращает неверные значения",
                List.of(0, 1),
                List.of(fraction.getNumerator(), fraction.getDenominator())
        );
    }

    @Test(expected = ArithmeticException.class)
    public void constructorWithZeroDenominator() {
        fraction = new Rational(1, 0);
        fail("Ожидалась арифметическая ошибка деления на ноль");
    }

    @Test
    public void normalConstructor() {
        fraction = new Rational(1, 2);
        assertEquals("Конструктор возвращает неверные значения",
                List.of(1, 2),
                List.of(fraction.getNumerator(), fraction.getDenominator())
        );
    }

    @Test
    public void constructorOfReducibleFraction() {
        fraction = new Rational(2, 4);
        assertEquals("Конструктор возвращает неверные значения для сократимой дроби",
                List.of(1, 2),
                List.of(fraction.getNumerator(), fraction.getDenominator())
        );
    }

    @Test
    public void constructorOfReducibleFractionWithZeroNumerator() {
        fraction = new Rational(0, 2);
        assertEquals("Конструктор возвращает неверные значения для дроби c нулевым числителем",
                List.of(0, 1),
                List.of(fraction.getNumerator(), fraction.getDenominator())
        );
    }

    @Test
    public void constructorWithNegativeDenominator() {
        fraction = new Rational(1, -2);
        assertEquals("Конструктор возвращает неверные значения для дроби с минусом в знаменателе",
                List.of(-1, 2),
                List.of(fraction.getNumerator(), fraction.getDenominator())
        );
    }

    @Test
    public void setterForNumerator() {
        fraction = new Rational(1, 4);
        fraction.setNumerator(2);
        assertEquals("Сеттер числителя работает некорректно",
                List.of(1, 2),
                List.of(fraction.getNumerator(), fraction.getDenominator())
        );
    }

    @Test
    public void setterForNonZeroDenominator() {
        fraction = new Rational(2, 3);
        fraction.setDenominator(4);
        assertEquals("Сеттер знаменателя работает некорректно",
                List.of(1, 2),
                List.of(fraction.getNumerator(), fraction.getDenominator())
        );
    }

    @Test(expected = ArithmeticException.class)
    public void setterForZeroDenominator() {
        fraction = new Rational(1, 2);
        fraction.setDenominator(0);
        fail("Ожидалась арифметическая ошибка деления на ноль");
    }

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
        assertEquals("Ошибка сравнения на 'меньше' дробей c одинаковыми знаменателями",
                List.of(true, false, false),
                List.of(fraction.less(fraction2), fraction2.less(fraction), fraction.less(fraction))
        );
    }

    @Test
    public void lessForTwoFractionsWithSameNumerator() {
        fraction = new Rational(1, 3);
        fraction2 = new Rational(1, 2);
        assertEquals("Ошибка сравнения на 'меньше' дробей c одинаковыми числителями",
                List.of(true, false, false),
                List.of(fraction.less(fraction2), fraction2.less(fraction), fraction.less(fraction))
        );
    }

    @Test
    public void lessForTwoFractionsWithDifferentNumeratorAndDenominator() {
        fraction = new Rational(2, 5);
        fraction2 = new Rational(1, 2);
        assertEquals("Ошибка сравнения на 'меньше' дробей",
                List.of(true, false, false),
                List.of(fraction.less(fraction2), fraction2.less(fraction), fraction.less(fraction))
        );
    }

    @Test
    public void lessOrEqual() {
        fraction = new Rational(1, 3);
        fraction2 = new Rational(1, 2);
        assertEquals("Ошибка сравнения дробей на 'меньше или равно'",
                List.of(true, false, true),
                List.of(fraction.lessOrEqual(fraction2), fraction2.lessOrEqual(fraction), fraction.lessOrEqual(fraction))
        );
    }

    @Test
    public void plus() {
        fraction = new Rational(1, 3);
        fraction2 = new Rational(1, 2);
        fraction = fraction.plus(fraction2);
        assertEquals("Сложение дробей выполняется некорректно",
                List.of(5, 6),
                List.of(fraction.getNumerator(), fraction.getDenominator())
        );
    }

    @Test
    public void multiply() {
        fraction = new Rational(1, 3);
        fraction2 = new Rational(1, 2);
        fraction = fraction.multiply(fraction2);
        assertEquals("Умножение дробей выполняется некорректно",
                List.of(1, 6),
                List.of(fraction.getNumerator(), fraction.getDenominator())
        );
    }

    @Test
    public void minus() {
        fraction = new Rational(1, 2);
        fraction2 = new Rational(1, 3);
        fraction = fraction.minus(fraction2);
        assertEquals("Вычитание дробей выполняется некорректно",
                List.of(1, 6),
                List.of(fraction.getNumerator(), fraction.getDenominator())
        );
    }

    @Test
    public void divideWithNonZeroDivisor() {
        fraction = new Rational(1, 3);
        fraction2 = new Rational(1, 2);
        fraction = fraction.divide(fraction2);
        assertEquals("Деление дробей выполняется некорректно",
                List.of(2, 3),
                List.of(fraction.getNumerator(), fraction.getDenominator())
        );
    }

    @Test(expected = ArithmeticException.class)
    public void divideWithZeroDivisor() {
        fraction = new Rational(1, 2);
        fraction2 = new Rational();
        fraction = fraction.divide(fraction2);
        fail("Ожидалась арифметическая ошибка деления на ноль");
    }
}
