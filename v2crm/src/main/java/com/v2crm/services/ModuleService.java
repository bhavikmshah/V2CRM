package com.v2crm.services;

import java.util.Map;

import com.v2crm.domain.Module;

public interface ModuleService extends CRMService{

	Map<String,Module> getModuleMapByCode();
}
