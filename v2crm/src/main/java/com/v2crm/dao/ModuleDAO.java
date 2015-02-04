package com.v2crm.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.v2crm.domain.Module;


public interface ModuleDAO extends JPADAO<Module, Long>{

	Map<String,Module> getModuleMapByCode();

}


