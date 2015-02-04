package com.v2crm.services.impl;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.v2crm.dao.FeatureDAO;
import com.v2crm.dao.JPADAO;
import com.v2crm.domain.Feature;
import com.v2crm.exceptions.CRMException;
import com.v2crm.services.FeatureService;
@Service("featureService")
@Transactional(propagation= Propagation.REQUIRED, rollbackFor=CRMException.class)
public class FeatureServiceImpl extends CRMServiceImpl<Long, Feature> implements FeatureService{
	@Autowired
    protected FeatureDAO featureDAO;
	
	 

	@PostConstruct
    public void init() throws Exception {
	 super.setDAO((JPADAO) featureDAO);
    }
    
    @PreDestroy
    public void destroy() {
    }
    
    @Override
    public void setEntityManagerOnDao(EntityManager entityManager){
    	featureDAO.setEntityManager(entityManager);
    }
    
 
}


