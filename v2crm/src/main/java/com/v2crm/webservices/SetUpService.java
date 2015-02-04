package com.v2crm.webservices;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.transaction.annotation.Transactional;

import com.v2crm.services.UserService;
import com.v2crm.util.SpringUtil;

@Path("/setUpService")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Transactional
public class SetUpService {

	
	@POST
    @Path("/userData")
    public void setUpInitData(){
		
		//UserService userService = (UserService)SpringUtil.getSpringUtil().getService("userService");
		//userService.setupData();
		System.out.println("set up done");
	}

}
