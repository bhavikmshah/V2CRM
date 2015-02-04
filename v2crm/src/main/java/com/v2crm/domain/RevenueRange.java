package com.v2crm.domain;

public enum RevenueRange {
	LessThanMillion("LessThanMillion"), MillionToTenMillion("MillionToTenMillion"), TenMillionToFiftyMillion("TenMillionToFiftyMillion"), FiftyMillionToHundredMillion("FiftyMillionToHundredMillion"),MoreThanHundredMillion("MoreThanHundredMillion"), Not_Specified("Not_Specified") ;
	private String msg;
	
	private RevenueRange(String mg){
		this.msg = mg;
	}

	public String getMsg() {
		return msg;
	}
}
