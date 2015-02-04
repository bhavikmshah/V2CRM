package com.v2crm.domain;

public enum CampaignResponseType {
	Excellent("Excellent"), Good("Good"), Average("Average"), Poor("Poor"),
	NotApplicable("NotApplicable");
	
	
	private String msg;
	
	CampaignResponseType(String mg){
		this.msg = mg;
	}

	public String getMsg() {
		return msg;
	}
}
