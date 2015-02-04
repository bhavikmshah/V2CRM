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
import com.v2crm.domain.Industry;
import com.v2crm.domain.Lead;
import com.v2crm.domain.LeadStatus;
import com.v2crm.domain.Organization;
import com.v2crm.domain.OrganizationType;
import com.v2crm.domain.OwnerShip;
import com.v2crm.domain.Rating;
import com.v2crm.domain.RevenueRange;
import com.v2crm.domain.State;
import com.v2crm.exceptions.CRMException;
import com.v2crm.services.OrganizationService;
import com.v2crm.util.DataList;
import com.v2crm.util.SpringUtil;

public class OrganizationAction extends ActionSupport implements ServletRequestAware,ModelDriven<Organization> {
	Logger logger = LoggerFactory.getLogger(OrganizationAction.class);
	@Autowired
	private OrganizationService organizationService;
	
	private DataList dataList;
	
	private Organization organization;
	HttpServletRequest httpServletRequest;
	
	public Organization getModel(){  
		HttpSession session = httpServletRequest.getSession();
		
		if(httpServletRequest.getRequestURI().contains("/Display"))
		{
			organization=new Organization();
			session.setAttribute("organization",organization);
		}else{
			organization = (Organization)session.getAttribute("organization");
		}
		
	    return organization;  
	}
	
	public String display() 
	{
		List<Organization> orgs = organizationService.findAll();
		
	        String param = new ParamEncoder("dataList").encodeParameterName(TableTagParameters.PARAMETER_PAGE);
	        if(httpServletRequest != null){
	        	dataList = new DataList(httpServletRequest);
	        	dataList.setList(orgs);
	        }
	        else{
	        	dataList = new DataList();
	        	dataList.setList(orgs);
	        }
	        
	        httpServletRequest.setAttribute( "data", dataList );
	        return SUCCESS;
	}



	public String delete(){
		String orgId = httpServletRequest.getParameter("id");
		if(orgId != null){
			
		}
		organizationService.delete(Long.parseLong(orgId));
		List<Organization> orgs = organizationService.findAll();
		
        String param = new ParamEncoder("dataList").encodeParameterName(TableTagParameters.PARAMETER_PAGE);
        if(httpServletRequest != null){
        	dataList = new DataList(httpServletRequest);
        	dataList.setList(orgs);
        }
        else{
        	dataList = new DataList();
        	dataList.setList(orgs);
        }
        
        httpServletRequest.setAttribute( "data", dataList );
        return "delete_success";
	}
	
	
	public String edit(){
		HttpSession session = httpServletRequest.getSession();
		if(httpServletRequest.getParameter("id") != null){
			Long orgId = Long.parseLong(httpServletRequest.getParameter("id"));
			organization = (Organization) organizationService.find(orgId);
			session.setAttribute("organization", organization);
		}
	    return "edit_success";
	}
	
	public String save(){
		try {
			if(organization.getId() == null){
				organizationService.save(organization);
			}
			else{
				organizationService.saveOrUpdate(organization);
			}
			
			return "save_success";
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (CRMException e) {
			e.printStackTrace();
		}
		return "save_failure";
	}

	
	public void setServletRequest(HttpServletRequest arg0) {
		this.httpServletRequest = arg0;  
	}



	public OrganizationService getOrganizationService() {
		return organizationService;
	}



	public void setOrganizationService(OrganizationService organizationService) {
		this.organizationService = organizationService;
	}

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	

}
