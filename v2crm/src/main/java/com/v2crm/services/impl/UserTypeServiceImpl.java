package com.v2crm.services.impl;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.v2crm.dao.JPADAO;
import com.v2crm.dao.UserTypeDAO;
import com.v2crm.domain.UserType;
import com.v2crm.exceptions.CRMException;
import com.v2crm.services.UserTypeService;
@Service("userTypeService")
@Transactional(propagation= Propagation.REQUIRED)
public class UserTypeServiceImpl extends CRMServiceImpl<Long, UserType> implements UserTypeService{
	@Autowired
    protected UserTypeDAO userTypeDAO;
	
	 

	@PostConstruct
    public void init() throws Exception {
	 super.setDAO((JPADAO) userTypeDAO);
    }
    
    @PreDestroy
    public void destroy() {
    }
    
    @Override
    public void setEntityManagerOnDao(EntityManager entityManager){
    	userTypeDAO.setEntityManager(entityManager);
    }
    
 
}

