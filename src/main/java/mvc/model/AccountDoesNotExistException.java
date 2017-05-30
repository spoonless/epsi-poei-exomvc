package mvc.model;

import javax.ejb.ApplicationException;

@ApplicationException(rollback=true)
public class AccountDoesNotExistException extends Exception {

	private static final long serialVersionUID = 1L;

}
