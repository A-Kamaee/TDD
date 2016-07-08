package business;

public interface Expression {
	
	public Expression plus(Money money);
	
	public Money calculate(String currency);
	
}
