package com.v2crm.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity
@NamedQueries({
@NamedQuery(name="Organization.findOrganizationByName", query="SELECT org FROM Organization org WHERE org.orgName = :orgName"),
})
public class Organization extends Base{

	@Transient
	private static final long serialVersionUID = 1L;

	String orgName = "";
    
  
    
    String company = "";
    
    String primaryEmail = "";
    
    String primaryPhone = "";
    
   
    
    String mobile = "";
    
    String website = "";
    
    String fax = "";
    
    int numOfEmployers;

    
    private RevenueRange revenueRange = RevenueRange.Not_Specified;
    
   
    private Organization memberOf;
    
   
    private OwnerShip ownerShip = OwnerShip.Not_Specified;
    
    
    private OrganizationType organizationType = OrganizationType.Prospect;
    

    @Enumerated(EnumType.STRING)
    Industry industry = Industry.NotSpecified;
    
    @Enumerated(EnumType.STRING)
    LeadStatus orgStatus = LeadStatus.NotContacted;
    
    @Enumerated(EnumType.STRING)
    Rating rating = Rating.Warm;
	
    @OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    @JoinColumn(name="address_id",insertable=true, updatable=true)
    Address address = new Address();
    
    @Transient
    private Industry industriesLst[] = Industry.values();
  
    @Transient
    private OwnerShip ownershipsLst[] = OwnerShip.values(); 
    
    @Transient
	private State statesLst[] = State.values();
    
    @Transient
    private OrganizationType[] organizationTypeLst = OrganizationType.values();
    
    @Transient
    private RevenueRange[] revenueRangeLst=RevenueRange.values();
    
    @Transient
    private Rating ratingsLst[] = Rating.values();
    
    
   
	public OrganizationType[] getOrganizationTypeLst() {
		return organizationTypeLst;
	}


	public void setOrganizationTypeLst(OrganizationType[] organizationTypeLst) {
		this.organizationTypeLst = organizationTypeLst;
	}


	public RevenueRange[] getRevenueRangeLst() {
		return revenueRangeLst;
	}


	public void setRevenueRangeLst(RevenueRange[] revenueRangeLst) {
		this.revenueRangeLst = revenueRangeLst;
	}


	public Rating[] getRatings() {
		return ratingsLst;
	}


	public void setRatings(Rating[] ratingsLst) {
		this.ratingsLst = ratingsLst;
	}


	public String getCompany() {
		return company;
	}


	public void setCompany(String company) {
		this.company = company;
	}


	public String getPrimaryEmail() {
		return primaryEmail;
	}


	public void setPrimaryEmail(String primaryEmail) {
		this.primaryEmail = primaryEmail;
	}


	public String getPrimaryPhone() {
		return primaryPhone;
	}


	public void setPrimaryPhone(String primaryPhone) {
		this.primaryPhone = primaryPhone;
	}


	

	public String getMobile() {
		return mobile;
	}


	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	public String getWebsite() {
		return website;
	}


	public void setWebsite(String website) {
		this.website = website;
	}


	public String getFax() {
		return fax;
	}


	public void setFax(String fax) {
		this.fax = fax;
	}


	public int getNumOfEmployers() {
		return numOfEmployers;
	}


	public void setNumOfEmployers(int numOfEmployers) {
		this.numOfEmployers = numOfEmployers;
	}


	public Industry getIndustry() {
		return industry;
	}


	public void setIndustry(Industry industry) {
		this.industry = industry;
	}


	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}


	


	


	public LeadStatus getOrgStatus() {
		return orgStatus;
	}


	public void setOrgStatus(LeadStatus orgStatus) {
		this.orgStatus = orgStatus;
	}


	public Rating getRating() {
		return rating;
	}


	public void setRating(Rating rating) {
		this.rating = rating;
	}



	public String getOrgName() {
		return orgName;
	}


	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}


	


	public RevenueRange getRevenueRange() {
		return revenueRange;
	}


	public void setRevenueRange(RevenueRange revenueRange) {
		this.revenueRange = revenueRange;
	}


	public Organization getMemberOf() {
		return memberOf;
	}


	public void setMemberOf(Organization memberOf) {
		this.memberOf = memberOf;
	}


	public OwnerShip getOwnerShip() {
		return ownerShip;
	}


	public void setOwnerShip(OwnerShip ownerShip) {
		this.ownerShip = ownerShip;
	}


	public OrganizationType getOrganizationType() {
		return organizationType;
	}


	public void setOrganizationType(OrganizationType organizationType) {
		this.organizationType = organizationType;
	}


	public Industry[] getIndustriesLst() {
		return industriesLst;
	}


	public void setIndustriesLst(Industry[] industriesLst) {
		this.industriesLst = industriesLst;
	}


	public OwnerShip[] getOwnershipsLst() {
		return ownershipsLst;
	}


	public void setOwnershipsLst(OwnerShip[] ownershipsLst) {
		this.ownershipsLst = ownershipsLst;
	}


	public State[] getStatesLst() {
		return statesLst;
	}


	public void setStatesLst(State[] statesLst) {
		this.statesLst = statesLst;
	}


	public Rating[] getRatingsLst() {
		return ratingsLst;
	}


	public void setRatingsLst(Rating[] ratingsLst) {
		this.ratingsLst = ratingsLst;
	}
    
    
}
