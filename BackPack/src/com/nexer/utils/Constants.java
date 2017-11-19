package com.nexer.utils;

public class Constants {
	
	// Database Table Names
	
	public static final String CHECK_USER_NAME="SELECT Count(*) FROM NEXER_USER_TABLE WHERE USER_PHONE_NUMBER=?";
	
	public static final String NEXER_USERS_TABLE="SELECT * FROM NEXER_USER_TABLE WHERE USER_PHONE_NUMBER =?";
	
	public static final String NEXER_REGISTER_QUERY="INSERT INTO NEXER_USER_TABLE "	
			+"(SNO,USER_PHONE_NUMBER ,USER_DEVICE_TYPE,USER_DEVICE_ID,USER_LATITUDE ,USER_IP_ADDRESS,USER_USER_LONGITUDE)"
			+ " VALUES (SNO_SEQUENCCE.NEXTVAL,?,?,?,?,?,?)";
	
	
	public static String emptyFirstName="Please Enter First Name";
	public static String emptyLastName="Please Enter Last Name";
	public static String emptyPassword="Please Enter Password";
	public static String emptyRepassword="Please ReEnter Password";
	public static String emptyEmail="Please Enter Email";
	public static String emptyMobile="Please Enter Mobile Number";
	public static String inValidMobileNum="Please Enter Valid Mobile Number";
	public static String invalidEmail="Please Enter Valid Email Id";
	public static String passwordMisMatch="Password Mis Match";
	
	

}
