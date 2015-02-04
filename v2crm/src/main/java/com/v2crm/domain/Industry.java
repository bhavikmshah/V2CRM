package com.v2crm.domain;

public enum Industry {
	
	Apparel("Apparel"), Hospitality("Hospitality"), Insurance("Insurance"), Machinery("Machinery"),
	Manufacturing("Manufacturing"), Media("Media"), NotForProfit("NotForProfit"), Recreation("Recreation"),
	Retail("Retail"), Shipping("Shipping"), Technology("Technology"), Telecomm("Telecomm"), Utilities("Utilities"), 
	Healthcare("Healthcare"), Govt("Govt"), FoodAndBeverages("FoodAndBeverages"), Banking("Banking"),
	Biotech("Biotech"), Consulting("Consulting"), Electronics("Electronics"), NotSpecified("NotSpecified");
	private String msg;
	
	Industry(String mg){
		this.msg = mg;
	}

	public String getMsg() {
		return msg;
	}
	
	

}
