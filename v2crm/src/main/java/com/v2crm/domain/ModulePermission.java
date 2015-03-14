package com.v2crm.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name="module_permission")
public class ModulePermission extends Base{

	@Transient
	private static final long serialVersionUID = 1L;
	
	private String moduleCode;
	
	@Transient
	private String moduleName;

	@ManyToOne
	@JoinColumn(name = "userType_id")
	private UserType userType;

	private boolean readModule;
	private boolean writeModule;
	private boolean deleteModule;
	
	private String link;
	private String cssClass;
	
		
	public String getModuleCode() {
		return moduleCode;
	}

	public void setModuleCode(String moduleCode) {
		this.moduleCode = moduleCode;
	}

	public UserType getUserType() {
		return userType;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getCssClass() {
		return cssClass;
	}

	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}


	public boolean getReadModule() {
		return readModule;
	}

	public void setReadModule(boolean readModule) {
		this.readModule = readModule;
	}

	public boolean getWriteModule() {
		return writeModule;
	}

	public void setWriteModule(boolean writeModule) {
		this.writeModule = writeModule;
	}

	public boolean getDeleteModule() {
		return deleteModule;
	}

	public void setDeleteModule(boolean deleteModule) {
		this.deleteModule = deleteModule;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	

	
}
