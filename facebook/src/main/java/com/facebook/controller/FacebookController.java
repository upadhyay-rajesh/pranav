package com.facebook.controller;

import java.util.Scanner;

import com.facebook.entity.FacebookUser;
import com.facebook.service.FacebookService;
import com.facebook.service.FacebookServiceInterface;

public class FacebookController implements FacebookControllerInterface {

	public void createProfile() {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter name");
		String name=sc.next();
		
		System.out.println("Enter password");
		String password=sc.next();
		
		System.out.println("Enter email");
		String email=sc.next();
		
		System.out.println("Enter address");
		String address=sc.next();
		
		FacebookUser fuser=new FacebookUser();
		fuser.setName(name);
		fuser.setPassword(password);
		fuser.setEmail(email);
		fuser.setAddress(address);
		
		
		
		System.out.println("your data is "+name+" "+password+" "+email+" "+address);
		
		FacebookServiceInterface fs=new FacebookService();
		int i=fs.createProfileService(fuser);
		
		if(i>0) {
			System.out.println("profile created");
		}
		else {
			System.out.println("could not create profile");
		}

	}

	public void viewProfile() {
		// TODO Auto-generated method stub

	}

	public void deleteProfile() {
		// TODO Auto-generated method stub

	}

	public void viewAllProfile() {
		// TODO Auto-generated method stub

	}

}
