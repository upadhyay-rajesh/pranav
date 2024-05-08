package com.facebook.service;

import java.util.List;

import com.facebook.entity.FacebookUser;

public interface FacebookServiceInterface {

	int createProfileService(FacebookUser fuser);

	FacebookUser viewProfileService(FacebookUser fuser);

	List<FacebookUser> viewAllProfileService();

	int deleteProfileService(FacebookUser fuser);

}
