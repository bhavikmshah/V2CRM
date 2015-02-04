package com.v2crm.domain;

public enum MessengerType {
	
	Yahoo("Yahoo"), WhatsApp("WhatsApp"), Skype("Skype"), Google("Google"), LinkedLn("LinkedLn"), WindowsLive("WindowsLive"), 
	Facebook("Facebook"), Other("Other"), NotSpecified("NotSpecified");
	private String msg;
	
	MessengerType(String mg){
		this.msg = mg;
	}

	public String getMsg() {
		return msg;
	}
}
