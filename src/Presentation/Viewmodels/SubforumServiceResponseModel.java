package Presentation.Viewmodels;

import java.io.Serializable;
import java.util.ArrayList;

import Domain.Entities.Topic;

public class SubforumServiceResponseModel implements Serializable {
	public String subforumName;
	public ArrayList<Topic> topics;
}
