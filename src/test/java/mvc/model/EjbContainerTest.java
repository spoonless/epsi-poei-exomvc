package mvc.model;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.NamingException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

public abstract class EjbContainerTest {

	private static EJBContainer container;
	
	@BeforeClass
	public static void start() throws NamingException {
		container = EJBContainer.createEJBContainer();
	}

	@AfterClass
	public static void shutdown() {
		if (container != null) {
			container.close();
		}
	}

	@Before
	public void inject() throws NamingException {
		container.getContext().bind("inject", this);
	}

	@After
	public void reset() throws NamingException {
		container.getContext().unbind("inject");
	}

}
