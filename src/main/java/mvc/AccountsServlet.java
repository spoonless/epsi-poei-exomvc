package mvc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/accounts")
public class AccountsServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		long accountBalanceInteger = Long.valueOf(req.getParameter("accountBalanceInteger"));
		long accountBalanceFraction = Long.valueOf(req.getParameter("accountBalanceFraction"));
	
		Amount amount = new Amount(accountBalanceInteger, accountBalanceFraction);
		Account account;
		try {
			account = AccountManager.getSingleton().save(req.getParameter("accountName"), req.getParameter("accountNumber"), amount);
			req.setAttribute("account", account);
			getServletContext().getRequestDispatcher("/WEB-INF/jsp/account.jsp").forward(req, resp);
		} catch (AccountAlreadyExistingException e) {
			req.setAttribute("error", "Le compte existe déjà");
			getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
		}
	}


}
