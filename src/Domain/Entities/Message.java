package Domain.Entities;

import java.io.Serializable;

public class Message implements Serializable {
	public String id;
	public String content;
	public boolean isSeen;
	public User sender;
	public User recipient;
}
