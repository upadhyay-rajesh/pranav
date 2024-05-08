package com.facebook.service;

import java.util.List;

import com.facebook.dao.FacebookDAO;
import com.facebook.dao.FacebookDAOInterface;
import com.facebook.entity.FacebookUser;

public class FacebookService implements FacebookServiceInterface {

	public int createProfileService(FacebookUser fuser) {
		FacebookDAOInterface fd=new FacebookDAO();
		return fd.createProfileDAO(fuser);
	}

	public FacebookUser viewProfileService(FacebookUser fuser) {
		FacebookDAOInterface fd=new FacebookDAO();
		return fd.viewProfileDAO(fuser);
	}

	public List<FacebookUser> viewAllProfileService() {
		FacebookDAOInterface fd=new FacebookDAO();
		return fd.viewAllProfileDAO();
	}

	public int deleteProfileService(FacebookUser fuser) {
		FacebookDAOInterface fd=new FacebookDAO();
		return fd.deleteProfileDAO(fuser);
	}

}
