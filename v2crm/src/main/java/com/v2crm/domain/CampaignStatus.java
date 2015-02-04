package com.v2crm.domain;

public enum CampaignStatus {
	Planning("Planning"), Active("Active"), InActive("InActive"), Completed("Completed"),
	Cancelled("Cancelled"), InProgress("InProgress"), Queued("Queued"), 
	Draft("Draft"),Sent("Sent"), Failed("Failed");
	
	
	private String msg;
	
	CampaignStatus(String mg){
		this.msg = mg;
	}

	public String getMsg() {
		return msg;
	}
}
