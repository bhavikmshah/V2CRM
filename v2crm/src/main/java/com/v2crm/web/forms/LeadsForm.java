package com.v2crm.web.forms;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.v2crm.domain.Lead;
import com.v2crm.exceptions.CRMException;
import com.v2crm.services.LeadService;
import com.v2crm.util.SpringUtil;

public class LeadsForm {
private List<Lead> leads;
@Autowired
private LeadService leadService;

public LeadsForm(){
	try {
		//LeadService leadService = (LeadService) SpringUtil.getSpringUtil().getService("leadService");
		leads = leadService.findAll();
	} catch (CRMException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

public List<Lead> getLeads() {
	return leads;
}

public void setLeads(List<Lead> leads) {
	this.leads = leads;
}

public LeadService getLeadService() {
	return leadService;
}

public void setLeadService(LeadService leadService) {
	this.leadService = leadService;
}


	

}
