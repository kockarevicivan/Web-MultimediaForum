package Presentation.Viewmodels;

import java.io.Serializable;
import java.util.ArrayList;

import Domain.Entities.Comment;
import Domain.Entities.Subforum;
import Domain.Entities.Topic;


public class HomeServiceResponseModel implements Serializable {
	public ArrayList<Subforum> followedSubforums;
	public ArrayList<Topic> savedTopics;
	public ArrayList<Comment> savedComments;
}
