package mvc;

import java.util.ArrayList;
import java.util.List;

public class AccountManager {
	
	private static final AccountManager singleton = new AccountManager();
	private List<Account> accounts = new ArrayList<>();
	
	private AccountManager() {}
	
	public synchronized Account save(String accountName, String accountNumber, Amount amount) throws AccountAlreadyExistingException {
		for (Account account : accounts) {
			if (account.getNumber().equals(accountNumber)) {
				throw new AccountAlreadyExistingException();
			}
		}
		
		Account newAccount = new Account(accountName, accountNumber, amount);
		accounts.add(newAccount);
		return newAccount;
	}
	
	public static AccountManager getSingleton() {
		return singleton;
	}

}
