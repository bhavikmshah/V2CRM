package com.v2crm.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@NamedQueries({
@NamedQuery(name="Module.getModuleMapByCode", query="select new map(m.moduleCode, m) from Module m"),
})
@Entity
public class Module extends Base{

	@Column(nullable=false, unique=true)
	private String moduleCode;
	
	@Column(nullable=false, unique=true)
	private String moduleName;
	
	private String link; 
	
	public String getCssClass() {
		return cssClass;
	}
	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}
	private String cssClass;
		
	public String getModuleCode() {
		return moduleCode;
	}
	public void setModuleCode(String moduleCode) {
		this.moduleCode = moduleCode;
	}
	public String getModuleName() {
		return moduleName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	
	
	
}
