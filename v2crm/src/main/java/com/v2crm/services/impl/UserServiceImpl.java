package com.v2crm.services.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpSession;

import junit.framework.Assert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.v2crm.dao.JPADAO;
import com.v2crm.dao.UserDAO;
import com.v2crm.domain.Feature;
import com.v2crm.domain.Module;
import com.v2crm.domain.ModulePermission;
import com.v2crm.domain.User;
import com.v2crm.domain.UserType;
import com.v2crm.exceptions.CRMException;
import com.v2crm.services.FeatureService;
import com.v2crm.services.ModuleService;
import com.v2crm.services.UserService;
import com.v2crm.services.UserTypeService;
@Service("userService")
@Transactional(propagation= Propagation.REQUIRED, rollbackFor=CRMException.class)
public class UserServiceImpl extends CRMServiceImpl<Long, User> implements UserService{
	
	private static String[] modules={"DASH","LEAD","CONT","OPPT","ORG","CPGN","DOCS","CLDR","RPTS","MAIL"};
	private static String[] modulesAdmin={"DASH","LEAD","CONT","OPPT","ORG","CPGN","DOCS","CLDR","RPTS","MAIL","USR","USRTYP"};
	@Autowired
    protected UserDAO userDAO;
	
	@Autowired
	 private UserTypeService userTypeService;
	
	@Autowired
	private FeatureService featureService;
	
	@Autowired
	private ModuleService moduleService;

	@PostConstruct
    public void init() throws Exception {
	 super.setDAO((JPADAO) userDAO);
    }
    
    @PreDestroy
    public void destroy() {
    }
    
    @Override
    public void setEntityManagerOnDao(EntityManager entityManager){
    	userDAO.setEntityManager(entityManager);
    }
    
    @Transactional
    public void setupData() throws CRMException{
    	setUpUserTypes();
    	setUpUsers();
    	assignFeaturesToAdmin();
    	assignFeaturesToSalesRep();
    	
    }
    
    void setUpUserTypes(){
    	UserType type1 = new UserType();
    	type1.setUserType("SalesRep");
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
    
    void setUpUsers(){
    	String userTypeQry = "UserType.findByType";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userType", "Admin");
		List<UserType> types = userTypeService.findByNamedQueryAndNamedParams(userTypeQry, params);
		if(types != null && types.size() > 0){
			UserType userType = (UserType) types.get(0);
			User user = new User();
			user.setFirstName("Jatin");
			user.setLastName("Sutaria");
			user.setUserName("admin");
			user.setPassword("admin123");
			user.setUserType(userType);
			user = (User) super.saveOrUpdate(user);
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
			user.setFirstName("Bhavik");
			user.setLastName("Shah");
			user.setUserName("jatin");
			user.setPassword("jatin");
			user.setUserType(userType);
			user = (User) super.saveOrUpdate(user);
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
			user = (User) super.saveOrUpdate(user);
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
			user = (User) super.saveOrUpdate(user);
			Assert.assertEquals(true, true);
		}
		else{
			Assert.assertEquals(true, false);
		}
    }
    
    void assignFeaturesToSalesRep(){
    	
    	String userTypeQry = "UserType.findByType";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userType", "SalesRep");
		List<UserType> types = userTypeService.findByNamedQueryAndNamedParams(userTypeQry, params);
		if(types != null && types.size() > 0){
			UserType userType = (UserType) types.get(0);
			
			List<ModulePermission> mpList = new ArrayList<ModulePermission>();
			for(String module:modules){
				ModulePermission perm = new ModulePermission();
				perm.setUserType(userType);
				perm.setModuleCode(module);
				perm.setReadModule(true);
				perm.setWriteModule(true);
				perm.setDeleteModule(true);
				mpList.add(perm);
			}
			userType.setModulePermission(mpList);
			
			userTypeService.saveOrUpdate(userType);
			
		}
			
    }
    
 void assignFeaturesToAdmin(){
    	
    	String userTypeQry = "UserType.findByType";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userType", "Admin");
		List<UserType> types = userTypeService.findByNamedQueryAndNamedParams(userTypeQry, params);
		if(types != null && types.size() > 0){
			UserType userType = (UserType) types.get(0);
			
			List<ModulePermission> mpList = new ArrayList<ModulePermission>();
			for(String module:modulesAdmin){
				ModulePermission perm = new ModulePermission();
				perm.setUserType(userType);
				perm.setModuleCode(module);
				perm.setReadModule(true);
				perm.setWriteModule(true);
				perm.setDeleteModule(true);
				mpList.add(perm);
			}
			userType.setModulePermission(mpList);
			
			userTypeService.saveOrUpdate(userType);
			
		}
			
    }
    
   
    
	@Override
	public UserDetails loadUserByUsername(String userName)
			throws UsernameNotFoundException {
		
		Map<String,String> paramMap = new HashMap<String,String>();
		paramMap.put("userName", userName);
		
		List<User> userLst= userDAO.findByNamedQueryAndNamedParams("User.findUserByName", paramMap);
		
		if(null!=userLst && userLst.size()>0 ){
			
		User user =userLst.get(0);
		setUserModlePermission(user);
		return user;
			
		}
		
		return null;
	}
    
    
public void setUserModlePermission(User user) {
		
		List<Module> moduleLst = moduleService.findAll();

		
		if(null!=user){
		UserType userType = user.getUserType();

		List<ModulePermission> permissionLst = userType.getModulePermission();

		List<ModulePermission> userAccesLst = new ArrayList<ModulePermission>();
		
		Map<String,ModulePermission> userTypeMpMap = new HashMap<String,ModulePermission>();
		
		for(ModulePermission mp: permissionLst){
			userTypeMpMap.put(mp.getModuleCode(), mp);
		}
		
		for(Module module : moduleLst){
						
				if(userTypeMpMap.containsKey(module.getModuleCode())){
					ModulePermission	mPermission =  userTypeMpMap.get(module.getModuleCode());
					if (mPermission.getReadModule() == false
							&& false == mPermission.getWriteModule()
							&& false == mPermission.getDeleteModule()) 
						continue;
				else{	
					ModulePermission modPerm=userTypeMpMap.get(module.getModuleCode());
					modPerm.setModuleName(module.getModuleName());
					modPerm.setCssClass(module.getCssClass());
					modPerm.setLink(module.getLink());
					//modPerm.setUserType(userType);
					userAccesLst.add(modPerm);
					}
				}
			}

		user.setUsersModuleAccessLst(userAccesLst);

		}
		
	}
    
}

