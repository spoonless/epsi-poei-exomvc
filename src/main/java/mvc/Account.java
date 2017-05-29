package mvc;

import java.util.Currency;

public class Account {

	private static final Currency DEFAULT_CURRENCY = Currency.getInstance("EUR");
	private String name;
	private String number;
	private long balance;

	public Account(String name, String number, long balance) {
		this.name = name;
		this.number = number;
		this.balance = balance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public long getBalance() {
		return balance;
	}

	public void setBalance(long balance) {
		this.balance = balance;
	}
	
	public double getBalanceWithFractionDigits() {
		return this.balance / Math.pow(10, getCurrency().getDefaultFractionDigits());
	}
	
 	public Currency getCurrency() {
		return DEFAULT_CURRENCY;
	}

}
