package mvc.model;

import javax.ejb.ApplicationException;

@ApplicationException(rollback=true)
public class AccountAlreadyExistingException extends Exception {

	private static final long serialVersionUID = 1L;

}
