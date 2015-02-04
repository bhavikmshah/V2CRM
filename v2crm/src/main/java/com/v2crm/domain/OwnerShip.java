package com.v2crm.domain;

public enum OwnerShip {
	Proprietory("Proprietory"), Private("Private"), Deemed_Limited("Deemed_Limited"), Limited("Limited"),Private_Limited("Private_Limited"), Public_Limited("Public_Limited"), Not_Specified("Not_Specified") ;
	private String msg;
	
	private OwnerShip(String mg){
		this.msg = mg;
	}

	public String getMsg() {
		return msg;
	}

}
