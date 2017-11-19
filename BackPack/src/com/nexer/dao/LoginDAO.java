package com.nexer.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.nexer.bo.LoginBO;
import com.nexer.dto.LoginDTO;
import com.nexer.utils.Constants;


public class LoginDAO {

	// jdbc procedure call string
//	public static final String AUTHENTICATION_CALL = "{call BACKPACK_LOGIN(?,?,?,?,?,?)}";
	
	public static final String LOGIN_QUERY = Constants.NEXER_USERS_TABLE;
	

	public LoginBO getStatus(LoginDTO ldto) throws ClassNotFoundException, InstantiationException,
			IllegalAccessException, SQLException, NamingException {

		// initializing required params
		
		Connection con = null;
		InitialContext ic = null;
		DataSource ds = null;
		PreparedStatement ps = null;
		LoginBO bo = null;
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","surya");
		String mPhoneNumber = ldto.getmPhoneNumber();
	
		ps = con.prepareStatement(LOGIN_QUERY);
		ps.setString(1, mPhoneNumber);
		ResultSet rs = ps.executeQuery();
		bo = new LoginBO();

		
		while (rs.next()) {
//			bo.setUserId(rs.getInt(3));
//			bo.setEmail(rs.getString(4));
//			bo.setFname(rs.getString(5));
//			bo.setResult(rs.getString(6));
		}
		

		// returning bo to service
		return bo;
	}

}
