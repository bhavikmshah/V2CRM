package com.v2crm.domain;

public enum OrganizationType {
Analyst("Analyst"), Reseller("Reseller"), Prospect("Prospect"), Press("Press"),Partner("Partner"), Investor("Investor"), 
Integrator("Integrator"), Customer("Customer"), Competitor("Competitor"), Other("Other");
	private String msg;
	
	
	
	OrganizationType(String mg){
		this.msg = mg;
	}

	public String getMsg() {
		return msg;
	}

}
