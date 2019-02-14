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

/**
 * Servlet implementation class ProfileAPIServlet
 */
@WebServlet("/ProfileAPIServlet")
public class ProfileAPIServlet extends HttpServlet {
	private Database db;
	
    public ProfileAPIServlet() {
        db = Database.getInstance();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User current = (User)request.getSession().getAttribute("CurrentUser");
		
		ProfileServiceResponseModel responseModel = new ProfileServiceResponseModel();
		responseModel.username = current.username;
		responseModel.firstName = current.firstName;
		responseModel.lastName = current.lastName;
		responseModel.telephoneNo = current.telephoneNo;
		responseModel.email = current.email;
		
		String jsonContent = new SerializationHelper<ProfileServiceResponseModel>().serialize(responseModel);

		response.getWriter().write(jsonContent);
	}
}























