package com.nexer.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.nexer.dto.LoginDTO;
import com.nexer.utils.Constants;


public class RegisterDAO {

	public int insertUser(LoginDTO rbo) throws SQLException, NamingException, ClassNotFoundException {
		Connection con = null;
		PreparedStatement pst = null;		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","surya");
		//+"(SNO,USER_PHONE_NUMBER ,USER_DEVICE_TYPE,USER_DEVICE_ID,USER_LATITUDE ,USER_IP_ADDRESS,USER_USER_LONGITUDE)"
		pst = con.prepareStatement(Constants.NEXER_REGISTER_QUERY);
		pst.setString(1, rbo.getmPhoneNumber());
		pst.setString(2, rbo.getmDeviceType());
		pst.setString(3, rbo.getmDeviceId());
		pst.setString(4, rbo.getmLatitude());
		pst.setString(5, rbo.getmLongitude());
		pst.setString(6, rbo.getmLongitude());
		int result = pst.executeUpdate();
		return result;
	}

}
