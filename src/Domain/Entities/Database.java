package Domain.Entities;

import java.util.ArrayList;
import java.util.Date;

import Commons.Security.SecurityHelper;

public class Database {
	private static Database instance;
	
	public ArrayList<User> users;
	
	private Database() {
		users = new ArrayList<User>();
		
		User temp = new User();
		temp.email = "squarepantsivan@gmail.com";
		temp.firstName = "Ivan";
		temp.lastName = "Kockarevic";
		temp.username = "kotzkaloney";
		temp.password = SecurityHelper.getHash("0643843672");
		temp.telephoneNo = "+38121 896 093";
		temp.dateRegistered = new Date();
		
		Subforum sf = new Subforum();
		sf.name = "Super duper owl forum";
		sf.description = "A forum about night owls.";
		sf.iconPath = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRCsOeE64yZqIvE87PjBPgzaltiKKLRct1FcPWr9TqsavalLCj7MUQlBBE";
		sf.moderators = new ArrayList<User>();
		sf.moderators.add(temp);
		sf.responsibleModerator = temp;
		sf.rules = new ArrayList<String>();
		sf.rules.add("Please don't feed the owls.");
		temp.followedSubforums = new ArrayList<Subforum>();
		temp.followedSubforums.add(sf);
		
		Topic t = new Topic();
		t.author = temp;
		t.comments = new ArrayList<Comment>();
		t.content = "I have a question - How to catch a night owl?";
		t.dateCreated = new Date();
		t.name = "How to catch a night owl?";
		t.subforum = sf;
		t.type = 2;
		t.userDislikes = new ArrayList<User>();
		t.userLikes = new ArrayList<User>();
		temp.savedTopics = new ArrayList<Topic>();
		temp.savedTopics.add(t);

		Comment c = new Comment();
		c.author = temp;
		c.comments = new ArrayList<>();
		c.content = "Man, who in the name of hell knows that?";
		c.dateCreated = new Date();
		c.isChanged = true;
		c.parentComment = null;
		c.topic = t;
		c.userDislikes = new ArrayList<User>();
		c.userLikes = new ArrayList<User>();
		temp.savedComments = new ArrayList<Comment>();
		temp.savedComments.add(c);
		
		users.add(temp);
	}
	
	public static Database getInstance() {
		if(instance == null)
			instance = new Database();
		
		return instance;
	}
}
