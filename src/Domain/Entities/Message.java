package Domain.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Message {
	public String id;
	public String content;
	public boolean isSeen;
	public User sender;
	public User recipient;
}
