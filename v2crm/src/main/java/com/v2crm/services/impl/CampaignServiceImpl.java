package com.v2crm.services.impl;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.v2crm.dao.CampaignDAO;
import com.v2crm.dao.JPADAO;
import com.v2crm.domain.Campaign;
import com.v2crm.exceptions.CRMException;
import com.v2crm.services.CampaignService;
@Service("campaignService")
@Transactional(propagation= Propagation.REQUIRED, rollbackFor=CRMException.class)
public class CampaignServiceImpl extends CRMServiceImpl<Long, Campaign> implements CampaignService{
	@Autowired
    protected CampaignDAO campaignDAO;
	
	 

	@PostConstruct
    public void init() throws Exception {
	 super.setDAO((JPADAO) campaignDAO);
    }
    
    @PreDestroy
    public void destroy() {
    }
    
    @Override
    public void setEntityManagerOnDao(EntityManager entityManager){
    	campaignDAO.setEntityManager(entityManager);
    }
    
 
}
