package com.v2crm.domain;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries({ @NamedQuery(name = "UserType.findByType", query = "SELECT c FROM UserType c WHERE c.userType = :userType")

})
public class UserType extends Base {
	@Column(unique = true, nullable = false)
	private String userType;

	@OneToMany(mappedBy = "userType",fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private List<ModulePermission> modulePermission;

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public List<ModulePermission> getModulePermission() {
		return modulePermission;
	}

	public void setModulePermission(List<ModulePermission> modulePermission) {
		this.modulePermission = modulePermission;
	}

}
/*
DROP TABLE IF EXISTS address;                    
DROP TABLE IF EXISTS campaign;                   
DROP TABLE IF EXISTS contact;                    
DROP TABLE IF EXISTS feature;                    
DROP TABLE IF EXISTS feature_usertypes;          
DROP TABLE IF EXISTS lead;                       
DROP TABLE IF EXISTS module;                     
DROP TABLE IF EXISTS oppurtunity;                
DROP TABLE IF EXISTS organization;               
DROP TABLE IF EXISTS user;                       
DROP TABLE IF EXISTS usertype;  
*/