package com.v2crm.services.impl;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.v2crm.dao.ContactDAO;
import com.v2crm.dao.JPADAO;
import com.v2crm.domain.Contact;
import com.v2crm.exceptions.CRMException;
import com.v2crm.services.ContactService;
@Service("contactService")
@Transactional(propagation= Propagation.REQUIRED, rollbackFor=CRMException.class)
public class ContactServiceImpl extends CRMServiceImpl<Long, Contact> implements ContactService{
	@Autowired
    protected ContactDAO contactDAO;
	
	 

	@PostConstruct
    public void init() throws Exception {
	 super.setDAO((JPADAO) contactDAO);
    }
    
    @PreDestroy
    public void destroy() {
    }
    
    @Override
    public void setEntityManagerOnDao(EntityManager entityManager){
    	contactDAO.setEntityManager(entityManager);
    }
    
 
}
