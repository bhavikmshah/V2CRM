package com.v2crm.web.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.displaytag.tags.TableTagParameters;
import org.displaytag.util.ParamEncoder;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.v2crm.domain.User;
import com.v2crm.domain.UserType;
import com.v2crm.exceptions.CRMException;
import com.v2crm.services.UserService;
import com.v2crm.services.UserTypeService;
import com.v2crm.util.DataList;

public class UserAction extends ActionSupport implements ServletRequestAware,
		ModelDriven<User> {

	private HttpServletRequest httpServletRequest;
	@Autowired
	private UserService userService;

	private DataList dataList;

	private User user;

	@Autowired
	private UserTypeService userTypeService;
	
	@Override
	public User getModel() {
		HttpSession session = httpServletRequest.getSession();

		if (httpServletRequest.getRequestURI().contains("/Display")) {
			user = new User();
			session.setAttribute("user", user);
		} else {
			user = (User) session.getAttribute("user");
		}

		return user;
	}

	public String display() {
		List<User> users = userService.findAll();
		String param = new ParamEncoder("dataList")
				.encodeParameterName(TableTagParameters.PARAMETER_PAGE);
		if (httpServletRequest != null) {
			dataList = new DataList(httpServletRequest);
			dataList.setList(users);
		} else {
			dataList = new DataList();
			dataList.setList(users);
		}

		httpServletRequest.setAttribute("data", dataList);
		return SUCCESS;
	}

	public String delete() {
		String userId = httpServletRequest.getParameter("id");
		if (userId != null) {
			userService.delete(Long.parseLong(userId));
		}

		List<User> users = userService.findAll();

		if (httpServletRequest != null) {
			dataList = new DataList(httpServletRequest);
			dataList.setList(users);
		} else {
			dataList = new DataList();
			dataList.setList(users);
		}

		httpServletRequest.setAttribute("data", dataList);
		return "delete_success";
	}

	public String edit() {
		HttpSession session = httpServletRequest.getSession();
		if (httpServletRequest.getParameter("id") != null) {
			Long userId = Long.parseLong(httpServletRequest.getParameter("id"));
			user = (User) userService.find(userId);
		}
		List<UserType> userTypeLst = userTypeService.findAll();
		user.setUserTypeLst(userTypeLst);
		session.setAttribute("user", user);
		
		return "edit_success";
	}

	public String save() {
		try {
			
			if (user.getId() == null) {
				UserType userType= (UserType)userTypeService.find(user.getUserType().getId());
				user.setUserType(userType);
				userService.save(user);
			} else {
				userService.saveOrUpdate(user);
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

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public DataList getDataList() {
		return dataList;
	}

	public void setDataList(DataList dataList) {
		this.dataList = dataList;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserTypeService getUserTypeService() {
		return userTypeService;
	}

	public void setUserTypeService(UserTypeService userTypeService) {
		this.userTypeService = userTypeService;
	}

}
