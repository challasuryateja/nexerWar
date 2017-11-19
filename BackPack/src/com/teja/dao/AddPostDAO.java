package com.teja.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.teja.bo.AddPostBO;

public class AddPostDAO {

	// SNO NUMBER,USER_ID NUMBER(6),POST_ID NUMBER(6),PIC_COUNT NUMBER NOT
	// NULL,HNO VARCHAR2(15) NOT NULL,STREET VARCHAR2(50) NOT NULL,AREA
	// VARCHAR2(50) NOT NULL,PINCODE VARCHAR2(8) NOT NULL,CITY VARCHAR2(50) NOT
	// NULL,STATE VARCHAR2(50) NOT NULL,COUNTRY VARCHAR2(50) NOT
	// NULL,RENTAL_TYPE NUMBER NOT NULL,AVAILABILITY DATE NOT NULL,BATHROOMS
	// NUMBER NOT NULL,BEDROOMS NUMBER NOT NULL,LEAST_TERMS NUMBER NOT
	// NULL,ROOM_TYPE NUMBER NOT NULL,PRICE_TYPE NUMBER NOT NULL,PRICE
	// VARCHAR2(50) NOT NULL,HOLIDAY_RENTAL NUMBER NOT
	// NULL,FURNISHED_UNFURNISHED NUMBER NOT NULL,PETS_ALLOWED NUMBER NOT
	// NULL,HANDICAP_AXIS NUMBER NOT NULL,ELIVATOR_LIFT_STAIRS NUMBER NOT
	// NULL,AVG_RATING NUMBER
	private static final String INSERT_POST_QUERY = "INSERT INTO POSTS_TABLE(SNO,USER_ID,POST_ID,PIC_COUNT"
			+ "HNO,STREET,AREA,PINCODE,CITY,STATE,COUNTRY,RENTAL_TYPE,AVAILABILITY,BATHROOMS,BEDROOMS,LEAST_TERMS"
			+ "ROOM_TYPE,PRICE_TYPE,PRICE,HOLIDAY_RENTAL,FURNISHED_UNFURNISHED,PETS_ALLOWED,HANDICAP_AXIS"
			+ "ELIVATOR_LIFT_STAIRS,AVG_RATING) VALUES(POST_SNO_SEQUENCCE.NEXTVAL,?,POSTID_SEQUENCCE,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

	public int addPost(AddPostBO bo) throws NamingException, SQLException {
		// initializing required params
		Connection con = null;
		InitialContext ic = null;
		DataSource ds = null;
		PreparedStatement pst = null;

		// create InitialCintext object
		ic = new InitialContext();

		// get DataSource object ref from Jndi Registry
		ds = (DataSource) ic.lookup("java:/comp/env/jdbc/myoracle");

		// getting connection
		con = ds.getConnection();
		pst = con.prepareStatement(INSERT_POST_QUERY);
		pst.setInt(1, bo.getUSER_ID());
		pst.setInt(2, bo.getPIC_COUNT());
		pst.setString(3, bo.getHNO());
		pst.setString(4, bo.getSTREET());
		pst.setString(5, bo.getAREA());
		pst.setString(6, bo.getPINCODE());
		pst.setString(7, bo.getCITY());
		pst.setString(8, bo.getSTATE());
		pst.setString(9, bo.getCOUNTRY());
		pst.setInt(10, bo.getRENTAL_TYPE());
		pst.setDate(11, bo.getAVAILABILITY());
		pst.setInt(12, bo.getBATHROOMS());
		pst.setInt(13, bo.getBEDROOMS());
		pst.setInt(14, bo.getLEAST_TERMS());
		pst.setInt(15, bo.getROOM_TYPE());
		pst.setInt(16, bo.getPRICE_TYPE());
		pst.setString(17, bo.getPRICE());
		pst.setInt(18, bo.getHOLIDAY_RENTAL());
		pst.setInt(19, bo.getFURNISHED_UNFURNISHED());
		pst.setInt(20, bo.getPETS_ALLOWED());
		pst.setInt(21, bo.getHANDICAP_AXIS());
		pst.setInt(22, bo.getELIVATOR_LIFT_STAIRS());
		pst.setInt(23, bo.getAVG_RATING());
		int result=pst.executeUpdate();
		return result;
	}
}
