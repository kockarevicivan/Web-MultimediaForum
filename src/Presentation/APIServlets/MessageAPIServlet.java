package Presentation.APIServlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Commons.Serialization.SerializationHelper;
import Domain.Entities.Database;
import Domain.Entities.Message;
import Domain.Entities.User;
import Presentation.Viewmodels.MessageServiceResponseModel;

/**
 * Servlet implementation class MessageAPIServlet
 */
@WebServlet("/MessageAPIServlet")
public class MessageAPIServlet extends HttpServlet {

	private Database db;

	public MessageAPIServlet() {
		db = Database.getInstance();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		User current = (User)request.getSession().getAttribute("CurrentUser");
		String messageId = ((String)request.getParameter("messageId")).replace(' ', '-');
		
		Message found = null;
		
		for(Message m : current.messages) {
			if(m.id.equals(messageId)) {
				found = m;
			}	
		}
		
		///TODO update found message!
		found.isSeen = true;
		
		MessageServiceResponseModel responseModel = new MessageServiceResponseModel();
		responseModel.message = found;
		
		String jsonContent = new SerializationHelper<MessageServiceResponseModel>().serialize(responseModel);
		
		response.getWriter().write(jsonContent);
	}
}
