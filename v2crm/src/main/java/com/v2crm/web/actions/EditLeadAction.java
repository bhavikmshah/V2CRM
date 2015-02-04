package com.v2crm.web.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
import com.v2crm.services.LeadService;

public class EditLeadAction extends ActionSupport implements ServletRequestAware, ModelDriven<Lead>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Logger logger = LoggerFactory.getLogger(LeadAction.class);
	@Autowired
	private LeadService leadService;
	
	private Lead lead;
	
	private LeadSource leadSources[] = LeadSource.values();
	
	private LeadStatus leadStatuss[] = LeadStatus.values();
	
	private Rating ratings[] = Rating.values();
	
	Industry industries[] = Industry.values();
	
	State states[] = State.values();
	
	HttpServletRequest httpServletRequest;
	
	public Lead getModel(){  
		
		HttpSession session = httpServletRequest.getSession();
		lead = (Lead)session.getAttribute("lead");
		if(lead==null){	
			lead=new Lead();
		}
	    return lead;  
	}  


	public String editLead(){
		//leadService = (LeadService)SpringUtil.getSpringUtil().getService("leadService");
		if(httpServletRequest.getParameter("id") != null){
			Long leadId = Long.parseLong(httpServletRequest.getParameter("id"));
			lead = (Lead) leadService.find(leadId);
		}
		
		//httpServletRequest.setAttribute("lead", lead);
	    return "edit_success";
	}

	
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		this.httpServletRequest = arg0;  
	}
	
	public void setLead(Lead lead1){
		this.lead = lead1;
	}
	
	public Lead getLead(){
		return this.lead;
	}


	public LeadService getLeadService() {
		return leadService;
	}


	public void setLeadService(LeadService leadService) {
		this.leadService = leadService;
	}


	public LeadSource[] getLeadSources() {
		return leadSources;
	}


	public void setLeadSources(LeadSource[] leadSources) {
		this.leadSources = leadSources;
	}


	public LeadStatus[] getLeadStatuss() {
		return leadStatuss;
	}


	public void setLeadStatuss(LeadStatus[] leadStatuss) {
		this.leadStatuss = leadStatuss;
	}


	public Rating[] getRatings() {
		return ratings;
	}


	public void setRatings(Rating[] ratings) {
		this.ratings = ratings;
	}


	public Industry[] getIndustries() {
		return industries;
	}


	public void setIndustries(Industry[] industries) {
		this.industries = industries;
	}


	public State[] getStates() {
		return states;
	}


	public void setStates(State[] states) {
		this.states = states;
	}


	public HttpServletRequest getHttpServletRequest() {
		return httpServletRequest;
	}


	public void setHttpServletRequest(HttpServletRequest httpServletRequest) {
		this.httpServletRequest = httpServletRequest;
	}

	
}
