package business;

public class Money implements Expression {
	
	private int amount;
	private String currency;
	
	protected Money(int amount, String type)
	{
		this.amount = amount;
		this.currency = type;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public String getCurrency() {
		return currency;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Money other = (Money) obj;
		if(!currency.equals(other.currency))
			return false;
		if (amount != other.amount)
			return false;
		return true;
	}
	
	public Money times(int multiplicity)
	{
		return new Money(amount * multiplicity, currency);
	}
	
	@Override
	public Expression plus(Money augend)
	{
		return new Money(amount + augend.amount, currency);
	}
	
	@Override
	public String toString()
	{
		return String.format("(%d, %s)", amount, currency);
	}

	@Override
	public Money calculate(String currency) {
		return this;
	}
	
	private Money exchange(Money money, String newCurrency)
	{
		if(money.getCurrency().equals(newCurrency))
		{
			return new Money(money.getAmount(), money.getCurrency());
		}
		int tradeRate = Bank.getInstance().getTradeRate(money.getCurrency(), newCurrency);
		int newAmount = money.times(tradeRate).getAmount();
		return new Money(newAmount, newCurrency);
	}
	
}
