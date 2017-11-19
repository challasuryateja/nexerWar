package com.nexer.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;

import com.nexer.utils.Constants;
import com.teja.bo.RegisterBO;

public class CheckUserNameDao {
	
	
	
	

	public int checkUserName(String m_phone_number) throws SQLException, NamingException, ClassNotFoundException {
		System.out.println("test  " + m_phone_number);
		Connection con = null;
		PreparedStatement pst = null;		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","surya");
		
		int result=0;
		System.out.println(Constants.CHECK_USER_NAME + m_phone_number);
		pst = con.prepareStatement(Constants.CHECK_USER_NAME);
		pst.setString(1,m_phone_number);
		result = 0;
	    ResultSet  rs = pst.executeQuery();
	      if (rs.next()) {
	    	  result = rs.getInt(1);
	        System.out.println("numberOfRows= " + result);
	      } else {
	        System.out.println("error: could not get the record counts");
	      }
		System.out.println(result+"tes");
		return result;

	}

}
