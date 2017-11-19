package com.teja.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.teja.bo.RegisterBO;

public class RegisterDAO {

	private static final String Register_Query = "INSERT INTO USER_TABLE (SNO,USER_ID,USER_FNAME,"
			+ "USER_LNAME,USER_EMAIL,USER_PASSWORD,USER_DEVICE_TYPE,USER_DEVICE_ID,USER_PHONE_NUMBER)"
			+ " VALUES (SNO_SEQUENCCE.NEXTVAL,USERID_SEQUENCCE.NEXTVAL,?,?,?,?,?,?,?)";

	public int insertUser(RegisterBO rbo) throws SQLException, NamingException, ClassNotFoundException {

		// initializing required params
		Connection con = null;
		/*InitialContext ic = null;
		DataSource ds = null;*/
		PreparedStatement pst = null;

		// create InitialCintext object
		//ic = new InitialContext();

		// get DataSource object ref from Jndi Registry
		//ds = (DataSource) ic.lookup("java:/comp/env/dsanda");
		
		Class.forName("oracle.jdbc.driver.OracleDriver");

		// getting connection
		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","surya");
		
		pst = con.prepareStatement(Register_Query);
		pst.setString(1, rbo.getUSER_FNAME());
		pst.setString(2, rbo.getUSER_LNAME());
		pst.setString(3, rbo.getUSER_EMAIL());
		pst.setString(4, rbo.getUSER_PASSWORD());
		pst.setString(5, rbo.getUSER_DEVICE_TYPE());
		pst.setString(6, rbo.getUSER_DEVICE_ID());
		pst.setString(7, rbo.getUSER_PHONE_NUMBER());

		int result = pst.executeUpdate();

		return result;

	}

}
