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
import com.v2crm.domain.Campaign;
import com.v2crm.domain.CampaignResponseType;
import com.v2crm.domain.CampaignStatus;
import com.v2crm.domain.CampaignType;
import com.v2crm.domain.Oppurtunity;
import com.v2crm.exceptions.CRMException;
import com.v2crm.services.CampaignService;
import com.v2crm.util.DataList;
import com.v2crm.util.SpringUtil;

public class CampaignAction extends ActionSupport implements ServletRequestAware,ModelDriven<Campaign>  {
	Logger logger = LoggerFactory.getLogger(CampaignAction.class);
	@Autowired
	private CampaignService campaignService;
	
	private DataList dataList;
	
	HttpServletRequest httpServletRequest;
	
	private Campaign campaign;
	
	public Campaign getModel(){  
		HttpSession session = httpServletRequest.getSession();
		
		if(httpServletRequest.getRequestURI().contains("/Display"))
		{
			campaign=new Campaign();
			session.setAttribute("campaign",campaign);
		}else{
			campaign = (Campaign)session.getAttribute("campaign");
		}
		
	    return campaign;  
	}
	
	
	public String display() 
	{
		List<Campaign> campaigns = campaignService.findAll();
		
	        String param = new ParamEncoder("dataList").encodeParameterName(TableTagParameters.PARAMETER_PAGE);
	        if(httpServletRequest != null){
	        	dataList = new DataList(httpServletRequest);
	        	dataList.setList(campaigns);
	        }
	        else{
	        	dataList = new DataList();
	        	dataList.setList(campaigns);
	        }
	        
	        httpServletRequest.setAttribute( "data", dataList );
	        return SUCCESS;
	}



	public String delete(){
		String id = httpServletRequest.getParameter("id");
		if(id != null){
			
		}
		campaignService.delete(Long.parseLong(id));
		List<Campaign> campaigns = campaignService.findAll();
		
        String param = new ParamEncoder("dataList").encodeParameterName(TableTagParameters.PARAMETER_PAGE);
        if(httpServletRequest != null){
        	dataList = new DataList(httpServletRequest);
        	dataList.setList(campaigns);
        }
        else{
        	dataList = new DataList();
        	dataList.setList(campaigns);
        }
        
        httpServletRequest.setAttribute( "data", dataList );
        return "delete_success";
	}
	
	
	public String edit(){
		HttpSession session = httpServletRequest.getSession();
		if(httpServletRequest.getParameter("id") != null){
			Long id = Long.parseLong(httpServletRequest.getParameter("id"));
			campaign = (Campaign) campaignService.find(id);
			session.setAttribute("campaign", campaign);
		}
	    return "edit_success";
	}
	
	public String save(){
		try {
			
			
			if(campaign.getId() == null){
				campaignService.save(campaign);
			}
			else{
				campaignService.saveOrUpdate(campaign);
			}
			
			return "save_success";
		} catch (NumberFormatException e) {
			e.printStackTrace();
			logger.error("Can not save campaign", e);
		} 
		catch (CRMException e) {
			e.printStackTrace();
			logger.error("Can not save campaign", e);
		}
		catch(Exception e){
			e.printStackTrace();
			logger.error("Can not save campaign", e);
		}
		return "save_failure";
	}

	
	public void setServletRequest(HttpServletRequest arg0) {
		this.httpServletRequest = arg0;  
	}



	public CampaignService getCampaignService() {
		return campaignService;
	}



	public void setCampaignService(CampaignService campaignService) {
		this.campaignService = campaignService;
	}


	public Campaign getCampaign() {
		return campaign;
	}


	public void setCampaign(Campaign campaign) {
		this.campaign = campaign;
	}

	

}
