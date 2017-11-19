package com.nexer.restServices;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.nexer.bo.LoginBO;
import com.nexer.controller.CheckUserNameController;
import com.nexer.dao.CheckUserNameDao;
import com.nexer.dao.LoginDAO;
import com.nexer.dao.RegisterDAO;
import com.nexer.dto.LoginDTO;





@Path("/NexerService") 
public class UserService {  
	 Gson gson = new Gson();
      
	// Nexer login Service 
	
  
	   
	   @POST
	   @Path("/userRegistration") 
	   public String userRegistration(String data) {
		   int status=0;
		   int insert;
		   
		   CheckUserNameController checkUserNameController=gson.fromJson(data, CheckUserNameController.class);
	       CheckUserNameDao checkUname= new CheckUserNameDao();
	       try {
	       	status=checkUname.checkUserName(checkUserNameController.getmPhoneNumber());
			} catch (Exception e) {
				e.printStackTrace();
			}
	       System.out.println(status+" already exist");
	      
	       
	       if(status==1){
	    	   return "user exist";
	       }else{
	    
	       try{
	    	  LoginDTO login=new LoginDTO();
	 		  login.setmPhoneNumber(checkUserNameController.getmPhoneNumber());
	 		  login.setmDeviceId(checkUserNameController.getmDeviceId());
	 		  login.setmDeviceType(checkUserNameController.getmDeviceType());
	 		  login.setmLatitude(checkUserNameController.getmLatitude());
	 		  login.setmLongitude(checkUserNameController.getmLongitude());
	 		  login.setmIpAdress(checkUserNameController.getmIpAdress());
	 		  
	 		  
	 		  LoginDAO dao= new LoginDAO();
	 		  LoginBO bo=new LoginBO();
			 
	    	   RegisterDAO Rdao=new RegisterDAO();
	    	   insert=Rdao.insertUser(login);
	            System.out.println(String.valueOf(insert)+"insert");
	            
	            if(insert==1){
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
   
	   
 // user Registration  
	   
	   @POST
	   @Produces(MediaType.APPLICATION_JSON)
	   @Path("/userLogin") 
	   public LoginBO loginBo(String data) {
		   System.out.println(data);	
		   
		  CheckUserNameController checkUserNameController= new Gson().fromJson(data, CheckUserNameController.class);
		  
		  LoginDTO login=new LoginDTO();
		  login.setmPhoneNumber(checkUserNameController.getmPhoneNumber());
		  login.setmDeviceId(checkUserNameController.getmDeviceId());
		  login.setmDeviceType(checkUserNameController.getmPhoneNumber());
		  login.setmLatitude(checkUserNameController.getmPhoneNumber());
		  login.setmLongitude(checkUserNameController.getmPhoneNumber());
		  login.setmIpAdress(checkUserNameController.getmPhoneNumber());
		  LoginDAO dao= new LoginDAO();
		  LoginBO bo=new LoginBO();
		  
	try {
			  bo=dao.getStatus(login);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		  System.out.println(bo.getEmail());
		   return bo;
	   }
	   
	   
	 
}
