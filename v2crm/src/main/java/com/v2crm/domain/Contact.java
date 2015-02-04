package com.v2crm.domain;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
@NamedQuery(name="Contact.findContactByName", query="SELECT contact FROM Contact contact WHERE contact.firstName = :firstName AND contact.lastName = :lastName"),
})
public class Contact extends Base{
	@Transient
	private static final long serialVersionUID = 1L;

	String firstName = "";
    
    String lastName = "";
    
    String company = "";
    
    String primaryEmail = "";
    
    String personalEmail = "";
    
    String officePhone = "";
    
    String mobilePhone = "";
    
    String homePhone = "";
    
    String designation = "";
    
    Date dateOfBirth;
    
   // @Transient
    //String dob = "";
    
    MessengerType messengerType = MessengerType.NotSpecified;
    
    String messengerID = "";
    
    String department = "";
    
    boolean reference;
    
    String reportsTo = "";
    
    String fax = "";
    
    boolean doNotCall;
  
   
    @Enumerated(EnumType.STRING)
    LeadSource contactSource = LeadSource.ColdCall;
  
	
    @OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    @JoinColumn(name="officeaddress_id",insertable=true, updatable=true)
    Address officeAddress = new Address();
    
    @OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    @JoinColumn(name="homeaddress_id",insertable=true, updatable=true)
    Address homeAddress = new Address();
    
    @OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    @JoinColumn(name="organization_id",insertable=true, updatable=true)
    Organization organization;
    
    @Transient
    private MessengerType[] messengerTypeLst = MessengerType.values();
    
    @Transient
    private LeadSource[] leadSourceLst = LeadSource.values();
    
    @Transient
	State statesLst[] = State.values();
    
	public State[] getStatesLst() {
		return statesLst;
	}

	public void setStatesLst(State[] statesLst) {
		this.statesLst = statesLst;
	}

	public MessengerType[] getMessengerTypeLst() {
		return messengerTypeLst;
	}

	public void setMessengerTypeLst(MessengerType[] messengerTypeLst) {
		this.messengerTypeLst = messengerTypeLst;
	}

	public LeadSource[] getLeadSourceLst() {
		return leadSourceLst;
	}

	public void setLeadSourceLst(LeadSource[] leadSourceLst) {
		this.leadSourceLst = leadSourceLst;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public String getPersonalEmail() {
		return personalEmail;
	}

	public void setPersonalEmail(String personalEmail) {
		this.personalEmail = personalEmail;
	}

	public String getOfficePhone() {
		return officePhone;
	}

	public void setOfficePhone(String officePhone) {
		this.officePhone = officePhone;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public MessengerType getMessengerType() {
		return messengerType;
	}

	public void setMessengerType(MessengerType messengerType) {
		this.messengerType = messengerType;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public boolean isReference() {
		return reference;
	}

	public void setReference(boolean reference) {
		this.reference = reference;
	}

	public String getReportsTo() {
		return reportsTo;
	}

	public void setReportsTo(String reportsTo) {
		this.reportsTo = reportsTo;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public boolean isDoNotCall() {
		return doNotCall;
	}

	public void setDoNotCall(boolean doNotCall) {
		this.doNotCall = doNotCall;
	}

	

	public LeadSource getContactSource() {
		return contactSource;
	}

	public void setContactSource(LeadSource contactSource) {
		this.contactSource = contactSource;
	}

	public Address getOfficeAddress() {
		return officeAddress;
	}

	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}

	public Address getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	public String getMessengerID() {
		return messengerID;
	}

	public void setMessengerID(String messengerID) {
		this.messengerID = messengerID;
	}

	/*public String getDob() {
		DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		if(getDateOfBirth() != null ){
			String formattedDate = formatter.format(getDateOfBirth());
			return formattedDate;
		}
		return "";
        
	}*/
	
	

}
