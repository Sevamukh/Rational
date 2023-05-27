import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class RationalOperationsTest {
    private Rational fraction, fraction2;

    @Test
    public void plus() {
        fraction = new Rational(1, 3);
        fraction2 = new Rational(1, 2);
        fraction = fraction.plus(fraction2);
        assertEquals(
                "Сложение дробей выполняется некорректно",
                List.of(5, 6),
                List.of(fraction.getNumerator(), fraction.getDenominator())
        );
    }

    @Test
    public void multiply() {
        fraction = new Rational(1, 3);
        fraction2 = new Rational(1, 2);
        fraction = fraction.multiply(fraction2);
        assertEquals(
                "Умножение дробей выполняется некорректно",
                List.of(1, 6),
                List.of(fraction.getNumerator(), fraction.getDenominator())
        );
    }

    @Test
    public void minus() {
        fraction = new Rational(1, 2);
        fraction2 = new Rational(1, 3);
        fraction = fraction.minus(fraction2);
        assertEquals(
                "Вычитание дробей выполняется некорректно",
                List.of(1, 6),
                List.of(fraction.getNumerator(), fraction.getDenominator())
        );
    }

    @Test
    public void divideWithNonZeroDivisor() {
        fraction = new Rational(1, 3);
        fraction2 = new Rational(1, 2);
        fraction = fraction.divide(fraction2);
        assertEquals(
                "Деление дробей выполняется некорректно",
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
