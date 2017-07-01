package Presentation.APIServlets;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Commons.Serialization.SerializationHelper;
import Domain.Entities.Database;
import Domain.Entities.Message;
import Domain.Entities.User;
import Presentation.Viewmodels.NewMessageServiceResponseModel;
import Presentation.Viewmodels.ToastResponseModel;

@WebServlet("/NewMessageAPIServlet")
public class NewMessageAPIServlet extends HttpServlet {

	private Database db;

	public NewMessageAPIServlet() {
		db = Database.getInstance();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		NewMessageServiceResponseModel responseModel = new NewMessageServiceResponseModel();
		responseModel.users = db.users;

		String jsonContent = new SerializationHelper<NewMessageServiceResponseModel>().serialize(responseModel);

		response.getWriter().write(jsonContent);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		User sender = (User) request.getSession().getAttribute("CurrentUser");
		String recipientId = ((String) request.getParameter("recipientId")).replace(' ', '-');

		User recipient = null;
		for (User u : db.users) {
			if (u.id.equals(recipientId)) {
				recipient = u;
			}
		}

		Message newMessage = new Message();
		newMessage.content = (String) request.getParameter("message");
		newMessage.recipient = recipient;
		newMessage.sender = sender;
		newMessage.id = UUID.randomUUID().toString();
		newMessage.isSeen = false;
		
		recipient.messages.add(newMessage);///TODO move to manager method.
		
		ToastResponseModel responseModel = new ToastResponseModel();
		responseModel.status = "OK";
		responseModel.message = "Message sent!";
		
		String jsonContent = new SerializationHelper<ToastResponseModel>().serialize(responseModel);

		response.getWriter().write(jsonContent);
	}

}
