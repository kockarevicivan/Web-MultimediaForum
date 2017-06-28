package Domain.Entities;

import java.util.ArrayList;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class User {
	public String username;
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
}
