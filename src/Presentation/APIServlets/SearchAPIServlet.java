package Presentation.APIServlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Commons.Serialization.SerializationHelper;
import Domain.Entities.Database;
import Domain.Entities.Subforum;
import Domain.Entities.Topic;
import Domain.Entities.User;
import Presentation.Viewmodels.HomeServiceResponseModel;
import Presentation.Viewmodels.SearchServiceResponseModel;

@SuppressWarnings("serial")
@WebServlet("/SearchAPIServlet")
public class SearchAPIServlet extends HttpServlet {
	
	private Database db;

	public SearchAPIServlet() {
		db = Database.getInstance();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String searchTerm = request.getParameter("searchTerm");
		
		ArrayList<Subforum> foundSubforums = new ArrayList<Subforum>();
		for(Subforum sf : db.subforums) {
			if(sf.name.contains(searchTerm) ||
			   sf.description.contains(searchTerm) ||
			   sf.responsibleModerator.username.contains(searchTerm)) {
				foundSubforums.add(sf);
			}
		}
		
		ArrayList<Topic> foundTopics = new ArrayList<Topic>();
		for(Topic t : db.topics) {
			if(t.name.contains(searchTerm) ||
			   t.content.contains(searchTerm) ||
			   t.author.username.contains(searchTerm) ||
			   t.subforum.name.contains(searchTerm)) {
				foundTopics.add(t);
			}
		}
		
		ArrayList<User> foundUsers = new ArrayList<User>();
		for(User u : db.users) {
			if(u.username.contains(searchTerm)) {
				foundUsers.add(u);
			}
		}
		
		SearchServiceResponseModel responseModel = new SearchServiceResponseModel();
		responseModel.subforums = foundSubforums;
		responseModel.topics = foundTopics;
		responseModel.users = foundUsers;
		
		String jsonContent = new SerializationHelper<SearchServiceResponseModel>().serialize(responseModel);

		response.getWriter().write(jsonContent);
	}
}
