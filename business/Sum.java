package business;

public class Sum implements Expression {
	
	private Money augend;
	private Money addend;
	
	protected Sum(Money augend)
	{
		this.augend = augend;
	}
	
	@Override
	public Expression plus(Money money) 
	{
		Sum result = new Sum(augend);
		result.addend = money;
		return result;
	}

	@Override
	public Money calculate(String currency) {
		int amount = augend.getAmount() + addend.getAmount();
		Money result = new Money(amount, currency);
		return result;
	}
	
}
