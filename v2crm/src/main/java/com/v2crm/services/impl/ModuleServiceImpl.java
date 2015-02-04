package com.v2crm.services.impl;

import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.v2crm.dao.ContactDAO;
import com.v2crm.dao.JPADAO;
import com.v2crm.dao.ModuleDAO;
import com.v2crm.domain.Module;
import com.v2crm.exceptions.CRMException;
import com.v2crm.services.ModuleService;

@Service("moduleService")
@Transactional(propagation= Propagation.REQUIRED, rollbackFor=CRMException.class)
public class ModuleServiceImpl extends CRMServiceImpl<Long, Module> implements ModuleService{
	
	@Autowired
    protected ModuleDAO moduleDAO;
	
	 

	@PostConstruct
    public void init() throws Exception {
	 super.setDAO((JPADAO) moduleDAO);
    }
    
    @PreDestroy
    public void destroy() {
    }
    
    @Override
    public void setEntityManagerOnDao(EntityManager entityManager){
    	moduleDAO.setEntityManager(entityManager);
    }
    
    public Map<String,Module> getModuleMapByCode(){
    	
    	return moduleDAO.getModuleMapByCode();
    }
}
