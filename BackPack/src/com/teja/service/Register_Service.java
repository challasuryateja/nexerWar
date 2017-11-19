package com.teja.service;

import java.sql.SQLException;

import javax.naming.NamingException;

import com.teja.bo.RegisterBO;
import com.teja.dao.RegisterDAO;
import com.teja.dto.RegisterDTO;
import com.teja.exceptions.InValidEmailException;
import com.teja.exceptions.MobilNumberLengthException;
import com.teja.exceptions.PasswordEqualsException;
import com.teja.exceptions.PasswordLengthException;

public class Register_Service {

	public String check_Validations(RegisterDTO rdto) throws NullPointerException, InValidEmailException,
			PasswordLengthException, PasswordEqualsException, MobilNumberLengthException, SQLException, NamingException {

		String USER_FNAME, USER_LNAME, USER_EMAIL, USER_PASSWORD, USER_REPASSWORD, USER_DEVICE_TYPE, USER_DEVICE_ID,
				USER_PHONE_NUMBER;

		USER_FNAME = rdto.getUSER_FNAME();
		USER_LNAME = rdto.getUSER_LNAME();
		USER_EMAIL = rdto.getUSER_EMAIL();
		USER_PASSWORD = rdto.getUSER_PASSWORD();
		USER_REPASSWORD = rdto.getUSER_REPASSWORD();
		USER_DEVICE_TYPE = rdto.getUSER_DEVICE_TYPE();
		USER_DEVICE_ID = rdto.getUSER_DEVICE_ID();
		USER_PHONE_NUMBER = rdto.getUSER_PHONE_NUMBER();
		
		
		String result;

		if (USER_FNAME != null && USER_LNAME != null && USER_EMAIL != null && USER_PASSWORD != null
				&& USER_REPASSWORD != null && USER_DEVICE_TYPE != null && USER_DEVICE_ID != null
				&& USER_PHONE_NUMBER != null) {

			if ((USER_EMAIL.contains("@")) && (USER_EMAIL.contains("."))) {

				if ((USER_PASSWORD.length() > 8) && (USER_PASSWORD.length() < 16)) {

					if ((USER_REPASSWORD.length() > 8) && (USER_REPASSWORD.length() < 16)) {

						if ((USER_PASSWORD.equals(USER_REPASSWORD))) {
							if ((USER_PHONE_NUMBER.length())== 10) {
								
								
									RegisterBO rbo = new RegisterBO();
									rbo.setUSER_FNAME(USER_FNAME);
									rbo.setUSER_LNAME(USER_LNAME);
									rbo.setUSER_EMAIL(USER_EMAIL);
									rbo.setUSER_PASSWORD(USER_PASSWORD);
									rbo.setUSER_DEVICE_TYPE(USER_DEVICE_TYPE);
									rbo.setUSER_DEVICE_ID(USER_DEVICE_ID);
									rbo.setUSER_PHONE_NUMBER(USER_PHONE_NUMBER);
									
									result=insert_User(rbo);
								
							} else {
								throw new MobilNumberLengthException();
							}

						} else {
							throw new PasswordEqualsException();
						}

					} else {
						throw new PasswordLengthException();
					}
				} else {
					throw new PasswordLengthException();
				}
			} else {
				throw new InValidEmailException();
			}
		} else {
			throw new NullPointerException();
		}
		return result;

	}
	
	public String insert_User(RegisterBO rbo) throws SQLException, NamingException{
		String result=null;
		RegisterDAO dao = new RegisterDAO();
		int status;
		try {
			status = dao.insertUser(rbo);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		if (status == 1) {
//			result = "valid user";
//		} else {
//			result = "invalid user";
//		}
		return result;
	}

}
