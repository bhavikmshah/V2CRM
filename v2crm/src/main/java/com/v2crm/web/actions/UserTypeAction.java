package com.v2crm.web.actions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.displaytag.tags.TableTagParameters;
import org.displaytag.util.ParamEncoder;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.v2crm.domain.Module;
import com.v2crm.domain.ModulePermission;
import com.v2crm.domain.UserType;
import com.v2crm.exceptions.CRMException;
import com.v2crm.services.ModuleService;
import com.v2crm.services.UserTypeService;
import com.v2crm.util.DataList;

public class UserTypeAction extends ActionSupport implements
		ServletRequestAware, ModelDriven<UserType> {

	private HttpServletRequest httpServletRequest;
	@Autowired
	private UserTypeService userTypeService;
	private DataList dataList;
	private UserType userTypeObj;
	@Autowired
	private ModuleService moduleService;

	@Override
	public UserType getModel() {
		HttpSession session = httpServletRequest.getSession();

		if (httpServletRequest.getRequestURI().contains("/Display")) {
			userTypeObj = new UserType();
			session.setAttribute("userTypeObj", userTypeObj);
		} else {
			userTypeObj = (UserType) session.getAttribute("userTypeObj");
		}

		return userTypeObj;
	}

	public String display() {
		List<UserType> userTypes = userTypeService.findAll();

		String param = new ParamEncoder("dataList")
				.encodeParameterName(TableTagParameters.PARAMETER_PAGE);
		if (httpServletRequest != null) {
			dataList = new DataList(httpServletRequest);
			dataList.setList(userTypes);
		} else {
			dataList = new DataList();
			dataList.setList(userTypes);
		}

		httpServletRequest.setAttribute("data", dataList);
		return SUCCESS;
	}

	public String delete() {
		String userTypeId = httpServletRequest.getParameter("id");
		if (userTypeId != null) {
			userTypeService.delete(Long.parseLong(userTypeId));
		}

		List<UserType> userType = userTypeService.findAll();

		if (httpServletRequest != null) {
			dataList = new DataList(httpServletRequest);
			dataList.setList(userType);
		} else {
			dataList = new DataList();
			dataList.setList(userType);
		}

		httpServletRequest.setAttribute("data", dataList);
		return "delete_success";
	}

	public String edit() {
		HttpSession session = httpServletRequest.getSession();
		if (httpServletRequest.getParameter("id") != null) {
			Long userTypeId = Long.parseLong(httpServletRequest
					.getParameter("id"));
			userTypeObj = (UserType) userTypeService.find(userTypeId);
		}
		
		setModulePermissions(userTypeObj);
		session.setAttribute("userTypeObj", userTypeObj);
		return "edit_success";
	}

	private void setModulePermissions(UserType userType){
		
		//Map<String, Module> moduleMap=moduleService.getModuleMapByCode();
		List<Module> moduleLst = moduleService.findAll();
		
		//Collection<Module> moduleLst =  moduleMap.values();
		
		List<ModulePermission> userTypeModulePermissionLst = userType.getModulePermission();
		if(null==userTypeModulePermissionLst){
			userTypeModulePermissionLst = new ArrayList<ModulePermission>();
		}
		
		if(userTypeModulePermissionLst.size()==0){
			ModulePermission mp=null;			
			for(Module module : moduleLst){
					mp=new ModulePermission();
					mp.setModuleCode(module.getModuleCode());
					mp.setModuleName(module.getModuleName());
					mp.setUserType(userType);
					userTypeModulePermissionLst.add(mp);
					
			}
			userType.setModulePermission(userTypeModulePermissionLst);
		}else{
			
			List<ModulePermission> newPermissionLst = new ArrayList<ModulePermission>();
			
			Map<String,ModulePermission> userTypeMpMap = new HashMap<String,ModulePermission>();
			
			for(ModulePermission mp: userTypeModulePermissionLst){
				userTypeMpMap.put(mp.getModuleCode(), mp);
			}
			
			for(Module module : moduleLst){
				if(userTypeMpMap.containsKey(module.getModuleCode())){
					ModulePermission modPerm=userTypeMpMap.get(module.getModuleCode());
					modPerm.setModuleName(module.getModuleName());
					modPerm.setUserType(userType);
					newPermissionLst.add(modPerm);
				}else{
					ModulePermission mp=null;	
					mp=new ModulePermission();
					mp.setModuleCode(module.getModuleCode());
					mp.setModuleName(module.getModuleName());
					mp.setUserType(userType);
					newPermissionLst.add(mp);
				}
				
			}
			userType.setModulePermission(newPermissionLst);
		}
		
	}
	
	
	public String save() {
		try {

			List<ModulePermission> mpLst=userTypeObj.getModulePermission();
			
			for(ModulePermission mp:mpLst){
				mp.setUserType(userTypeObj);
			}
			
			if (userTypeObj.getId() == null) {
				userTypeService.save(userTypeObj);
			} else {
				userTypeService.saveOrUpdate(userTypeObj);
			}

			return "save_success";
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (CRMException e) {
			e.printStackTrace();
		}
		return "save_failure";
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.httpServletRequest = request;
	}

	public HttpServletRequest getHttpServletRequest() {
		return httpServletRequest;
	}

	public void setHttpServletRequest(HttpServletRequest httpServletRequest) {
		this.httpServletRequest = httpServletRequest;
	}

	public UserTypeService getUserTypeService() {
		return userTypeService;
	}

	public void setUserTypeService(UserTypeService userTypeService) {
		this.userTypeService = userTypeService;
	}

	public DataList getDataList() {
		return dataList;
	}

	public void setDataList(DataList dataList) {
		this.dataList = dataList;
	}

	

	public UserType getUserTypeObj() {
		return userTypeObj;
	}

	public void setUserTypeObj(UserType userTypeObj) {
		this.userTypeObj = userTypeObj;
	}

	public ModuleService getModuleService() {
		return moduleService;
	}

	public void setModuleService(ModuleService moduleService) {
		this.moduleService = moduleService;
	}

	
}
