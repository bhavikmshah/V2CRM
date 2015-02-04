package com.v2crm.domain;

public enum LeadStatus {

	AttemptedToContact("AttemptedToContact"), Cold("Cold"), ContactInFuture("ContactInFuture"), Contacted("Contacted"), Hot("Hot"), LostLead("LostLead"), 
	NotContacted("NotContacted"), Warm("Warm"), NotSpecified("NotSpecified");
	private String msg;
	LeadStatus(String mg){
		this.msg = mg;
	}

	public String getMsg() {
		return msg;
	}

}
