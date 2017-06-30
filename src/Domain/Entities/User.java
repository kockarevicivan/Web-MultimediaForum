package Domain.Entities;

import java.util.ArrayList;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class User {
	public String id;
	public String username;
	@JsonIgnore
	public String password;
	public String firstName;
	public String lastName;
	public int role;
	public String telephoneNo;
	public String email;
	public Date dateRegistered;
	
	@JsonIgnore
	public ArrayList<Subforum> followedSubforums;
	@JsonIgnore
	public ArrayList<Topic> savedTopics;
	@JsonIgnore
	public ArrayList<Comment> savedComments;
	@JsonIgnore
	public ArrayList<Message> messages;
	@JsonIgnore
	public ArrayList<Topic> likedTopics;
	@JsonIgnore
	public ArrayList<Topic> dislikedTopics;
	@JsonIgnore
	public ArrayList<Comment> likedComments;
	@JsonIgnore
	public ArrayList<Comment> dislikedComments;
}
