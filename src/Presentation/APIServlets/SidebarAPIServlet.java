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
import Domain.Entities.Topic;
import Domain.Entities.User;
import Presentation.Viewmodels.LikeDislikeViewModel;
import Presentation.Viewmodels.SidebarServiceResponseModel;


@WebServlet("/SidebarAPIServlet")
public class SidebarAPIServlet extends HttpServlet {
	private Database db;

	public SidebarAPIServlet() {
		db = Database.getInstance();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		User current = (User)request.getSession().getAttribute("CurrentUser");
		
		ArrayList<LikeDislikeViewModel> likesDislikes = new ArrayList<LikeDislikeViewModel>();
		
		for(Topic t : current.likedTopics) {
			LikeDislikeViewModel temp = new LikeDislikeViewModel();
			temp.entityName = t.name;
			temp.isLike = true;
			likesDislikes.add(temp);
		}
		
		for(Topic t : current.dislikedTopics) {
			LikeDislikeViewModel temp = new LikeDislikeViewModel();
			temp.entityName = t.name;
			temp.isLike = false;
			likesDislikes.add(temp);
		}
		
		for(Comment c : current.likedComments) {
			LikeDislikeViewModel temp = new LikeDislikeViewModel();
			temp.entityName = c.content;
			temp.isLike = true;
			likesDislikes.add(temp);
		}
		
		for(Comment c : current.dislikedComments) {
			LikeDislikeViewModel temp = new LikeDislikeViewModel();
			temp.entityName = c.content;
			temp.isLike = false;
			likesDislikes.add(temp);
		}
		
		SidebarServiceResponseModel responseModel = new SidebarServiceResponseModel();
		responseModel.recommendedTopics = db.topics;
		responseModel.likesDislikes = likesDislikes;

		String jsonContent = new SerializationHelper<SidebarServiceResponseModel>().serialize(responseModel);

		response.getWriter().write(jsonContent);
	}
}
