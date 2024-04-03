package fr.emse.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MoneyTest {

	private Money m12CHF;
    private Money m14CHF;
    private Money f12CHF;
    private Money f14CHF;
    private Money f7USD;
    private Money f21USD;
	
	@Before
    public void setUp() {
        m12CHF = new Money(12, "CHF");
        m14CHF = new Money(14, "CHF");
        f12CHF = new Money(12, "CHF");
        f14CHF = new Money(14, "CHF");
        f7USD = new Money(7, "USD");
        f21USD = new Money(21, "USD");
    }

    @Test
    public void testSimpleAdd() {
        Money expected = new Money(26, "CHF");
        IMoney result = m12CHF.add(m14CHF);
        assertTrue(expected.equals(result));
    }
    

	@Test
	public void testEquals() {
		assertTrue(!m12CHF.equals(null)); 
		assertEquals(m12CHF, m12CHF);
		assertEquals(m12CHF, new Money(12, "CHF"));
		assertTrue(!m12CHF.equals(m14CHF));
	}
	
	@Test
    public void testMixedSimpleAdd() {
        MoneyBag expected = new MoneyBag(new Money[]{f12CHF, f7USD});
        assertEquals(expected, f12CHF.add(f7USD));
    }

    @Test
    public void testBagSimpleAdd() {
        MoneyBag expected = new MoneyBag(new Money[]{f12CHF, f7USD});
        MoneyBag bag = new MoneyBag(f12CHF, f7USD);
        assertEquals(expected, bag.add(f14CHF));
    }

    @Test
    public void testSimpleBagAdd() {
        MoneyBag expected = new MoneyBag(new Money[]{f12CHF, f7USD});
        MoneyBag bag = new MoneyBag(f12CHF, f7USD);
        assertEquals(expected, f14CHF.add(bag));
    }

    @Test
    public void testBagBagAdd() {
        MoneyBag expected = new MoneyBag(new Money[]{f12CHF, f7USD, f14CHF, f21USD});
        MoneyBag bag1 = new MoneyBag(f12CHF, f7USD);
        MoneyBag bag2 = new MoneyBag(f14CHF, f21USD);
        assertEquals(expected, bag1.add(bag2));
    }
}
