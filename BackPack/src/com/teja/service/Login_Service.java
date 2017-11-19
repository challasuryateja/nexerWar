package com.teja.service;

import java.sql.SQLException;

import javax.naming.NamingException;

import com.teja.bo.LoginBO;
import com.teja.dao.LoginDAO;
import com.teja.dto.LoginDTO;
import com.teja.exceptions.InValidEmailException;
import com.teja.exceptions.PasswordLengthException;

public class Login_Service {

	public String check_Data_validations(LoginDTO ldto) throws PasswordLengthException, InValidEmailException,NullPointerException {

		// getting user credentials
		String mPhoneNum = ldto.getPhoneNumber();
		String isValid = "invalid";

		// checking null/not
		if (mPhoneNum != null && mPhoneNum != null) {
			if ((mPhoneNum.contains("@") && (mPhoneNum.contains(".")))) {
				if ((mPhoneNum.length() > 8) && (mPhoneNum.length() < 16)) {
					isValid = "valid";
				} else {
					throw new PasswordLengthException();
				}

			} else {
				throw new InValidEmailException();
			}
		} else {
			throw new NullPointerException();
		}
		return isValid;
	}
	
	
	public LoginBO authenticate_User(LoginDTO ldto) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, NamingException{
		
		LoginDAO dao = new LoginDAO();
		LoginBO lbo=dao.getStatus(ldto);
		return lbo;
	}

}
