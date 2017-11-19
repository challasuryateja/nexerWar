package com.jsonservices;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.teja.bo.LoginBO;
import com.teja.bo.RegisterBO;
import com.teja.controllers.Registation;
import com.teja.controllers.CheckUserNameController;
import com.teja.dao.CheckUserNameDao;
import com.teja.dao.LoginDAO;
import com.teja.dao.RegisterDAO;
import com.teja.dto.LoginDTO;


@Path("/UserService") 
public class UserService {  
	 Gson gson = new Gson();
	 int i;
   
   
  
   
 // user Registration  
   
   
   
   @POST
   @Path("/userRegistration") 
   public String userRegistration(String data) {
	   String status="";
	   
	   Registation service=gson.fromJson(data, Registation.class);
       CheckUserNameDao test= new CheckUserNameDao();
       try {
      // 	status=String.valueOf(test.check(service.getUserName()));
		} catch (Exception e) {
			e.printStackTrace();
		}
       
       System.out.println(status+" already exist");
      
       if(status.equals("1")){
    	   return "user exist";
       }else{
    
       try{
    	   RegisterBO rbo=new RegisterBO();
    	   rbo.setUSER_EMAIL(service.getUserName());
    	   rbo.setUSER_FNAME(service.getFirstName());
    	   rbo.setUSER_LNAME(service.getLastName());
    	   rbo.setUSER_PASSWORD(service.getPassword());
    	   rbo.setUSER_DEVICE_ID(service.getRegistrationId());
    	   rbo.setUSER_DEVICE_TYPE(service.getDeviceType());
    	   rbo.setUSER_PHONE_NUMBER(service.getPhoneNumber());
    	   RegisterDAO dao=new RegisterDAO();
            i=dao.insertUser(rbo);
            System.out.println(String.valueOf(i)+"insert");
            
            if(i==1){
            	return "sucess";
            	
              }else{
            	  return "failure";
              }
            
       }catch(Exception e){
    	   e.printStackTrace();
    	   return "Error Occured";
       }
       
       } 
   }
   
   
   
//   @POST
//   @Produces(MediaType.APPLICATION_JSON)
//   @Path("/userLogin") 
//   public LoginBO foo(String data) {
//	   System.out.println(data);	  
//	  Test service= new Gson().fromJson(data, Test.class);
//	  LoginDTO login=new LoginDTO();
//	  login.setUserEmail(service.getUserEmail());
//	  login.setPassword(service.getPassword());
//	  LoginDAO dao= new LoginDAO();
//	  LoginBO bo=new LoginBO();
//	  try {
//		  bo=dao.getStatus(login);
//	} catch (Exception e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	} 
//	
//	  
//	  System.out.println(bo.toString());
//	   return bo;
//   }
   
   
   // Food Clothes & rental Login
   
   @POST
   @Produces(MediaType.APPLICATION_JSON)
   @Path("/userLogin") 
   public LoginBO loginBo(String data) {
	   // prints data from mobile
	   System.out.println(data);	
	   
	   // parsing data using json
	  CheckUserNameController checkUserNameController= new Gson().fromJson(data, CheckUserNameController.class);
	  
	  // creating object and assigning value to Database
	  LoginDTO login=new LoginDTO();
	  login.setPhoneNumber(checkUserNameController.getmPhoneNumber());
	  LoginDAO dao= new LoginDAO();
	  LoginBO bo=new LoginBO();
	  try {
		  bo=dao.getStatus(login);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}   
	  System.out.println(bo.toString());
	   return bo;
   }
}
