package mvc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/account")
public class AccountServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Account account;
		try {
			account = AccountManager.getSingleton().getByNumber(req.getParameter("accountNumber"));
			req.setAttribute("account", account);
			req.getRequestDispatcher("/WEB-INF/jsp/account.jsp").forward(req, resp);
		} catch (AccountDoesNotExistException e) {
			log("Account does not exist", e);
			resp.sendError(HttpServletResponse.SC_NOT_FOUND);
		}
	}

}
