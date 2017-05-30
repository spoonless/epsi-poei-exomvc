package mvc.model;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;

@Singleton
public class AccountManager {
	private final List<Account> accounts = new ArrayList<>();
	
	@Lock(LockType.WRITE)
	public Account save(String accountName, String accountNumber, Amount amount) throws AccountAlreadyExistingException {
		for (Account account : accounts) {
			if (account.getNumber().equals(accountNumber)) {
				throw new AccountAlreadyExistingException();
			}
		}
		
		Account newAccount = new Account(accountName, accountNumber, amount);
		accounts.add(newAccount);
		return newAccount;
	}
	
	@Lock(LockType.READ)
	public Account getByNumber(String accountNumber) throws AccountDoesNotExistException {
		for (Account account : accounts) {
			if (account.getNumber().equals(accountNumber)) {
				return account;
			}
		}
		throw new AccountDoesNotExistException();
	}
}
