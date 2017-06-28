package Domain.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Message {
	public String content;
	public boolean isSeen;
	
	@JsonIgnore
	public User sender;
	@JsonIgnore
	public User recipient;
}
