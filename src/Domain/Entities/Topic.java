package Domain.Entities;

import java.util.ArrayList;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Topic {
	public String id;
	public Subforum subforum;
	public String name;
	public int type;
	public User author;
	public String content;
	public String imagePath;
	public String linkUrl;
	public String linkContent;
	public Date dateCreated;
	
	@JsonIgnore
	public ArrayList<Comment> comments;
	@JsonIgnore
	public ArrayList<User> userLikes;
	@JsonIgnore
	public ArrayList<User> userDislikes;
}
