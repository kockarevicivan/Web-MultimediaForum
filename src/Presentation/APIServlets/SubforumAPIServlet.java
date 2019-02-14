package Presentation.APIServlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Commons.Serialization.SerializationHelper;
import Domain.Entities.Database;
import Domain.Entities.Subforum;
import Presentation.Viewmodels.SubforumServiceResponseModel;

@SuppressWarnings("serial")
@WebServlet("/SubforumAPIServlet")
public class SubforumAPIServlet extends HttpServlet {
	private Database db;

	public SubforumAPIServlet() {
		db = Database.getInstance();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String subforumId = ((String) request.getParameter("subforumId")).replace(' ', '-');

		Subforum found = null;

		for (Subforum s : db.subforums) {
			if (s.id.equals(subforumId)) {
				found = s;
			}
		}

		SubforumServiceResponseModel responseModel = new SubforumServiceResponseModel();
		responseModel.subforumName = found.name;
		responseModel.topics = found.topics;

		String jsonContent = new SerializationHelper<SubforumServiceResponseModel>().serialize(responseModel);

		response.getWriter().write(jsonContent);
	}
}
