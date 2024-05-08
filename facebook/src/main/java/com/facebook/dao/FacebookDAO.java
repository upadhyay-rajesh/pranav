package com.facebook.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.facebook.entity.FacebookUser;

public class FacebookDAO implements FacebookDAOInterface {

	public int createProfileDAO(FacebookUser fuser) {
		int i=0;
		try {
			//step 1 load driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//step 2 create connection
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","rajesh");
			//step3 create query
			PreparedStatement ps=con.prepareStatement("insert into facebookpranav values(?,?,?,?)");
			ps.setString(1, fuser.getName());
			ps.setString(2, fuser.getPassword());
			ps.setString(3, fuser.getEmail());
			ps.setString(4, fuser.getAddress());
			
			//step 4 execute query
			i=ps.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	public FacebookUser viewProfileDAO(FacebookUser fuser) {
		FacebookUser ff=null;
		try {
			//step 1 load driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//step 2 create connection
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","rajesh");
			//step3 create query
			PreparedStatement ps=con.prepareStatement("select * from facebookpranav where email=?");
			
			ps.setString(1, fuser.getEmail());
			
			
			//step 4 execute query
			ResultSet res =ps.executeQuery();
			
			if(res.next()) {
				ff=new FacebookUser();
				ff.setName(res.getString(1));
				ff.setPassword(res.getString(2));
				ff.setEmail(res.getString(3));
				ff.setAddress(res.getString(4));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return ff;
	}

	public List<FacebookUser> viewAllProfileDAO() {
		List<FacebookUser> ll=new ArrayList<FacebookUser>();
		try {
			//step 1 load driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//step 2 create connection
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","rajesh");
			//step3 create query
			PreparedStatement ps=con.prepareStatement("select * from facebookpranav");
			
				
			//step 4 execute query
			ResultSet res =ps.executeQuery();
			
			while(res.next()) {
				FacebookUser ff=new FacebookUser();
				ff.setName(res.getString(1));
				ff.setPassword(res.getString(2));
				ff.setEmail(res.getString(3));
				ff.setAddress(res.getString(4));
				
				ll.add(ff);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return ll;
	}

	public int deleteProfileDAO(FacebookUser fuser) {
		int i=0;
		try {
			//step 1 load driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//step 2 create connection
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","rajesh");
			//step3 create query
			PreparedStatement ps=con.prepareStatement("delete from facebookpranav where email=?");
			
			ps.setString(1, fuser.getEmail());
			
			
			//step 4 execute query
			i=ps.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return i;
	}

}





















