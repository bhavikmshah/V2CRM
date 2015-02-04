package com.v2.services.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.v2crm.domain.Address;
import com.v2crm.domain.Campaign;
import com.v2crm.domain.CampaignResponseType;
import com.v2crm.domain.CampaignStatus;
import com.v2crm.domain.CampaignType;
import com.v2crm.domain.Contact;
import com.v2crm.domain.Industry;
import com.v2crm.domain.Lead;
import com.v2crm.domain.Oppurtunity;
import com.v2crm.domain.OppurtunityStrategy;
import com.v2crm.domain.OppurtunityType;
import com.v2crm.domain.Organization;
import com.v2crm.domain.OwnerShip;
import com.v2crm.domain.State;
import com.v2crm.exceptions.CRMException;
import com.v2crm.services.CampaignService;
import com.v2crm.services.ContactService;
import com.v2crm.services.LeadService;
import com.v2crm.services.OppurtunityService;
import com.v2crm.services.OrganizationService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:appContext.xml"})
@Transactional
public class CRMServiceTest {
	@Autowired
	LeadService leadService;
	
	@Autowired
	OrganizationService organizationService;
	
	@Autowired
	CampaignService campaignService;
	
	@Autowired
	OppurtunityService oppurtunityService;
	
	@Autowired
	ContactService contactService;
	
	@Test
	@Rollback(value=false)
	public void testLeadCreation(){
		try {
			for(int i=0;i<20;i++){
				Lead lead = new Lead();
				lead.setCompany("Company"+i);
				lead.setDesignation("Executive");
				lead.setFirstName("Ram"+i);
				lead.setIndustry(Industry.Banking);
				lead.setLastName("Kadam");
				lead.setMobile("8686878");
				lead.setPrimaryEmail("rrt@trt.com");
				lead.setWebsite("www.comp1.com");
				Address address = new Address();
				address.setBldg("mount view"+i);
				address.setCity("Mumbai");
				address.setOfficeNumber("502"+i);
				address.setPin("400080"+i);
				address.setStreet("Off Bal rajeshwar rd");
				address.setState(State.Maharashtra);
				lead.setAddress(address);
				leadService.save(lead);
			}
			
		} catch (CRMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Assert.assertTrue(false);
		}
		
	}
	
	@Test
	@Rollback(value=false)
	public void testcreateOrganizations(){
		try {
			for(int i=0;i<20;i++){
				Organization org = new Organization();
				org.setOrgName("Abc Electronics"+i);
				org.setCompany("Company"+i);
				//org.setDesignation("Executive");
				org.setOwnerShip(OwnerShip.Deemed_Limited);
				
				org.setIndustry(Industry.Banking);
				
				org.setMobile("8686878");
				org.setPrimaryEmail("rrt@trt.com");
				org.setWebsite("www.comp1.com");
				Address address = new Address();
				address.setBldg("mount view"+i);
				address.setCity("Mumbai");
				address.setOfficeNumber("502"+i);
				address.setPin("400080"+i);
				address.setStreet("Off Bal rajeshwar rd");
				address.setState(State.Maharashtra);
				org.setAddress(address);
				organizationService.save(org);
			}
			
		} catch (CRMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}
	
	
	@Test
	@Rollback(value=false)
	public void testcreateContact(){
		try {
			
				Contact contact = new Contact();
				contact.setCompany("Def Enterprises");
				contact.setFirstName("jatin");
				contact.setLastName("sutaria");
				contactService.save(contact);
			
			
		} catch (CRMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}
	
	
	
	@Test
	@Rollback(value=false)
	public void testCampaign(){
		try {
			for(int i=0;i<25;i++){
				Campaign campaign = new Campaign();
				campaign.setActualCost(434343l);
				campaign.setActualResponseCount(35);
				campaign.setActualRevenue(24242l);
				campaign.setCampaignName("Conference At Atlanta"+i);
				campaign.setCampaignResponseType(CampaignResponseType.Good);
				campaign.setCampaignStatus(CampaignStatus.Active);
				campaign.setCampaignType(CampaignType.Conference);
				//campaign.setEndDate(endDate);
				campaign.setEstimatedCost(432424l);
				campaign.setOwnedBy("Jatin");
				campaign.setExpectedResponseCount(200);
				campaignService.save(campaign);
			}
			Assert.assertEquals(true, true);
		} catch (CRMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Assert.assertEquals(true, false);
		}
		
	}
	
	@Test
	@Rollback(value=false)
	public void testOppurtunity(){
		String fieldQry = "Campaign.findCampaignByName";
		Map<String, String> params = new HashMap<String, String>();
		params.put("campaignName", "Conference At Atlanta1");
		List<Campaign> campaigns = campaignService.findByNamedQueryAndNamedParams(fieldQry, params);
		Campaign campaign = campaigns.get(0);

		
		fieldQry = "Organization.findOrganizationByName";
		params = new HashMap<String, String>();
		params.put("orgName", "Abc Electronics1");
		List<Organization> organizations = organizationService.findByNamedQueryAndNamedParams(fieldQry, params);
		Organization org = organizations.get(0);
		
		fieldQry = "Contact.findContactByName";
		params = new HashMap<String, String>();
		params.put("firstName", "jatin");
		params.put("lastName", "sutaria");
		List<Contact> contacts = contactService.findByNamedQueryAndNamedParams(fieldQry, params);
		Contact contact = contacts.get(0);

		try {
			for(int i=0;i<25;i++){
				Oppurtunity oppurtunity = new Oppurtunity();
				oppurtunity.setAmount(2121l);
				oppurtunity.setCampaign(campaign);
				oppurtunity.setContact(contact);
				oppurtunity.setOrganization(org);
				oppurtunity.setOppurtunityStrategy(OppurtunityStrategy.Strategic);
				oppurtunity.setOppurtunityType(OppurtunityType.NewBusiness);
				oppurtunity.setOppurtunityName("Oppurtunity"+i);
				oppurtunityService.save(oppurtunity);
				//oppurtunity.s
			}
			Assert.assertEquals(true, true);
		} catch (CRMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Assert.assertEquals(true, false);
		}
	}
	
	@Test
	@Rollback(value=false)
	public void testContacts(){
//		try {
//			for(int i=0;i<20;i++){
//				Contact org = new Organization();
//				org.setOrgName("Abc Electronics"+i);
//				org.setCompany("Company"+i);
//				//org.setDesignation("Executive");
//				org.setOwnerShip(OwnerShip.Deemed_Limited);
//				
//				org.setIndustry(Industry.Banking);
//				
//				org.setMobile("8686878");
//				org.setPrimaryEmail("rrt@trt.com");
//				org.setWebsite("www.comp1.com");
//				Address address = new Address();
//				address.setBldg("mount view"+i);
//				address.setCity("Mumbai");
//				address.setOfficeNumber("502"+i);
//				address.setPin("400080"+i);
//				address.setStreet("Off Bal rajeshwar rd");
//				address.setState(State.Maharashtra);
//				org.setAddress(address);
//				organizationService.save(org);
//			}
//			
//		} catch (CRMException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			Assert.assertTrue(false);
//		}
	}

}
