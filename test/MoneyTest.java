package test;
import static org.junit.Assert.*;

import org.junit.Test;

import business.Bank;
import business.Expression;
import business.Money;
import business.MoneyFactory;

/**
 * 
 */

/**
 * @author Abouzar
 *
 */
public class MoneyTest {

	@Test
	public void testMultiplication1() {
		
		Money five = MoneyFactory.createDollar(5);
		Money ten = five.times(2);
		
		assertEquals(ten, MoneyFactory.createDollar(10));
	}
	
	@Test
	public void testMultiplication2() 
	{
		Money five = MoneyFactory.createDollar(5);
		Money ten = five.times(2);
		Money thirty = ten.times(3);
		
		assertEquals(thirty, MoneyFactory.createDollar(30));
	}
	
	@Test
	public void testCalculation1()
	{
		Bank bank = Bank.getInstance();
		bank.addRate("CHF", "USD", 11);
		Money money = MoneyFactory.createFranc(2).calculate("USD");
		assertEquals(MoneyFactory.createDollar(22), money);
	}
	
	@Test
	public void testSimpleAddition()
	{
		Money five = MoneyFactory.createDollar(5);
		Expression sum = five.plus(MoneyFactory.createDollar(5));
		Money result = sum.calculate("USD");
		
		assertEquals(result, MoneyFactory.createDollar(10));
	}
	
	@Test
	public void testAdditionWithRate1()
	{
		Bank bank = Bank.getInstance();
		bank.addRate("USD", "CHF", 3);
		Money dollar = MoneyFactory.createDollar(5);
		Expression sum = dollar.plus(MoneyFactory.createFranc(9));
		Money result = sum.calculate("CHF");
		
		assertEquals(MoneyFactory.createFranc(24) , result);
	}
	
	@Test
	public void testAdditionWithRate2()
	{
		Bank bank = Bank.getInstance();
		bank.addRate("USD", "CHF", 7);
//		bank.addRate("CHF", "USD", 0.1428571428571429f);
		Money dollar = MoneyFactory.createDollar(3);
		Expression sum = dollar.plus(MoneyFactory.createFranc(14));
		Money result = sum.calculate("USD");
		assertEquals(MoneyFactory.createDollar(5), result);
	}
	
	
}
