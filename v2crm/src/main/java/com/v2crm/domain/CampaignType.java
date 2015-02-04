package com.v2crm.domain;

public enum CampaignType {
	Conference("Conference"), Telemarketing("Telemarketing"), DirectMail("DirectMail"), BannerAds("BannerAds"),
	Advertisement("Advertisement"), ReferralProgram("ReferralProgram"), Partners("Partners"), 
	PublicRelations("PublicRelations"),TradeShow("TradeShow"), Webinar("Webinar"), Others("Others");
	
	
	private String msg;
	
	CampaignType(String mg){
		this.msg = mg;
	}

	public String getMsg() {
		return msg;
	}
	
	

}
