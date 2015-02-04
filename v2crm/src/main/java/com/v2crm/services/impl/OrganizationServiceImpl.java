package com.v2crm.services.impl;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.v2crm.dao.JPADAO;
import com.v2crm.dao.OrganizationDAO;
import com.v2crm.domain.Organization;
import com.v2crm.exceptions.CRMException;
import com.v2crm.services.OrganizationService;
@Service("organizationService")
@Transactional(propagation= Propagation.REQUIRED, rollbackFor=CRMException.class)
public class OrganizationServiceImpl  extends CRMServiceImpl<Long, Organization> implements OrganizationService{
	@Autowired
    protected OrganizationDAO organizationDAO;
	
	 

	@PostConstruct
    public void init() throws Exception {
	 super.setDAO((JPADAO) organizationDAO);
    }
    
    @PreDestroy
    public void destroy() {
    }
    
    @Override
    public void setEntityManagerOnDao(EntityManager entityManager){
    	organizationDAO.setEntityManager(entityManager);
    }
    
 
}
