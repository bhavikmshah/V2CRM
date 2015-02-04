package com.v2crm.domain;

public enum OppurtunityStrategy {
	OneTime("OneTime"), CanLeadToMore("CanLeadToMore"), Strategic("Strategic");
	private String msg;
	private OppurtunityStrategy(String code){
		this.msg = code;
	}
	public String getMsg() {
		return msg;
	}
}
