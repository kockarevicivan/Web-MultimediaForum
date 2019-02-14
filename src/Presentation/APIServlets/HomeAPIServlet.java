package Presentation.APIServlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Commons.Serialization.SerializationHelper;
import Domain.Entities.Comment;
import Domain.Entities.Database;
import Domain.Entities.Subforum;
import Domain.Entities.Topic;
import Domain.Entities.User;
import Presentation.Viewmodels.HomeServiceResponseModel;

/**
 * Servlet implementation class HomeAPIServlet
 */
@SuppressWarnings("serial")
@WebServlet("/HomeAPIServlet")
public class HomeAPIServlet extends HttpServlet {

	private Database db;

	public HomeAPIServlet() {
		db = Database.getInstance();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User current = (User)request.getSession().getAttribute("CurrentUser");
		
		HomeServiceResponseModel responseModel = new HomeServiceResponseModel();
		responseModel.followedSubforums = current.followedSubforums;
		responseModel.savedTopics = current.savedTopics;
		responseModel.savedComments = current.savedComments;
		responseModel.messages = current.messages;
		responseModel.topicsFromLikedForums = new ArrayList<Topic>();
		
		for(Subforum s : current.followedSubforums) {
			for(Topic t : s.topics) {
				responseModel.topicsFromLikedForums.add(t);
			}
		}
		
		String jsonContent = new SerializationHelper<HomeServiceResponseModel>().serialize(responseModel);

		response.getWriter().write(jsonContent);
	}
}
