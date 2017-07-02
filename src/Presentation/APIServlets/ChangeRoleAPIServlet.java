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
import Presentation.Viewmodels.ToastResponseModel;
import Presentation.Viewmodels.TopicServiceResponseModel;

@WebServlet("/ChangeRoleAPIServlet")
public class ChangeRoleAPIServlet extends HttpServlet {
	
	private Database db;

	public ChangeRoleAPIServlet() {
		db = Database.getInstance();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		int role = Integer.parseInt(request.getParameter("role"));
		
		User found = null;
		
		for(User u : db.users) {
			if(u.id.equals(userId))
				found = u;
		} 
		
		found.role = role;
		
		ToastResponseModel responseModel = new ToastResponseModel();
		responseModel.status = "OK";
		responseModel.message = "Role for user " + found.username + " has been changed!";
		
		String jsonContent = new SerializationHelper<ToastResponseModel>().serialize(responseModel);
		
		response.getWriter().write(jsonContent);
	}

}
