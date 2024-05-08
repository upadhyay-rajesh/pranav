package com.facebook.dao;

import java.util.List;

import com.facebook.entity.FacebookUser;

public interface FacebookDAOInterface {

	int createProfileDAO(FacebookUser fuser);

	FacebookUser viewProfileDAO(FacebookUser fuser);

	List<FacebookUser> viewAllProfileDAO();

	int deleteProfileDAO(FacebookUser fuser);

}
