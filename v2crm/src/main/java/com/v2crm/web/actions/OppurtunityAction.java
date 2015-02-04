package com.v2crm.web.actions;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

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
import com.v2crm.domain.LeadSource;
import com.v2crm.domain.Oppurtunity;
import com.v2crm.domain.OppurtunityStrategy;
import com.v2crm.domain.OppurtunityType;
import com.v2crm.domain.Organization;
import com.v2crm.domain.SalesStage;
import com.v2crm.exceptions.CRMException;
import com.v2crm.services.OppurtunityService;
import com.v2crm.util.DataList;
import com.v2crm.util.SpringUtil;

public class OppurtunityAction extends ActionSupport implements ServletRequestAware,ModelDriven<Oppurtunity> {
	Logger logger = LoggerFactory.getLogger(OppurtunityAction.class);
	@Autowired
	private OppurtunityService oppurtunityService;
	
	private DataList dataList;
	
	HttpServletRequest httpServletRequest;
	
	private Oppurtunity oppurtunity;
	
	public Oppurtunity getModel(){  
		HttpSession session = httpServletRequest.getSession();
		
		if(httpServletRequest.getRequestURI().contains("/Display"))
		{
			oppurtunity=new Oppurtunity();
			session.setAttribute("oppurtunity",oppurtunity);
		}else{
			oppurtunity = (Oppurtunity)session.getAttribute("oppurtunity");
		}
		
	    return oppurtunity;  
	}
	
	public String display() 
	{
		List<Oppurtunity> oppurtunities = oppurtunityService.findAll();
		
	        String param = new ParamEncoder("dataList").encodeParameterName(TableTagParameters.PARAMETER_PAGE);
	        if(httpServletRequest != null){
	        	dataList = new DataList(httpServletRequest);
	        	dataList.setList(oppurtunities);
	        }
	        else{
	        	dataList = new DataList();
	        	dataList.setList(oppurtunities);
	        }
	        
	        httpServletRequest.setAttribute( "data", dataList );
	        return SUCCESS;
	}



	public String delete(){
		String id = httpServletRequest.getParameter("id");
		if(id != null){
			
		}
		oppurtunityService.delete(Long.parseLong(id));
		List<Oppurtunity> oppurtunities = oppurtunityService.findAll();
		
        String param = new ParamEncoder("dataList").encodeParameterName(TableTagParameters.PARAMETER_PAGE);
        if(httpServletRequest != null){
        	dataList = new DataList(httpServletRequest);
        	dataList.setList(oppurtunities);
        }
        else{
        	dataList = new DataList();
        	dataList.setList(oppurtunities);
        }
        
        httpServletRequest.setAttribute( "data", dataList );
        return "delete_success";
	}
	
	
	public String edit(){
		HttpSession session = httpServletRequest.getSession();
		if(httpServletRequest.getParameter("id") != null){
			Long id = Long.parseLong(httpServletRequest.getParameter("id"));
			oppurtunity = (Oppurtunity) oppurtunityService.find(id);
			session.setAttribute("oppurtunity", oppurtunity);
		}
	    return "edit_success";
	}
	
	public String save(){
		try {
		
			if(oppurtunity.getId() == null){
				oppurtunityService.save(oppurtunity);
			}
			else{
				oppurtunityService.saveOrUpdate(oppurtunity);
			}
			
			return "save_success";
		} catch (NumberFormatException e) {
			e.printStackTrace();
			logger.error("Can not save oppurtunity", e);
		} 
		catch (CRMException e) {
			e.printStackTrace();
			logger.error("Can not save oppurtunity", e);
		}
		catch(Exception e){
			e.printStackTrace();
			logger.error("Can not save oppurtunity", e);
		}
		return "save_failure";
	}

	
	public void setServletRequest(HttpServletRequest arg0) {
		this.httpServletRequest = arg0;  
	}

	public OppurtunityService getOppurtunityService() {
		return oppurtunityService;
	}

	public void setOppurtunityService(OppurtunityService oppurtunityService) {
		this.oppurtunityService = oppurtunityService;
	}

	public Oppurtunity getOppurtunity() {
		return oppurtunity;
	}

	public void setOppurtunity(Oppurtunity oppurtunity) {
		this.oppurtunity = oppurtunity;
	}

	

}
