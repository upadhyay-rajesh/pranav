package com.facebook.service;

import com.facebook.dao.FacebookDAO;
import com.facebook.dao.FacebookDAOInterface;
import com.facebook.entity.FacebookUser;

public class FacebookService implements FacebookServiceInterface {

	public int createProfileService(FacebookUser fuser) {
		FacebookDAOInterface fd=new FacebookDAO();
		return fd.createProfileDAO(fuser);
	}

}
