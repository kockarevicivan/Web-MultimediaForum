package Presentation.Viewmodels;

import java.io.Serializable;
import java.util.ArrayList;

import Domain.Entities.User;

public class AllUsersServiceResponseModel implements Serializable {
	public ArrayList<User> users;
}
