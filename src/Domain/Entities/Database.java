package Domain.Entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import Commons.Security.SecurityHelper;

public class Database implements Serializable {
	private static Database instance;

	public ArrayList<User> users;
	public ArrayList<Subforum> subforums;
	public ArrayList<Topic> topics;

	private Database() {
		users = new ArrayList<User>();
		subforums = new ArrayList<Subforum>();
		topics = new ArrayList<Topic>();

		User temp = new User();
		temp.id = UUID.randomUUID().toString();
		temp.email = "squarepantsivan@gmail.com";
		temp.firstName = "Ivan";
		temp.lastName = "Kockarevic";
		temp.username = "kotzkaloney";
		temp.password = SecurityHelper.getHash("0643843672");
		temp.telephoneNo = "+38121 896 093";
		temp.dateRegistered = new Date();
		temp.likedComments = new ArrayList<Comment>();
		temp.dislikedComments = new ArrayList<Comment>();
		temp.likedTopics = new ArrayList<Topic>();
		temp.dislikedTopics = new ArrayList<Topic>();
		temp.role = 2;

		Subforum sf = new Subforum();
		sf.id = UUID.randomUUID().toString();
		sf.name = "Super duper owl forum";
		sf.description = "A forum about night owls.";
		sf.iconPath = "data:image/png;base64,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";
		sf.moderators = new ArrayList<User>();
		sf.moderators.add(temp);
		sf.responsibleModerator = temp;
		sf.rules = new ArrayList<String>();
		sf.rules.add("Please don't feed the owls.");
		sf.topics = new ArrayList<Topic>();
		temp.followedSubforums = new ArrayList<Subforum>();
		temp.followedSubforums.add(sf);

		Topic t = new Topic();
		t.id = UUID.randomUUID().toString();
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
		sf.topics.add(t);
		topics.add(t);
		temp.likedTopics.add(t);
		temp.dislikedTopics.add(t);

		Comment c = new Comment();
		c.id = UUID.randomUUID().toString();
		c.author = temp;
		c.comments = new ArrayList<>();
		c.content = "Man, who in the name of hell knows that?";
		c.dateCreated = new Date();
		c.isChanged = true;
		c.parentComment = null;
		c.topic = t;
		c.userDislikes = new ArrayList<User>();
		c.userLikes = new ArrayList<User>();
		t.comments.add(c);

		Comment c1 = new Comment();
		c1.id = UUID.randomUUID().toString();
		c1.author = temp;
		c1.comments = new ArrayList<>();
		c1.content = "Get the F of my yard!";
		c1.dateCreated = new Date();
		c1.isChanged = false;
		c1.parentComment = null;
		c1.topic = t;
		c1.userDislikes = new ArrayList<User>();
		c1.userLikes = new ArrayList<User>();
		t.comments.add(c);

		temp.savedComments = new ArrayList<Comment>();
		temp.savedComments.add(c);
		temp.likedComments.add(c);
		temp.dislikedComments.add(c);

		Message msg = new Message();
		msg.id = UUID.randomUUID().toString();
		msg.sender = temp;
		msg.recipient = temp;
		msg.content = "Neka poruka jebo te sunce!";
		msg.isSeen = false;
		temp.messages = new ArrayList<Message>();
		temp.messages.add(msg);

		msg = new Message();
		msg.id = UUID.randomUUID().toString();
		msg.sender = temp;
		msg.recipient = temp;
		msg.content = "Jos neka jebo te!";
		msg.isSeen = true;
		temp.messages.add(msg);

		msg = new Message();
		msg.id = UUID.randomUUID().toString();
		msg.sender = temp;
		msg.recipient = temp;
		msg.content = "I jos jedna!";
		msg.isSeen = true;
		temp.messages.add(msg);

		subforums.add(sf);
		users.add(temp);
	}

	public static Database getInstance() {
		if (instance == null)
			instance = new Database();

		return instance;
	}
}
