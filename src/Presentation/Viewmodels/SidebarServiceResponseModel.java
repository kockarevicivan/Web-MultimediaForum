package Presentation.Viewmodels;

import java.io.Serializable;
import java.util.ArrayList;

import Domain.Entities.Topic;

public class SidebarServiceResponseModel implements Serializable {
	public ArrayList<LikeDislikeViewModel> likesDislikes;
	public ArrayList<Topic> recommendedTopics;
}
