package mvc.model;

import java.util.Currency;

public class Amount {
	private static final Currency DEFAULT_CURRENCY = Currency.getInstance("EUR");
	private long value;
	
	public Amount(long integerPart, long fractionPart) {
		if (fractionPart < 10) {
			fractionPart = fractionPart * 10;
		}
		this.value = (long) (integerPart * Math.pow(10, DEFAULT_CURRENCY.getDefaultFractionDigits()) + fractionPart);
	}

	public long getValue() {
		return value;
	}

	public double getValueWithFractionDigits() {
		return this.value / Math.pow(10, getCurrency().getDefaultFractionDigits());
	}
	
	public Currency getCurrency() {
		return DEFAULT_CURRENCY;
	}

}
