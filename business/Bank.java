package business;

import java.util.ArrayList;
import java.util.List;

public class Bank {
	
	private List<TradeRate> rates;
	private Bank instance;	
	
	private Bank()
	{
		rates = new ArrayList<Bank.TradeRate>();
	}
	
	public static Bank getInstance()
	{
		return new Bank();
	}
	
	public void addRate(String from, String to, int rate)
	{
		rates.add(new TradeRate(from, to, rate));
	}
	
	public int getTradeRate(String from, String to)
	{
		for(TradeRate item : rates)
		{
			if(item.getFrom().equals(from))
			{
				if(item.getTo().equals(to))
				{
					return item.getRate();
				}
			}
		}
		throw new UnsupportedOperationException
			(String.format("There is no trade rate from %s to %s.", from, to));
	}
	
	private class TradeRate
	{	
		private String from;
		private String to;
		private int rate;
		
		public String getFrom() {
			return from;
		}
		public String getTo() {
			return to;
		}
		public int getRate() {
			return rate;
		}
		
		public TradeRate(String from, String to, int rate)
		{
			this.from = from;
			this.to = to;
			this.rate = rate;
		}
	}
	
}
