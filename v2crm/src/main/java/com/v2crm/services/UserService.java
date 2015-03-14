package com.v2crm.services;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.v2crm.exceptions.CRMException;

public interface UserService extends CRMService,UserDetailsService {
	
	public void setupData() throws CRMException;

}

