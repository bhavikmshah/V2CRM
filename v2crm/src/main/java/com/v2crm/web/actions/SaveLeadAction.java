package com.v2crm.web.actions;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.v2crm.domain.Industry;
import com.v2crm.domain.Lead;
import com.v2crm.domain.LeadSource;
import com.v2crm.domain.LeadStatus;
import com.v2crm.domain.Rating;
import com.v2crm.domain.State;
import com.v2crm.exceptions.CRMException;
import com.v2crm.services.LeadService;
import com.v2crm.util.SpringUtil;

public class SaveLeadAction extends ActionSupport implements ServletRequestAware,ModelDriven<Lead>{
	HttpServletRequest httpServletRequest;
	Logger logger = LoggerFactory.getLogger(LeadAction.class);
	@Autowired
	private LeadService leadService;
	
	private Lead lead;
	
	public Lead getModel(){  
		lead=new Lead();  
	    return lead;  
	}  
	
	
	public Lead getLead() {
		return lead;
	}


	public void setLead(Lead lead) {
		this.lead = lead;
	}


	public String save(){
		try {
			//leadService = (LeadService)SpringUtil.getSpringUtil().getService("leadService");
			//Lead lead = (Lead) httpServletRequest.getSession().getAttribute("lead");
			
			/*lead.setFirstName(httpServletRequest.getParameter("firstName"));
			lead.setLastName(httpServletRequest.getParameter("lastName"));
			lead.setCompany(httpServletRequest.getParameter("company"));
			
			lead.setPrimaryEmail(httpServletRequest.getParameter("primaryEmail"));
			lead.setPrimaryPhone(httpServletRequest.getParameter("primaryPhone"));
			lead.setDesignation(httpServletRequest.getParameter("designation"));
			
			lead.setMobile(httpServletRequest.getParameter("mobile"));
			lead.setWebsite(httpServletRequest.getParameter("website"));
			lead.setFax(httpServletRequest.getParameter("fax"));
			
			if(httpServletRequest.getParameter("noOfEmployers") != null){
				lead.setNumOfEmployers(Integer.parseInt(httpServletRequest.getParameter("noOfEmployers")));
			}
			
			lead.setIndustry(Industry.valueOf(httpServletRequest.getParameter("industry")));
			lead.setLeadSource(LeadSource.valueOf(httpServletRequest.getParameter("leadSource")));
			lead.setLeadStatus(LeadStatus.valueOf(httpServletRequest.getParameter("leadStatus")));
			
			lead.setRating(Rating.valueOf(httpServletRequest.getParameter("rating")));*/
			
			lead.getAddress().setCity(httpServletRequest.getParameter("city"));
			lead.getAddress().setStreet(httpServletRequest.getParameter("street"));
			lead.getAddress().setBldg(httpServletRequest.getParameter("building"));
			
			lead.getAddress().setOfficeNumber(httpServletRequest.getParameter("officeNumber"));
			lead.getAddress().setPin(httpServletRequest.getParameter("zip"));
			lead.getAddress().setState(State.valueOf(httpServletRequest.getParameter("state")));
			lead.getAddress().setCountry(httpServletRequest.getParameter("country"));
			httpServletRequest.setAttribute("lead", lead);
			if(lead.getId() == null){
				leadService.save(lead);
			}
			else{
				leadService.saveOrUpdate(lead);
			}
			
			return "save_success";
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CRMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "save_failure";
	}
	
	
	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		httpServletRequest = arg0;
	}


	public LeadService getLeadService() {
		return leadService;
	}


	public void setLeadService(LeadService leadService) {
		this.leadService = leadService;
	}

	
}
