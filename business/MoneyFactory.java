package business;


public class MoneyFactory {
	
	public static Money createDollar(int amount)
	{
		return new Money(amount, "USD");
	}
	
	public static Money createFranc(int amount)
	{
		return new Money(amount, "CHF");
	}
}
