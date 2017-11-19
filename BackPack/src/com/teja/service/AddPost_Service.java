package com.teja.service;

import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.naming.NamingException;

import com.teja.bo.AddPostBO;
import com.teja.dao.AddPostDAO;
import com.teja.dto.AddPostDTO;
import com.teja.exceptions.AddPostException;

public class AddPost_Service {

	public String validatePost(AddPostDTO dto)
			throws ParseException, NamingException, SQLException, AddPostException, NullPointerException {

		int USER_ID, PIC_COUNT, RENTAL_TYPE, BATHROOMS, BEDROOMS, LEAST_TERMS, ROOM_TYPE, PRICE_TYPE, HOLIDAY_RENTAL,
				FURNISHED_UNFURNISHED, PETS_ALLOWED, HANDICAP_AXIS, ELIVATOR_LIFT_STAIRS, AVG_RATING;
		String HNO, STREET, AREA, PINCODE, CITY, STATE, COUNTRY, PRICE, AVAILABILITY;
		String strResult = null;
		USER_ID = dto.getUSER_ID();
		PIC_COUNT = dto.getPIC_COUNT();
		RENTAL_TYPE = dto.getRENTAL_TYPE();
		BATHROOMS = dto.getBATHROOMS();
		BEDROOMS = dto.getBEDROOMS();
		LEAST_TERMS = dto.getLEAST_TERMS();
		ROOM_TYPE = dto.getROOM_TYPE();
		PRICE_TYPE = dto.getPRICE_TYPE();
		HOLIDAY_RENTAL = dto.getHOLIDAY_RENTAL();
		FURNISHED_UNFURNISHED = dto.getFURNISHED_UNFURNISHED();
		PETS_ALLOWED = dto.getPETS_ALLOWED();
		HANDICAP_AXIS = dto.getHANDICAP_AXIS();
		ELIVATOR_LIFT_STAIRS = dto.getELIVATOR_LIFT_STAIRS();
		AVG_RATING = dto.getAVG_RATING();
		HNO = dto.getHNO();
		STREET = dto.getSTREET();
		AREA = dto.getAREA();
		PINCODE = dto.getPINCODE();
		CITY = dto.getCITY();
		STATE = dto.getSTATE();
		COUNTRY = dto.getCOUNTRY();
		PRICE = dto.getPRICE();
		AVAILABILITY = dto.getAVAILABILITY();

		if ((USER_ID != 0) && (PIC_COUNT != 0) && (RENTAL_TYPE != 0) && (BATHROOMS != 0) && (BEDROOMS != 0)
				&& (LEAST_TERMS != 0) && (ROOM_TYPE != 0) && (PRICE_TYPE != 0) && (HOLIDAY_RENTAL != 0)
				&& (FURNISHED_UNFURNISHED != 0) && (PETS_ALLOWED != 0) && (HANDICAP_AXIS != 0)
				&& (ELIVATOR_LIFT_STAIRS != 0) && (AVG_RATING != 0)) {
			if ((HNO != null) && (STREET != null) && (AREA != null) && (PINCODE != null) && (CITY != null)
					&& (STATE != null) && (COUNTRY != null) && (PRICE != null) && (AVAILABILITY != null)) {
				strResult = insertPost(dto);
			} else {
				throw new NullPointerException();
			}
		} else {
			throw new AddPostException();
		}
		return strResult;
	}

	private Date utilTOsqlDate(String date) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		java.util.Date uDate = sdf.parse(date);
		long ms = uDate.getTime();
		Date sqlDate = new Date(ms);
		return sqlDate;
	}

	public String insertPost(AddPostDTO dto) throws ParseException, NamingException, SQLException {
		AddPostBO bo = null;
		int result = 0;
		String strResult = null;
		int USER_ID, PIC_COUNT, RENTAL_TYPE, BATHROOMS, BEDROOMS, LEAST_TERMS, ROOM_TYPE, PRICE_TYPE, HOLIDAY_RENTAL,
				FURNISHED_UNFURNISHED, PETS_ALLOWED, HANDICAP_AXIS, ELIVATOR_LIFT_STAIRS, AVG_RATING;
		String HNO, STREET, AREA, PINCODE, CITY, STATE, COUNTRY, PRICE, AVAILABILITY;
		USER_ID = dto.getUSER_ID();
		PIC_COUNT = dto.getPIC_COUNT();
		RENTAL_TYPE = dto.getRENTAL_TYPE();
		BATHROOMS = dto.getBATHROOMS();
		BEDROOMS = dto.getBEDROOMS();
		LEAST_TERMS = dto.getLEAST_TERMS();
		ROOM_TYPE = dto.getROOM_TYPE();
		PRICE_TYPE = dto.getPRICE_TYPE();
		HOLIDAY_RENTAL = dto.getHOLIDAY_RENTAL();
		FURNISHED_UNFURNISHED = dto.getFURNISHED_UNFURNISHED();
		PETS_ALLOWED = dto.getPETS_ALLOWED();
		HANDICAP_AXIS = dto.getHANDICAP_AXIS();
		ELIVATOR_LIFT_STAIRS = dto.getELIVATOR_LIFT_STAIRS();
		AVG_RATING = dto.getAVG_RATING();
		HNO = dto.getHNO();
		STREET = dto.getSTREET();
		AREA = dto.getAREA();
		PINCODE = dto.getPINCODE();
		CITY = dto.getCITY();
		STATE = dto.getSTATE();
		COUNTRY = dto.getCOUNTRY();
		PRICE = dto.getPRICE();
		AVAILABILITY = dto.getAVAILABILITY();
		Date date = utilTOsqlDate(AVAILABILITY);
		bo = new AddPostBO();
		bo.setUSER_ID(USER_ID);
		bo.setPIC_COUNT(PIC_COUNT);
		bo.setRENTAL_TYPE(RENTAL_TYPE);
		bo.setBATHROOMS(BATHROOMS);
		bo.setBEDROOMS(BEDROOMS);
		bo.setLEAST_TERMS(LEAST_TERMS);
		bo.setROOM_TYPE(ROOM_TYPE);
		bo.setPRICE_TYPE(PRICE_TYPE);
		bo.setHOLIDAY_RENTAL(HOLIDAY_RENTAL);
		bo.setFURNISHED_UNFURNISHED(FURNISHED_UNFURNISHED);
		bo.setPETS_ALLOWED(PETS_ALLOWED);
		bo.setHANDICAP_AXIS(HANDICAP_AXIS);
		bo.setELIVATOR_LIFT_STAIRS(ELIVATOR_LIFT_STAIRS);
		bo.setAVG_RATING(AVG_RATING);
		bo.setHNO(HNO);
		bo.setSTREET(STREET);
		bo.setAREA(AREA);
		bo.setPINCODE(PINCODE);
		bo.setCITY(CITY);
		bo.setSTATE(STATE);
		bo.setCOUNTRY(COUNTRY);
		bo.setPRICE(PRICE);
		bo.setAVAILABILITY(date);
		AddPostDAO dao = new AddPostDAO();
		result = dao.addPost(bo);

		if (result == 1) {
			strResult = "success";
		} else {
			strResult = "failure";
		}

		return strResult;
	}
}
