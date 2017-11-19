package com.teja.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.NamingException;

import com.nexer.utils.Constants;
import com.teja.bo.RegisterBO;

public class CheckUserNameDao {

	public int checkUserName(String u_name) throws SQLException, NamingException, ClassNotFoundException {
		
		Connection con = null;
		PreparedStatement pst = null;		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","surya");
		
		pst = con.prepareStatement(Constants.CHECK_USER_NAME);
		pst.setString(1,u_name);
		int result = pst.executeUpdate();

		return result;

	}

}
