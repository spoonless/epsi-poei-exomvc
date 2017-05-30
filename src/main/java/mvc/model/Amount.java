package mvc.model;

import java.util.Currency;

import javax.persistence.Embeddable;

@Embeddable
public class Amount {
	private static final Currency DEFAULT_CURRENCY = Currency.getInstance("EUR");
	private long value;
	
	public Amount(String integerPart, String fractionPart) throws NumberFormatException {
		long integerPartAsLong = Long.valueOf(integerPart);
		long fractionPartAsLong = Long.valueOf(fractionPart);
		if (fractionPart.length() < 2) {
			fractionPartAsLong = fractionPartAsLong * 10;
		}
		this.value = (long) (integerPartAsLong * Math.pow(10, DEFAULT_CURRENCY.getDefaultFractionDigits()) + fractionPartAsLong);
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
