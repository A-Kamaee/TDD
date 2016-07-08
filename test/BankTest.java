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
		Bank bank = Bank.getInstance();
		bank.addRate("CHF", "USD", 2);
		Money result = MoneyFactory.createFranc(2).calculate("USD");
		assertEquals(MoneyFactory.createDollar(4), result);
	}
	
}
