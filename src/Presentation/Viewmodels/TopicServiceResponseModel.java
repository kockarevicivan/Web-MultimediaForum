package Presentation.Viewmodels;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import Domain.Entities.Comment;
import Domain.Entities.Subforum;

public class TopicServiceResponseModel implements Serializable {
	public Subforum subforum;
	public String topicName;
	public String topicContent;
	public String author;
	public Date dateCreated;
	public ArrayList<Comment> comments;
}
