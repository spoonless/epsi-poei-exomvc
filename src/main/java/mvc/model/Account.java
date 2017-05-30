package mvc.model;

public class Account {

	private String name;
	private String number;
	private Amount balance;

	public Account(String name, String number, Amount amount) {
		this.name = name;
		this.number = number;
		this.balance = amount;
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
	
	public Amount getBalanceAmount() {
		return balance;
	}
}
