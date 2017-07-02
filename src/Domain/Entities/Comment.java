package Domain.Entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Comment implements Serializable {

	public Comment() {
		userLikes = new ArrayList<User>();
		userDislikes = new ArrayList<User>();
		comments = new ArrayList<Comment>();
	}

	public String id;
	public Topic topic;
	public User author;
	public Date dateCreated;
	public Comment parentComment;

	public ArrayList<Comment> comments;
	public String content;
	public boolean isChanged;

	@JsonIgnore
	public ArrayList<User> userLikes;
	@JsonIgnore
	public ArrayList<User> userDislikes;
}