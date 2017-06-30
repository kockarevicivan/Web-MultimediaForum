package Domain.Entities;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Subforum {
	public String id;
	public String name;
	public String description;
	public String iconPath;
	public ArrayList<String> rules;
	
	@JsonIgnore
	public ArrayList<Topic> topics;
	@JsonIgnore
	public User responsibleModerator;
	@JsonIgnore
	public ArrayList<User> moderators;
}
