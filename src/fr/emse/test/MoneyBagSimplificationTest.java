package fr.emse.test;

import static org.junit.Assert.*;

import org.junit.Test;

public class MoneyBagSimplificationTest {

	@Test
    public void testMoneyBagSimplification() {
        Money f10CHF = new Money(10, "CHF");
        Money f20CHF = new Money(20, "CHF");
        Money f30CHF = new Money(30, "CHF");
        Money f15USD = new Money(15, "USD");

        MoneyBag bag1 = new MoneyBag(new Money[]{f10CHF, f20CHF});
        MoneyBag bag2 = new MoneyBag(new Money[]{f30CHF, f15USD});

        Money expected1 = new Money(30, "CHF");
        Money expected2 = new Money(15, "USD");

        assertEquals(expected1, bag1);
        assertEquals(expected2, bag2);
    }

}
