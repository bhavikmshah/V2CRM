package com.v2crm.services;

import com.v2crm.exceptions.CRMException;

public interface UserService extends CRMService{
	
	public void setupData() throws CRMException;

}

