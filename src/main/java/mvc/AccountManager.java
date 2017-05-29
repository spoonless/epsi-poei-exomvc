package mvc;

import java.util.ArrayList;
import java.util.List;

public class AccountManager {
	
	private static final AccountManager singleton = new AccountManager();
	private List<Account> accounts = new ArrayList<>();
	
	private AccountManager() {}
	
	public synchronized Account save(String accountName, String accountNumber, Amount amount) {
		Account account = new Account(accountName, accountNumber, amount);
		accounts.add(account);
		return account;
	}
	
	public static AccountManager getSingleton() {
		return singleton;
	}

}
