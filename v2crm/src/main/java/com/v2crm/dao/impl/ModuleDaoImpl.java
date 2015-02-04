package com.v2crm.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.v2crm.dao.ModuleDAO;
import com.v2crm.domain.Module;

@Repository("moduleDAO")
public class ModuleDaoImpl  extends JpaDAOImpl<Long, Module> implements ModuleDAO{

	@Autowired
    EntityManagerFactory entityManagerFactory;
	
	@PersistenceContext(unitName="V2CRM_PersistenceUnit")
	private EntityManager entityManager;
	
	public void setEntityManager(EntityManager em) {
		this.entityManager = em;
		super.setEntityManager(entityManager);
		}
    
    @PostConstruct
    public void init() {
        super.setEntityManagerFactory(entityManagerFactory);
        super.setEntityManager(entityManager);
    }

    
	public EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}

	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}
	public Map<String,Module> getModuleMapByCode(){
		Query query=entityManager.createNamedQuery("Module.getModuleMapByCode");
		List<?> lst =query.getResultList();
		
		if(lst.size()==0){
			return new HashMap<String,Module>();
		}else{		
			return (Map<String,Module>)lst.get(0);
		}
		
	}
}
