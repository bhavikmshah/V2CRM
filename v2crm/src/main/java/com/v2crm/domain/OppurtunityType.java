package com.v2crm.domain;

public enum OppurtunityType {
	NewBusiness("NewBusiness"), ExistingBusiness("ExistingBusiness"), Other("Other");
	private String msg;
	private OppurtunityType(String code){
		this.msg = code;
	}
	public String getMsg() {
		return msg;
	}
}
