package Presentation.APIServlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Commons.Serialization.SerializationHelper;
import Domain.Entities.Database;
import Domain.Entities.User;
import Presentation.Viewmodels.ProfileServiceResponseModel;
import Presentation.Viewmodels.SidebarServiceResponseModel;

@WebServlet("/CurrentUserAPIServlet")
public class CurrentUserAPIServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User responseModel = (User)request.getSession().getAttribute("CurrentUser");
		
		if(responseModel != null) {
			String jsonContent = new SerializationHelper<User>().serialize(responseModel);

			response.getWriter().write(jsonContent);
		}
	}
}























