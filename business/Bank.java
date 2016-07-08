package business;

import java.util.ArrayList;
import java.util.List;

public class Bank {
	
	private List<TradeRate> rates;
	private static Bank instance;	
	
	private Bank()
	{
		rates = new ArrayList<Bank.TradeRate>();
	}
	
	public static Bank getInstance()
	{
		if(instance == null)
		{
			instance = new Bank();
		}
		return instance;
	}
	
	public void addRate(String from, String to, float rate)
	{
		TradeRate item1 = getTradeRateItem(from, to);
		if(item1 != null)
		{
			rates.remove(item1);
		}
		rates.add(new TradeRate(from, to, rate));
		float invertedRate = (float)( 1 / rate);
		TradeRate item2 = getTradeRateItem(to, from);
		if(item2 != null)
		{
			rates.remove(item2);
		}
		rates.add(new TradeRate(to, from, invertedRate));
	}
	
	public float getTradeRate(String from, String to)
	{
		TradeRate tradeRateItem = getTradeRateItem(from, to);
		if(tradeRateItem == null)
		{
			throw new UnsupportedOperationException
				(String.format("There is no trade rate from %s to %s.", from, to));
		}
		else
		{
			return tradeRateItem.rate;
		}
	}
	
	private TradeRate getTradeRateItem(String from, String to)
	{
		for(TradeRate item : rates)
		{
			if(item.getFrom().equals(from))
			{
				if(item.getTo().equals(to))
				{
					return item;
				}
			}
		}
		return null;
	}
	
	private class TradeRate
	{	
		private String from;
		private String to;
		private float rate;
		
		public String getFrom() {
			return from;
		}
		public String getTo() {
			return to;
		}
		public float getRate() {
			return rate;
		}
		
		public TradeRate(String from, String to, float rate)
		{
			this.from = from;
			this.to = to;
			this.rate = rate;
		}
	}
	
}
