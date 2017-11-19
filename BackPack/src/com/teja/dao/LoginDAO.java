package com.teja.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.teja.bo.LoginBO;
import com.teja.dto.LoginDTO;

public class LoginDAO {

	// jdbc procedure call string
	public static final String AUTHENTICATION_CALL = "{call BACKPACK_LOGIN(?,?,?,?,?,?)}";

	public LoginBO getStatus(LoginDTO ldto) throws ClassNotFoundException, InstantiationException,
			IllegalAccessException, SQLException, NamingException {

		// initializing required params
		Connection con = null;
		InitialContext ic = null;
		DataSource ds = null;
		CallableStatement cs = null;
		LoginBO bo = null;

//		// create InitialCintext object
//		ic = new InitialContext();
//
//		// get DataSource object ref from Jndi Registry
//		ds = (DataSource) ic.lookup("java:/comp/env/jdbc/myoracle");
//
//		// getting connection
//		con = ds.getConnection();
		
		Class.forName("oracle.jdbc.driver.OracleDriver");

		// getting connection
		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","surya");

		// getting parameters from LoginDTO
		//String userEmail = ldto.getUserEmail();
		//String passWord = ldto.getPassword();

		// calling procedure to get values
		cs = con.prepareCall(AUTHENTICATION_CALL);

		// setting input parameters for the query
	//	cs.setString(1, userEmail);
	//	cs.setString(2, passWord);

		// registering output parameters for the query
		cs.registerOutParameter(3, Types.INTEGER);
		cs.registerOutParameter(4, Types.VARCHAR);
		cs.registerOutParameter(5, Types.VARCHAR);
		cs.registerOutParameter(6, Types.VARCHAR);

		// executing query and getting the resultset
		ResultSet rs = cs.executeQuery();

		// initialising bo for injecting output values
		bo = new LoginBO();

		// reading values from resultset and injecting into bo
		while (rs.next()) {
			bo.setUserId(rs.getInt(3));
			bo.setEmail(rs.getString(4));
			bo.setFname(rs.getString(5));
			bo.setResult(rs.getString(6));
		}

		// returning bo to service
		return bo;
	}

}
