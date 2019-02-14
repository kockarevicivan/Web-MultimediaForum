package Presentation.APIServlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Commons.Serialization.SerializationHelper;
import Domain.Entities.Database;
import Presentation.Viewmodels.AllSubforumsServiceResponseModel;
import Presentation.Viewmodels.AllUsersServiceResponseModel;

@WebServlet("/AllUsersAPIServlet")
public class AllUsersAPIServlet extends HttpServlet {
	private Database db;

	public AllUsersAPIServlet() {
		db = Database.getInstance();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		AllUsersServiceResponseModel responseModel = new AllUsersServiceResponseModel();
		responseModel.users = db.users;

		String jsonContent = new SerializationHelper<AllUsersServiceResponseModel>().serialize(responseModel);

		response.getWriter().write(jsonContent);
	}
}
