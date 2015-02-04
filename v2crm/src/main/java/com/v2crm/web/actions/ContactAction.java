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
import com.v2crm.domain.Contact;
import com.v2crm.domain.Industry;
import com.v2crm.domain.Lead;
import com.v2crm.domain.LeadSource;
import com.v2crm.domain.MessengerType;
import com.v2crm.domain.Rating;
import com.v2crm.domain.State;
import com.v2crm.exceptions.CRMException;
import com.v2crm.services.ContactService;
import com.v2crm.util.DataList;
import com.v2crm.util.SpringUtil;

public class ContactAction extends ActionSupport implements ServletRequestAware , ModelDriven<Contact> {
	Logger logger = LoggerFactory.getLogger(ContactAction.class);
	@Autowired
	private ContactService contactService;
	
	private Contact contact;
	
	private DataList dataList;
	
	HttpServletRequest httpServletRequest;
	
	public Contact getModel(){  
		
		System.out.println(" request uri"+ httpServletRequest.getRequestURI());
		System.out.println(httpServletRequest.getPathInfo());
		HttpSession session = httpServletRequest.getSession();
		
		if(httpServletRequest.getRequestURI().contains("/Display"))
		{
			contact=new Contact();
			session.setAttribute("contact",contact);
		}else{
			contact = (Contact)session.getAttribute("contact");
		}
		
	    return contact;  
	}
	
	public String display() 
	{
		List<Contact> contacts = contactService.findAll();
		
	        String param = new ParamEncoder("dataList").encodeParameterName(TableTagParameters.PARAMETER_PAGE);
	        if(httpServletRequest != null){
	        	dataList = new DataList(httpServletRequest);
	        	dataList.setList(contacts);
	        }
	        else{
	        	dataList = new DataList();
	        	dataList.setList(contacts);
	        }
	        
	        httpServletRequest.setAttribute( "data", dataList );
	        return SUCCESS;
	}



	public String delete(){
		String orgId = httpServletRequest.getParameter("id");
		if(orgId != null){
			
		}
		contactService.delete(Long.parseLong(orgId));
		List<Contact> contacts = contactService.findAll();
		
        String param = new ParamEncoder("dataList").encodeParameterName(TableTagParameters.PARAMETER_PAGE);
        if(httpServletRequest != null){
        	dataList = new DataList(httpServletRequest);
        	dataList.setList(contacts);
        }
        else{
        	dataList = new DataList();
        	dataList.setList(contacts);
        }
        
        httpServletRequest.setAttribute( "data", dataList );
        return "delete_success";
	}
	
	
	public String edit(){
		HttpSession session = httpServletRequest.getSession();
		if(httpServletRequest.getParameter("id") != null){
			Long contactId = Long.parseLong(httpServletRequest.getParameter("id"));
			contact = (Contact) contactService.find(contactId);
			session.setAttribute("contact", contact);
		}
	    return "edit_success";
	}
	
	public String save(){
		try {
			
			if(contact.getId() == null){
				contactService.save(contact);
			}
			else{
				contactService.saveOrUpdate(contact);
			}
			
			return "save_success";
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} 
		catch (CRMException e) {
			e.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return "save_failure";
	}

	
	public void setServletRequest(HttpServletRequest arg0) {
		this.httpServletRequest = arg0;  
	}

	public ContactService getContactService() {
		return contactService;
	}

	public void setContactService(ContactService contactService) {
		this.contactService = contactService;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

}
