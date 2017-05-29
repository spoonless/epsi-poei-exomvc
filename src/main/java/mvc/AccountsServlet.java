package mvc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
		long accountBalance = accountBalanceInteger * 100 + accountBalanceFraction;
		Account account = new Account(req.getParameter("accountName"), 
									  req.getParameter("accountNumber"), 
									  accountBalance);
		
		List<Account> accounts = new ArrayList<>();
		accounts.add(account);

		req.setAttribute("account", account);
		getServletContext().getRequestDispatcher("/WEB-INF/jsp/account.jsp").forward(req, resp);
	}

}
