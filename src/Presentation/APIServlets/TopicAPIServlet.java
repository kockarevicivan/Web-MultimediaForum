package Presentation.APIServlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Commons.Serialization.SerializationHelper;
import Domain.Entities.Database;
import Domain.Entities.Topic;
import Presentation.Viewmodels.HomeServiceResponseModel;
import Presentation.Viewmodels.TopicServiceResponseModel;

@WebServlet("/TopicAPIServlet")
public class TopicAPIServlet extends HttpServlet {

	private Database db;

	public TopicAPIServlet() {
		db = Database.getInstance();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String topicId = ((String)request.getParameter("topicId")).replace(' ', '-');
		
		Topic found = null;
		
		for(Topic t : db.topics) {
			
			if(t.id.equals(topicId)) {
				found = t;
			}	
		}
		
		TopicServiceResponseModel responseModel = new TopicServiceResponseModel();
		responseModel.author = found.author.username;
		responseModel.comments = found.comments;
		responseModel.dateCreated = found.dateCreated;
		responseModel.subforum = found.subforum;
		responseModel.topicName = found.name;
		responseModel.topicContent = found.content;
		
		String jsonContent = new SerializationHelper<TopicServiceResponseModel>().serialize(responseModel);
		
		response.getWriter().write(jsonContent);
	}
}






