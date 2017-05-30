package mvc.model;

import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

@Singleton
public class AccountManager {
	
	@PersistenceContext(unitName="accountPersistenceUnit")
	private EntityManager entityManager;
	
	@Lock(LockType.WRITE)
	public Account save(String accountName, String accountNumber, Amount amount) throws AccountAlreadyExistingException {
		
		try {
			getByNumber(accountNumber);
			throw new AccountAlreadyExistingException();
		} catch (AccountDoesNotExistException e) {
			Account newAccount = new Account(accountName, accountNumber, amount);
			entityManager.persist(newAccount);
			return newAccount;
		}
	}
	
	@Lock(LockType.READ)
	public Account getByNumber(String accountNumber) throws AccountDoesNotExistException {
		try {
			return entityManager.createQuery("select a from Account a where a.number = :number", Account.class)
					.setParameter("number", accountNumber)
					.getSingleResult();
		} catch (NoResultException e) {
			throw new AccountDoesNotExistException();
		}
	}
}
