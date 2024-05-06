package com.facebook.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

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

}
