package mvc.web;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.model.Account;
import mvc.model.AccountDoesNotExistException;
import mvc.model.AccountManager;

@WebServlet("/account")
public class AccountServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@EJB
	private AccountManager accountManager;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Account account = this.accountManager.getByNumber(req.getParameter("accountNumber"));
			req.setAttribute("account", account);
			req.getRequestDispatcher("/WEB-INF/jsp/account.jsp").forward(req, resp);
		} catch (AccountDoesNotExistException e) {
			log("Account does not exist", e);
			resp.sendError(HttpServletResponse.SC_NOT_FOUND);
		}
	}

}

