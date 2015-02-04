package com.v2crm.domain;

public enum Rating {
VeryHot("VeryHot"), Hot("Hot"), Warm("Warm"), NotSoWarm("NotSoWarm"),Cold("Cold"), NotApplicable("NotApplicable");
	private String msg;
	Rating(String mg){
		this.msg = mg;
	}

	public String getMsg() {
		return msg;
	}

}
