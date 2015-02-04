package com.v2crm.domain;

public enum LeadSource {
	ExistingCustomer("ExistingCustomer"), ColdCall("ColdCall"), AssignedByCoordinator("AssignedByCoordinator"), Advertisement("Advertisement"),
	AssignedByColleage("AssignedByColleage"), TeleMarketing("TeleMarketing"), CustomerInquiryByPhone("CustomerInquiryByPhone"), 
	CustomerInquiryByInternet("CustomerInquiryByInternet"),NotSpecified("NotSpecified");
	
	
	private String msg;
	
	LeadSource(String mg){
		this.msg = mg;
	}

	public String getMsg() {
		return msg;
	}
	
}
