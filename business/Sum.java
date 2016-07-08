package business;

import javax.naming.OperationNotSupportedException;

public class Sum implements Expression {
	
	private Money augend;
	private Money addend;
	
	protected Sum(Money augend, Money addend)
	{
		this.augend = augend;
		this.addend = addend;
	}
	
	@Override
	public Expression plus(Money money)
	{
		return null;
//		throw new OperationNotSupportedException("Operation add money to sum not supported right now");
	}

	@Override
	public Money calculate(String currency) {
		Money newAugend = augend.calculate(currency);
		Money newAddend = addend.calculate(currency);
		int amount = newAddend.getAmount() + newAugend.getAmount();
		Money result = new Money(amount, currency);
		return result;
	}
	
}
