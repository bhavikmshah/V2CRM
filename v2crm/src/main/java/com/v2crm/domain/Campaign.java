package com.v2crm.domain;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Transient;

@Entity
@NamedQueries({ @NamedQuery(name = "Campaign.findCampaignByName", query = "SELECT campaign FROM Campaign campaign WHERE campaign.campaignName = :campaignName"), })
public class Campaign extends Base {

	private String ownedBy = "";

	private String campaignName = "";

	private Date startDate;

	private Date endDate;

	private Long estimatedCost = 0l;

	private Long actualCost = 0l;

	private Long expectedRevenue = 0l;

	private Long actualRevenue = 0l;

	@Enumerated(EnumType.STRING)
	private CampaignType campaignType = CampaignType.Others;

	@Enumerated(EnumType.STRING)
	private CampaignStatus campaignStatus = CampaignStatus.Draft;

	@Enumerated(EnumType.STRING)
	private CampaignResponseType campaignResponseType = CampaignResponseType.NotApplicable;

	private Integer expectedResponseCount = 0;

	private Integer actualResponseCount = 0;

	@Transient
	private CampaignType campaignTypeLst[] = CampaignType.values();
	@Transient
	private CampaignStatus campaignStatusLst[] = CampaignStatus.values();
	@Transient
	private CampaignResponseType campaignResponseTypeLst[] = CampaignResponseType
			.values();

	public String getOwnedBy() {
		return ownedBy;
	}

	public void setOwnedBy(String ownedBy) {
		this.ownedBy = ownedBy;
	}

	public String getCampaignName() {
		return campaignName;
	}

	public void setCampaignName(String campaignName) {
		this.campaignName = campaignName;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Long getEstimatedCost() {
		return estimatedCost;
	}

	public void setEstimatedCost(Long estimatedCost) {
		this.estimatedCost = estimatedCost;
	}

	public Long getActualCost() {
		return actualCost;
	}

	public void setActualCost(Long actualCost) {
		this.actualCost = actualCost;
	}

	public Long getExpectedRevenue() {
		return expectedRevenue;
	}

	public void setExpectedRevenue(Long expectedRevenue) {
		this.expectedRevenue = expectedRevenue;
	}

	public Long getActualRevenue() {
		return actualRevenue;
	}

	public void setActualRevenue(Long actualRevenue) {
		this.actualRevenue = actualRevenue;
	}

	public CampaignType getCampaignType() {
		return campaignType;
	}

	public void setCampaignType(CampaignType campaignType) {
		this.campaignType = campaignType;
	}

	public CampaignStatus getCampaignStatus() {
		return campaignStatus;
	}

	public void setCampaignStatus(CampaignStatus campaignStatus) {
		this.campaignStatus = campaignStatus;
	}

	public CampaignResponseType getCampaignResponseType() {
		return campaignResponseType;
	}

	public void setCampaignResponseType(
			CampaignResponseType campaignResponseType) {
		this.campaignResponseType = campaignResponseType;
	}

	public Integer getExpectedResponseCount() {
		return expectedResponseCount;
	}

	public void setExpectedResponseCount(Integer expectedResponseCount) {
		this.expectedResponseCount = expectedResponseCount;
	}

	public Integer getActualResponseCount() {
		return actualResponseCount;
	}

	public void setActualResponseCount(Integer actualResponseCount) {
		this.actualResponseCount = actualResponseCount;
	}

	public CampaignType[] getCampaignTypeLst() {
		return campaignTypeLst;
	}

	public void setCampaignTypeLst(CampaignType[] campaignTypeLst) {
		this.campaignTypeLst = campaignTypeLst;
	}

	public CampaignStatus[] getCampaignStatusLst() {
		return campaignStatusLst;
	}

	public void setCampaignStatusLst(CampaignStatus[] campaignStatusLst) {
		this.campaignStatusLst = campaignStatusLst;
	}

	public CampaignResponseType[] getCampaignResponseTypeLst() {
		return campaignResponseTypeLst;
	}

	public void setCampaignResponseTypeLst(
			CampaignResponseType[] campaignResponseTypeLst) {
		this.campaignResponseTypeLst = campaignResponseTypeLst;
	}

	/*public void setStartDt(String startDt) {
		this.startDt = startDt;
	}

	public void setEndDt(String endDt) {
		this.endDt = endDt;
	}

	public String getStartDt() {
		DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		if (getStartDate() != null) {
			String formattedDate = formatter.format(getStartDate());
			return formattedDate;
		}
		return "";
	}

	public String getEndDt() {
		DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		if (getEndDate() != null) {
			String formattedDate = formatter.format(getEndDate());
			return formattedDate;
		}
		return "";
	}*/

}
