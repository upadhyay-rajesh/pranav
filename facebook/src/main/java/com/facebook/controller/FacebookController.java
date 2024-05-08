package com.facebook.controller;

import java.util.List;
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
		
		//since above value controller want to transfer to service so it must use DTO(data transfer object) design pattern
		//which class object?  entity class i.e. FacebookUser
		
		FacebookUser fuser=new FacebookUser();
		fuser.setName(name);
		fuser.setPassword(password);
		fuser.setEmail(email);
		fuser.setAddress(address);
		
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
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter email to view profile");
		String email=sc.next();
		
		FacebookUser fuser=new FacebookUser();
		fuser.setEmail(email);
		
		FacebookServiceInterface fs=new FacebookService();
		FacebookUser ff=fs.viewProfileService(fuser);
		
		if(ff!=null) {
			System.out.println("your profile is ---->");
			System.out.println("Name is "+ff.getName());
			System.out.println("Password is "+ff.getPassword());
			System.out.println("Email is "+ff.getEmail());
			System.out.println("Address is "+ff.getAddress());
			
		}
	}

	public void deleteProfile() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter email to delete profile");
		String email=sc.next();
		
		FacebookUser fuser=new FacebookUser();
		fuser.setEmail(email);
		
		FacebookServiceInterface fs=new FacebookService();
		int ff=fs.deleteProfileService(fuser);
		
		if(ff>0) {
			System.out.println("profile deleted");
		}
		

	}

	public void viewAllProfile() {
		FacebookServiceInterface fs=new FacebookService();
		List<FacebookUser> ll=   fs.viewAllProfileService();
		
		System.out.println(ll.size()+"  record found");
		
		for(FacebookUser ff:ll) {
			System.out.println("********************************");
			System.out.println("your profile is ---->");
			System.out.println("Name is "+ff.getName());
			System.out.println("Password is "+ff.getPassword());
			System.out.println("Email is "+ff.getEmail());
			System.out.println("Address is "+ff.getAddress());
		}

	}

}








