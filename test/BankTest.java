package test;

import org.junit.Test;
import static org.junit.Assert.*;


import business.Bank;
import business.Money;
import business.MoneyFactory;

public class BankTest {
	
	@Test
	public void testReduceMoneyDifferentCurrency()
	{
		Bank bank = new Bank();
		bank.addRate("CHF", "USD", 2);
		Money result = bank.reduce(MoneyFactory.createFranc(2), "USD");
		assertEquals(MoneyFactory.createDollar(1), result);
	}
	
}
