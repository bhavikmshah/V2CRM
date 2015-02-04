package com.v2crm.web.displaytag.decorators;

import org.displaytag.decorator.TableDecorator;

import com.v2crm.domain.Base;
import com.v2crm.domain.Campaign;
import com.v2crm.domain.Oppurtunity;
import com.v2crm.domain.Organization;
import com.v2crm.domain.User;
import com.v2crm.domain.UserType;

public class DisplayTableDecorator extends TableDecorator{
	/**
	 * Lead Entity
	**/
	public String getEditLink(){
		Base base = (Base)getCurrentRowObject();
		return "<A HREF=\"EditLead?id="+base.getId()+"\"><img src=\"images/Edit.png\"></A>";
		//return "<a href=\"images/Edit.png?index=" + lIndex + "\"\>" + lObject.getId() + "\</a\>";
	}
	
	public String getDeleteLink(){
		Base base = (Base)getCurrentRowObject();
		return "<A HREF=\"DeleteLead?id="+base.getId()+"\"><img src=\"images/Delete.png\"></A>";
		//return "<a href=\"images/Edit.png?index=" + lIndex + "\"\>" + lObject.getId() + "\</a\>";
	}
	
	/**
	 * Organization Entity
	**/
	
	public String getOrganizationType(){
		Organization org = (Organization)getCurrentRowObject();
		if(org != null){
			return org.getOrganizationType().getMsg();
			//return "<A HREF=\"EditOrganization?id="+org.getId()+"\"><img src=\"images/Edit.png\"></A>";
		}
		return "";
	}
	
	public String getRevenueRange(){
		Organization org = (Organization)getCurrentRowObject();
		if(org != null){
			return org.getRevenueRange().getMsg();
			
		}
		return "";
	}
	
	public String getIndustryForOrg(){
		Organization org = (Organization)getCurrentRowObject();
		if(org != null){
			return org.getIndustry().getMsg();
			//return "<A HREF=\"EditOrganization?id="+org.getId()+"\"><img src=\"images/Edit.png\"></A>";
		}
		return "";
	}
	
	public String getEditLinkForOrg(){
		Base base = (Base)getCurrentRowObject();
		return "<A HREF=\"EditOrganization?id="+base.getId()+"\"><img src=\"images/Edit.png\"></A>";
		//return "<a href=\"images/Edit.png?index=" + lIndex + "\"\>" + lObject.getId() + "\</a\>";
	}
	
	public String getDeleteLinkForOrg(){
		Base base = (Base)getCurrentRowObject();
		return "<A HREF=\"DeleteOrganization?id="+base.getId()+"\"><img src=\"images/Delete.png\"></A>";
		//return "<a href=\"images/Edit.png?index=" + lIndex + "\"\>" + lObject.getId() + "\</a\>";
	}
	
	
	/**
	 * Contact Entity
	**/
	
	public String getEditLinkForContact(){
		Base base = (Base)getCurrentRowObject();
		return "<A HREF=\"EditContact?id="+base.getId()+"\"><img src=\"images/Edit.png\"></A>";
		//return "<a href=\"images/Edit.png?index=" + lIndex + "\"\>" + lObject.getId() + "\</a\>";
	}
	
	public String getDeleteLinkForContact(){
		Base base = (Base)getCurrentRowObject();
		return "<A HREF=\"DeleteContact?id="+base.getId()+"\"><img src=\"images/Delete.png\"></A>";
		//return "<a href=\"images/Edit.png?index=" + lIndex + "\"\>" + lObject.getId() + "\</a\>";
	}
	
	
	/**
	 * Campaign Entity
	**/
	
	public String getCampaignType(){
		Campaign campaign = (Campaign)getCurrentRowObject();
		if(campaign != null){
			return campaign.getCampaignType().getMsg();
			
		}
		return "";
	}
	
	
	
	public String getCampaignResponseType(){
		Campaign campaign = (Campaign)getCurrentRowObject();
		if(campaign != null){
			return campaign.getCampaignResponseType().getMsg();
			
		}
		return "";
	}
	
	public String getCampaignStatus(){
		Campaign campaign = (Campaign)getCurrentRowObject();
		if(campaign != null){
			return campaign.getCampaignStatus().getMsg();
			
		}
		return "";
	}
	
	public String getEditCampaignLink(){
		Base base = (Base)getCurrentRowObject();
		return "<A HREF=\"EditCampaign?id="+base.getId()+"\"><img src=\"images/Edit.png\"></A>";
	}
	
	public String getDeleteCampaignLink(){
		Base base = (Base)getCurrentRowObject();
		return "<A HREF=\"DeleteCampaign?id="+base.getId()+"\"><img src=\"images/Delete.png\"></A>";
	}
	
	/**
	 * Oppurtunity Entity
	**/
	public String getOppurtunitySalesStage(){
		Oppurtunity oppurtunity = (Oppurtunity)getCurrentRowObject();
		if(oppurtunity != null){
			return oppurtunity.getSalesStage().getMsg();
			
		}
		return "";
	}
	
	public String getOppurtunityStrategy(){
		Oppurtunity oppurtunity = (Oppurtunity)getCurrentRowObject();
		if(oppurtunity != null){
			return oppurtunity.getOppurtunityStrategy().getMsg();
			
		}
		return "";
	}
	
	public String getOppurtunityType(){
		Oppurtunity oppurtunity = (Oppurtunity)getCurrentRowObject();
		if(oppurtunity != null){
			return oppurtunity.getOppurtunityType().getMsg();
			
		}
		return "";
	}
	
	public String getContactForOppurtunity(){
		Oppurtunity oppurtunity = (Oppurtunity)getCurrentRowObject();
		if(oppurtunity != null){
			if(oppurtunity.getContact() != null){
				return oppurtunity.getContact().getFirstName() +" "+oppurtunity.getContact().getLastName();
			}
		}
		return "";
	}
	
	public String getEditOppurtunityLink(){
		Base base = (Base)getCurrentRowObject();
		return "<A HREF=\"EditOppurtunity?id="+base.getId()+"\"><img src=\"images/Edit.png\"></A>";
	}
	
	public String getDeleteOppurtunityLink(){
		Base base = (Base)getCurrentRowObject();
		return "<A HREF=\"DeleteOppurtunity?id="+base.getId()+"\"><img src=\"images/Delete.png\"></A>";
	}

	public String getUserName(){
		User user = (User)getCurrentRowObject();
		return user.getUserName();
	}
	
	public String getUserUserType(){
		User user = (User)getCurrentRowObject();
		return user.getUserType().getUserType();
	}
	
	public String getUserType(){
		UserType userType = (UserType)getCurrentRowObject();
		return userType.getUserType();
	}
	
	public String getEditUserLink(){
		Base base = (Base)getCurrentRowObject();
		return "<A HREF=\"EditUser?id="+base.getId()+"\"><img src=\"images/Edit.png\"></A>";
	}
	
	public String getDeleteUserLink(){
		Base base = (Base)getCurrentRowObject();
		return "<A HREF=\"DeleteUser?id="+base.getId()+"\"><img src=\"images/Edit.png\"></A>";
	}
	
	public String getEditUserTypeLink(){
		Base base = (Base)getCurrentRowObject();
		return "<A HREF=\"EditUserType?id="+base.getId()+"\"><img src=\"images/Edit.png\"></A>";
	}
	
	public String getDeleteUserTypeLink(){
		Base base = (Base)getCurrentRowObject();
		return "<A HREF=\"DeleteUserType?id="+base.getId()+"\"><img src=\"images/Edit.png\"></A>";
	}
	
}

