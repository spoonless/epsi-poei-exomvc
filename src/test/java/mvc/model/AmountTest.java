package mvc.model;

import org.junit.Test;
import static org.junit.Assert.*;

public class AmountTest {
	
	@Test
	public void whenPassOneDigitAsFractionPart_thenDigitIsTensOfCents() {
		Amount amount = new Amount(2, 1);
		
		assertEquals(210, amount.getValue());
	}

	@Test
	public void whenPassTwoDigitsAsFractionPart_thenDigitsAreTheCents() {
		Amount amount = new Amount(2, 10);
		
		assertEquals(210, amount.getValue());
	}
}
