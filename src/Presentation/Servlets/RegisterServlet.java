package Presentation.Servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Domain.Entities.Comment;
import Domain.Entities.Database;
import Domain.Entities.Subforum;
import Domain.Entities.Topic;
import Domain.Entities.User;

@SuppressWarnings("serial")
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

	private Database db;

	public RegisterServlet() {
		db = Database.getInstance();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Reset JSP validation indicators.
		ServletContext servletContext = request.getServletContext();
		servletContext.setAttribute("RegisterValidationMessage", null);
		servletContext.setAttribute("RedirectedFrom", null);

		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String telephoneNo = request.getParameter("telephoneNo");

		String validationMessage = validateData(firstName, lastName, username, password, email);

		if (validationMessage == null) {
			// Everything is valid - proceed with authentication.

			User found = null;
			for (User u : db.users) {
				if (u.username.equals(username)) {
					found = u;
				}
			}

			if (found == null) {

				// Alles gut - create the user.
				found = new User();
				found.firstName = firstName;
				found.lastName = lastName;
				found.username = username;
				found.password = password;
				found.role = 1;
				found.telephoneNo = telephoneNo;
				found.email = email;
				found.dateRegistered = new Date();
				found.followedSubforums = new ArrayList<Subforum>();
				found.savedTopics = new ArrayList<Topic>();
				found.savedComments = new ArrayList<Comment>();

				db.users.add(found);

				request.getSession().setAttribute("CurrentUser", found);
				request.getRequestDispatcher("index.jsp").forward(request, response);
				return;
			} else {
				validationMessage = "Username already taken!";
			}
		}

		// There was an error. Put it into servlet context and return page.
		servletContext.setAttribute("RegisterValidationMessage", validationMessage);
		servletContext.setAttribute("RedirectedFrom", "REGISTER");

		request.getRequestDispatcher("account.jsp").forward(request, response);
		return;
	}

	private String validateData(String firstName, String lastName, String username, String password, String email) {
		String validationMessage = null;

		if (firstName == null || firstName.equals("")) {
			validationMessage = "First name is required!";
		} else if (lastName == null || lastName.equals("")) {
			validationMessage = "Last name is required!";
		} else if (username == null || username.equals("")) {
			validationMessage = "Username is required!";
		} else if (password == null || password.equals("")) {
			validationMessage = "Password is required!";
		} else if (email == null || email.equals("")) {
			validationMessage = "E-mail is required!";
		}

		return validationMessage;
	}
}
