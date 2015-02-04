package com.v2crm.services.impl;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.v2crm.dao.JPADAO;
import com.v2crm.dao.LeadDAO;
import com.v2crm.domain.Lead;
import com.v2crm.exceptions.CRMException;
import com.v2crm.services.LeadService;

@Service("leadService")
@Transactional(propagation= Propagation.REQUIRED, rollbackFor=CRMException.class)
public class LeadServiceImpl extends CRMServiceImpl<Long, Lead> implements LeadService{
	@Autowired
    protected LeadDAO leadDAO;
	
	 

	@PostConstruct
    public void init() throws Exception {
	 super.setDAO((JPADAO) leadDAO);
    }
    
    @PreDestroy
    public void destroy() {
    }
    
    @Override
    public void setEntityManagerOnDao(EntityManager entityManager){
    	leadDAO.setEntityManager(entityManager);
    }
    
 
}
