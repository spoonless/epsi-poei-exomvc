package mvc.model;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import javax.annotation.ManagedBean;
import javax.ejb.EJB;

import org.junit.Test;

@ManagedBean
public class AccountManagerTest extends EjbContainerTest {

	@EJB
	private AccountManager accountManager;
	
	@Test
	public void persistAccount() throws Exception {
		accountManager.save("my account", "account number", new Amount("20", "10"));
		
		Account account = accountManager.getByNumber("account number");
		
		assertThat(account.getName(), is("my account"));
		assertThat(account.getBalanceAmount().getValue(), is(2010L));
		assertThat(account.getNumber(), is("account number"));
	}

	@Test(expected=AccountAlreadyExistingException.class)
	public void cannotPersistAlreadyExistingAccount() throws Exception {
		tx.begin();
		em.persist(new Account("", "XXX", new Amount("0", "0")));
		tx.commit();
		
		accountManager.save("my account", "XXX", new Amount("20", "10"));
	}

	@Test(expected=AccountDoesNotExistException.class)
	public void cannotGetUnexistingAccount() throws Exception {
		accountManager.getByNumber("unknown account number");
	}
}
