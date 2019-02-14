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

@WebServlet("/AllSubforumsAPIServlet")
public class AllSubforumsAPIServlet extends HttpServlet {
	private Database db;

	public AllSubforumsAPIServlet() {
		db = Database.getInstance();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		AllSubforumsServiceResponseModel responseModel = new AllSubforumsServiceResponseModel();
		responseModel.subforums = db.subforums;

		String jsonContent = new SerializationHelper<AllSubforumsServiceResponseModel>().serialize(responseModel);

		response.getWriter().write(jsonContent);
	}
}
