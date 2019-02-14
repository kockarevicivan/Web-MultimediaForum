package Presentation.Viewmodels;

import java.io.Serializable;
import java.util.ArrayList;

import Domain.Entities.Subforum;
import Domain.Entities.Topic;
import Domain.Entities.User;

public class SearchServiceResponseModel implements Serializable{
	public ArrayList<Subforum> subforums;
	public ArrayList<Topic> topics;
	public ArrayList<User> users;
}
