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
	
	public Money times(float multiplicity)
	{
		int intAmount = Math.round(amount * multiplicity);
		return new Money(intAmount, currency);
	}
	
	@Override
	public Expression plus(Money addend)
	{
		return new Sum(new Money(amount, currency), addend);
	}
	
	@Override
	public String toString()
	{
		return String.format("(%d, %s)", amount, currency);
	}

	@Override
	public Money calculate(String currency) {
		
		if(this.getCurrency().equals(currency))
		{
			return new Money(this.getAmount(), this.getCurrency());
		}
		float tradeRate = Bank.getInstance().getTradeRate(this.getCurrency(), currency);
		int newAmount = this.times(tradeRate).getAmount();
		return new Money(newAmount, currency);
	}
	
}
