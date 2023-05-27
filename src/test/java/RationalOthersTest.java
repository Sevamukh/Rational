import org.junit.*;

import java.util.List;

import static org.junit.Assert.*;

public class RationalOthersTest {

    private Rational fraction;

    @Test
    public void defaultConstructor() {
        fraction = new Rational();
        assertEquals(
                "Конструктор по-умолчанию возвращает неверные значения",
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
        assertEquals(
                "Конструктор возвращает неверные значения",
                List.of(1, 2),
                List.of(fraction.getNumerator(), fraction.getDenominator())
        );
    }

    @Test
    public void constructorOfReducibleFraction() {
        fraction = new Rational(2, 4);
        assertEquals(
                "Конструктор возвращает неверные значения для сократимой дроби",
                List.of(1, 2),
                List.of(fraction.getNumerator(), fraction.getDenominator())
        );
    }

    @Test
    public void constructorOfReducibleFractionWithZeroNumerator() {
        fraction = new Rational(0, 2);
        assertEquals(
                "Конструктор возвращает неверные значения для дроби c нулевым числителем",
                List.of(0, 1),
                List.of(fraction.getNumerator(), fraction.getDenominator())
        );
    }

    @Test
    public void constructorWithNegativeDenominator() {
        fraction = new Rational(1, -2);
        assertEquals(
                "Конструктор возвращает неверные значения для дроби с минусом в знаменателе",
                List.of(-1, 2),
                List.of(fraction.getNumerator(), fraction.getDenominator())
        );
    }

    @Test
    public void setterForNumerator() {
        fraction = new Rational(1, 4);
        fraction.setNumerator(2);
        assertEquals(
                "Сеттер числителя работает некорректно",
                List.of(1, 2),
                List.of(fraction.getNumerator(), fraction.getDenominator())
        );
    }

    @Test
    public void setterForNonZeroDenominator() {
        fraction = new Rational(2, 3);
        fraction.setDenominator(4);
        assertEquals(
                "Сеттер знаменателя работает некорректно",
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
    public void formatToString() {
        fraction = new Rational(1, 2);
        assertEquals(
                "Приведение объекта-дроби к строке выполняется некорректно",
                "1/2",
                String.valueOf(fraction)
        );
    }
}
