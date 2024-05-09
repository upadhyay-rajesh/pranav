package com.facebook.view;

import java.util.Scanner;

import com.facebook.controller.FacebookController;
import com.facebook.controller.FacebookControllerInterface;

public class FacebookView {
	
//	final int s=9;// 
	
	//void add() {
	//	s=8;
	//}
	
	//final class can not be inherited
	//final variable can not be change
	//final method can not be override
	
	//final void sub(int i,int j) {
		
	//}

	public static void main(String[] args) {
		String a="y";
		while(a.equals("y")) {
		System.out.println("****************Menu**********");
		System.out.println("press 1 to create profile");
		System.out.println("press 2 to view profile");
		System.out.println("press 3 to delete profile");
		System.out.println("press 4 to view all profile");//
		System.out.println("press 5 to run static method");//
		
		Scanner sc=new Scanner(System.in); //scanner is used to read value from console/user
		int choice=sc.nextInt();
		
		FacebookControllerInterface fc=new FacebookController();//
		
		switch(choice) {
		case 1 : fc.createProfile();
			break;
		case 2 : fc.viewProfile();
			break;
		case 3 : fc.deleteProfile();
			break;
		case 4 : fc.viewAllProfile();
			break;
		case 5: FacebookController.display();
			break;
			default : System.out.println("wrong choice");
		}
		System.out.println("do you want to continue press y/n");
		a=sc.next();
		}

	}

}















