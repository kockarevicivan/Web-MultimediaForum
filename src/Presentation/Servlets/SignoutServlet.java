package Presentation.Servlets;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SignoutServlet")
public class SignoutServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ServletContext servletContext = request.getServletContext();
		servletContext.setAttribute("LoginValidationMessage", null);
		servletContext.setAttribute("RedirectedFrom", null);

		request.getSession().setAttribute("CurrentUser", null);

		request.getRequestDispatcher("account.jsp").forward(request, response);
	}
}
