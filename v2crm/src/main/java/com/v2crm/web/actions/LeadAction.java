package com.v2crm.web.actions;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.displaytag.tags.TableTagParameters;
import org.displaytag.util.ParamEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.v2crm.domain.Lead;
import com.v2crm.domain.State;
import com.v2crm.exceptions.CRMException;
import com.v2crm.services.LeadService;
import com.v2crm.util.DataList;
import com.v2crm.util.SpringUtil;
public class LeadAction extends ActionSupport implements ServletRequestAware, ModelDriven<Lead> {
	Logger logger = LoggerFactory.getLogger(LeadAction.class);
	@Autowired
	private LeadService leadService;
	
	private DataList dataList;
	
	HttpServletRequest httpServletRequest;
	
	private Lead lead;
	
	public Lead getModel(){  
		HttpSession session = httpServletRequest.getSession();
		
		if(httpServletRequest.getRequestURI().contains("/Display"))
		{
			lead=new Lead();
			session.setAttribute("lead",lead);
		}else{
			lead = (Lead)session.getAttribute("lead");
		}
		
	    return lead;  
	}
	
	public String displayLeads() 
	{
		List<Lead> leads = leadService.findAll();
		
	        String param = new ParamEncoder("dataList").encodeParameterName(TableTagParameters.PARAMETER_PAGE);
	        if(httpServletRequest != null){
	        	dataList = new DataList(httpServletRequest);
	        	dataList.setList(leads);
	        }
	        else{
	        	dataList = new DataList();
	        	dataList.setList(leads);
	        }
	        
	        httpServletRequest.setAttribute( "data", dataList );
	        return SUCCESS;
	}


	public String editLead(){
		HttpSession session = httpServletRequest.getSession();
		if(httpServletRequest.getParameter("id") != null){
			Long leadId = Long.parseLong(httpServletRequest.getParameter("id"));
			lead = (Lead) leadService.find(leadId);
			session.setAttribute("lead",lead);
		}
		
	    return "edit_success";
	}
	
	public String save(){
		try {
			if(lead.getId() == null){
				leadService.save(lead);
			}
			else{
				leadService.saveOrUpdate(lead);
			}
			
			return "save_success";
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (CRMException e) {
			e.printStackTrace();
		}
		return "save_failure";
	}

	public String deleteLead(){
		String leadId = httpServletRequest.getParameter("id");
		if(leadId != null){
			
		}
		leadService.delete(Long.parseLong(leadId));
		List<Lead> leads = leadService.findAll();
		
        String param = new ParamEncoder("dataList").encodeParameterName(TableTagParameters.PARAMETER_PAGE);
        if(httpServletRequest != null){
        	dataList = new DataList(httpServletRequest);
        	dataList.setList(leads);
        }
        else{
        	dataList = new DataList();
        	dataList.setList(leads);
        }
        
        httpServletRequest.setAttribute( "data", dataList );
        return "delete_success";
	}
	
	public void setServletRequest(HttpServletRequest arg0) {
		this.httpServletRequest = arg0;  
	}


	public LeadService getLeadService() {
		return leadService;
	}


	public void setLeadService(LeadService leadService) {
		this.leadService = leadService;
	}

	public Lead getLead() {
		return lead;
	}

	public void setLead(Lead lead) {
		this.lead = lead;
	}

	

}


