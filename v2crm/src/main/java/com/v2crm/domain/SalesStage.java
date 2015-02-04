package com.v2crm.domain;

public enum SalesStage {
Prospecting("Prospecting"), ClosedWon("ClosedWon"), Negotiation("Negotiation"), Proposal("Proposal"), Analysis("Analysis"), IdentifyDecisionMakers("IdentifyDecesionMakers"), NeedsAnalysis("NeedsAnalysis"), Qualification("Qualification"), Lost("Lost"), CouldNotQualify("CouldNotQualify"), Other("Other");
	private String msg;
	private SalesStage(String code){
		this.msg = code;
	}
	public String getMsg() {
		return msg;
	}
	
	
	
}
