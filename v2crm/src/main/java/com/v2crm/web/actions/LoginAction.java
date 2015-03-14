package com.v2crm.web.actions;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;

import com.opensymphony.xwork2.ActionSupport;
import com.v2crm.services.ModuleService;
import com.v2crm.services.UserService;

public class LoginAction extends ActionSupport implements ServletRequestAware {

	private HttpServletRequest httpServletRequest;

	@Autowired
	private UserService userService;

	@Autowired
	private ModuleService moduleService;
	
		
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.httpServletRequest = request;
	}

	public String login() {
		
		/*List<Module> moduleLst = moduleService.findAll();

		User user = (User) userService.find(1);

		if(null!=user){
		UserType userType = user.getUserType();

		List<ModulePermission> permissionLst = userType.getModulePermission();

		List<ModulePermission> userAccesLst = new ArrayList<ModulePermission>();
		
		Map<String,ModulePermission> userTypeMpMap = new HashMap<String,ModulePermission>();
		
		for(ModulePermission mp: permissionLst){
			userTypeMpMap.put(mp.getModuleCode(), mp);
		}
		
		for(Module module : moduleLst){
						
				if(userTypeMpMap.containsKey(module.getModuleCode())){
					ModulePermission	mPermission =  userTypeMpMap.get(module.getModuleCode());
					if (mPermission.getReadModule() == false
							&& false == mPermission.getWriteModule()
							&& false == mPermission.getDeleteModule()) 
						continue;
				else{	
					ModulePermission modPerm=userTypeMpMap.get(module.getModuleCode());
					modPerm.setModuleName(module.getModuleName());
					modPerm.setCssClass(module.getCssClass());
					modPerm.setLink(module.getLink());
					//modPerm.setUserType(userType);
					userAccesLst.add(modPerm);
					}
				}
			}
				

		user.setUsersModuleAccessLst(userAccesLst);

		HttpSession session = httpServletRequest.getSession();
		session.setAttribute("LoggedInUser", user);
		}*/
		
		Object user = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		System.out.println(user);
		
		return "success";
	}
	
	public String setUpdata(){
		userService.setupData();
		return null;
	}

	public String displayDashboard() {

		return "success";
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public ModuleService getModuleService() {
		return moduleService;
	}

	public void setModuleService(ModuleService moduleService) {
		this.moduleService = moduleService;
	}
	
}
