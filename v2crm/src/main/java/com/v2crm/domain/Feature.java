package com.v2crm.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
    @NamedQuery(name="Feature.findFeaturesByUserType",
                query="SELECT f FROM Feature f join f.userTypes u where u.userType = :userType")
   
}) 
public class Feature extends Base{

	@Column(nullable=false, unique=true)
	private String featureName;
	
//	@Column(nullable=true, unique=true)
//	private String featurePage;
	
	@ManyToMany
    @JoinTable(name="Feature_UserTypes", joinColumns={@JoinColumn(name="feature_id")}, inverseJoinColumns={@JoinColumn(name="userType_id")})
    private List<com.v2crm.domain.UserType> userTypes = new ArrayList<UserType>();;

	public String getFeatureName() {
		return featureName;
	}

	public void setFeatureName(String featureName) {
		this.featureName = featureName;
	}

//	public String getFeaturePage() {
//		return featurePage;
//	}
//
//	public void setFeaturePage(String featurePage) {
//		this.featurePage = featurePage;
//	}

	public List<com.v2crm.domain.UserType> getUserTypes() {
		return userTypes;
	}

	public void setUserTypes(List<com.v2crm.domain.UserType> userTypes) {
		this.userTypes = userTypes;
	}
	
	


}
