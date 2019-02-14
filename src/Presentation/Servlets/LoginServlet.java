package Presentation.Servlets;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Commons.Security.SecurityHelper;
import Domain.Entities.Database;
import Domain.Entities.User;

@SuppressWarnings("serial")
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	private Database db;

	public LoginServlet() {
		db = Database.getInstance();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ServletContext servletContext = request.getServletContext(); 
		servletContext.setAttribute("LoginValidationMessage", null);
		servletContext.setAttribute("RedirectedFrom", null);

		User found = (User)request.getSession().getAttribute("CurrentUser");
		///TODO make checks if user is loggedIn.
		
		if(found == null) {
			request.getRequestDispatcher("account.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Reset JSP validation indicators.
		ServletContext servletContext = request.getServletContext();
		servletContext.setAttribute("LoginValidationMessage", null);
		servletContext.setAttribute("RedirectedFrom", null);

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		boolean rememberMe = request.getParameter("rememberMe") != null;

		String validationMessage = validateData(username, password);

		if (validationMessage == null) {
			// Everything is valid - proceed with authentication.

			User found = null;
			for (User u : db.users) {
				if (u.username.equals(username)) {
					found = u;
				}
			}

			if (found != null) {
				if (SecurityHelper.getHash(password).equals(found.password)) {
					// User is valid.
					request.getSession().setAttribute("CurrentUser", found);

					request.getRequestDispatcher("index.jsp").forward(request, response);
					return;
				} else {
					validationMessage = "Password is incorrect!";
				}
			} else {
				validationMessage = "Username cannot be found!";
			}
		}

		// There was an error. Put it into servlet context and return page.
		servletContext.setAttribute("LoginValidationMessage", validationMessage);
		servletContext.setAttribute("RedirectedFrom", "LOGIN");

		request.getRequestDispatcher("account.jsp").forward(request, response);
	}

	private String validateData(String username, String password) {
		String validationMessage = null;

		if (username == null || username.equals("")) {
			validationMessage = "Username is required!";
		} else if (password == null || password.equals("")) {
			validationMessage = "Password is required!";
		}

		return validationMessage;
	}
}
