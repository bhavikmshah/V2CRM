package com.v2.services.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.v2crm.domain.Feature;
import com.v2crm.domain.User;
import com.v2crm.domain.UserType;
import com.v2crm.services.FeatureService;
import com.v2crm.services.UserService;
import com.v2crm.services.UserTypeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:appCtx1.xml"})
@Transactional
public class UserServiceTest {

	@Autowired
	UserService userService;
	
	@Autowired
	UserTypeService userTypeService;
	
	@Autowired
	FeatureService featureService;
	
	@Test
	@Rollback(value=false)
	@Transactional
	public void testSetUpInitData(){
		userService.setupData();
		
		
	}
	
	@Test
	public void testUserTypeCreation(){
	UserType type1 = new UserType();
	type1.setUserType("Admin");
	userTypeService.save(type1);
	
	type1 = new UserType();
	type1.setUserType("Admin");
	userTypeService.save(type1);
	
	type1 = new UserType();
	type1.setUserType("SalesManager");
	userTypeService.save(type1);
	
	type1 = new UserType();
	type1.setUserType("CoordinationManager");
	userTypeService.save(type1);
	
	type1 = new UserType();
	type1.setUserType("SalesHead");
	userTypeService.save(type1);
	
	type1 = new UserType();
	type1.setUserType("CEO");
	userTypeService.save(type1);
	
	type1 = new UserType();
	type1.setUserType("Support");
	userTypeService.save(type1);

	}
	
	//@Test
	//@Rollback(value=false)
	public void testUserCreation(){
		String userTypeQry = "UserType.findByType";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userType", "Admin");
		List<UserType> types = userTypeService.findByNamedQueryAndNamedParams(userTypeQry, params);
		if(types != null && types.size() > 0){
			UserType userType = (UserType) types.get(0);
			User user = new User();
			user.setFirstName("Vraj");
			user.setLastName("Sutaria");
			user.setUserName("vraj");
			user.setPassword("vraj");
			user.setUserType(userType);
			user = (User) userService.saveOrUpdate(user);
			Assert.assertEquals(true, true);
		}
		else{
			Assert.assertEquals(true, false);
		}
		
		userTypeQry = "UserType.findByType";
		params = new HashMap<String, Object>();
		params.put("userType", "SalesRep");
		types = userTypeService.findByNamedQueryAndNamedParams(userTypeQry, params);
		if(types != null && types.size() > 0){
			UserType userType = (UserType) types.get(0);
			User user = new User();
			user.setFirstName("Jatin");
			user.setLastName("Sutaria");
			user.setUserName("jatin");
			user.setPassword("jatin");
			user.setUserType(userType);
			user = (User) userService.saveOrUpdate(user);
			Assert.assertEquals(true, true);
		}
		else{
			Assert.assertEquals(true, false);
		}
		
		userTypeQry = "UserType.findByType";
		params = new HashMap<String, Object>();
		params.put("userType", "CoordinationManager");
		types = userTypeService.findByNamedQueryAndNamedParams(userTypeQry, params);
		if(types != null && types.size() > 0){
			UserType userType = (UserType) types.get(0);
			User user = new User();
			user.setFirstName("Mahesh");
			user.setLastName("Laddha");
			user.setUserName("mahesh");
			user.setPassword("mahesh");
			user.setUserType(userType);
			user = (User) userService.saveOrUpdate(user);
			Assert.assertEquals(true, true);
		}
		else{
			Assert.assertEquals(true, false);
		}
		
		userTypeQry = "UserType.findByType";
		params = new HashMap<String, Object>();
		params.put("userType", "CEO");
		types = userTypeService.findByNamedQueryAndNamedParams(userTypeQry, params);
		if(types != null && types.size() > 0){
			UserType userType = (UserType) types.get(0);
			User user = new User();
			user.setFirstName("Jai");
			user.setLastName("Kisan");
			user.setUserName("jai");
			user.setPassword("jai");
			user.setUserType(userType);
			user = (User) userService.saveOrUpdate(user);
			Assert.assertEquals(true, true);
		}
		else{
			Assert.assertEquals(true, false);
		}
	}
	
	//@Test
	//@Rollback(value=false)
	public void testCreateFeature(){
		String userTypeQry = "UserType.findByType";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userType", "SalesRep");
		List<UserType> types = userTypeService.findByNamedQueryAndNamedParams(userTypeQry, params);
		if(types != null && types.size() > 0){
			UserType userType = (UserType) types.get(0);
			Feature feature = new Feature();
			feature.setFeatureName("Leads");
			//feature.setFeaturePage("contacts.jsp");
			List<UserType> userTypes = new ArrayList<UserType>();
			userTypes.add(userType);
			feature.setUserTypes(userTypes);
			featureService.save(feature);
			
			feature = new Feature();
			feature.setFeatureName("Contacts");
			//feature.setFeaturePage("contacts.jsp");
			userTypes = new ArrayList<UserType>();
			userTypes.add(userType);
			feature.setUserTypes(userTypes);
			featureService.save(feature);
			
			feature = new Feature();
			feature.setFeatureName("Organizations");
			//feature.setFeaturePage("contacts.jsp");
			userTypes = new ArrayList<UserType>();
			userTypes.add(userType);
			feature.setUserTypes(userTypes);
			featureService.save(feature);
			
			feature = new Feature();
			feature.setFeatureName("Campaigns");
			//feature.setFeaturePage("contacts.jsp");
			userTypes = new ArrayList<UserType>();
			userTypes.add(userType);
			feature.setUserTypes(userTypes);
			featureService.save(feature);
			
			feature = new Feature();
			feature.setFeatureName("Oppurtunities");
			//feature.setFeaturePage("contacts.jsp");
			userTypes = new ArrayList<UserType>();
			userTypes.add(userType);
			feature.setUserTypes(userTypes);
			featureService.save(feature);
			Assert.assertEquals(true, true);
		}
		else{
			Assert.assertEquals(true, false);
		}
	}
	
	@Test
	@Rollback(value=false)
	public void testFetchFeaturesByRole(){
		String userTypeQry = "Feature.findFeaturesByUserType";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userType", "Admin");
		List<Feature> features = featureService.findByNamedQueryAndNamedParams(userTypeQry, params);
			if(features != null && features.size() > 0){
				Assert.assertEquals(true, true);
			}
			else{
				Assert.assertEquals(true, false);
			}
	}

}
