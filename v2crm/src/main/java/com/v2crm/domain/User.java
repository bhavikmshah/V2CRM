package com.v2crm.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "firstName",
		"lastName" }))

@NamedQueries({ @NamedQuery(name = "User.findUserByName", query = "SELECT user FROM User user WHERE user.userName = :userName"), })
@Entity
@Indexed
public class User extends Base implements UserDetails {
	@Transient
	private static final long serialVersionUID = 1L;

	@Field(index = org.hibernate.search.annotations.Index.YES, analyze = Analyze.YES, store = Store.NO)
	@Column(nullable = false)
	private String firstName;

	@Field(index = org.hibernate.search.annotations.Index.YES, analyze = Analyze.YES, store = Store.NO)
	@Column(nullable = false)
	private String lastName;

	private boolean isEmployee = true;

	@OneToOne(fetch = FetchType.EAGER,cascade=CascadeType.REMOVE)
	@JoinColumn(name = "userType_id")
	private UserType userType;

	@Column(nullable = false, unique = true)
	private String userName;

	@Column(nullable = false)
	private String password;

	@Transient
	private List<UserType> userTypeLst;
	
	@Transient
	private List<ModulePermission> usersModuleAccessLst;
	
	@Transient
	private boolean accountNonExpired = true;
	@Transient
    private boolean accountNonLocked = true;
	@Transient
    private boolean credentialsNonExpired = true;
	@Transient
    private boolean enabled = true;
    
	@Transient
	private Collection<? extends GrantedAuthority> authorities;
    
		
	public List<ModulePermission> getUsersModuleAccessLst() {
		return usersModuleAccessLst;
	}

	public void setUsersModuleAccessLst(List<ModulePermission> usersModuleAccessLst) {
		this.usersModuleAccessLst = usersModuleAccessLst;
	}

	public List<UserType> getUserTypeLst() {
		return userTypeLst;
	}

	public void setUserTypeLst(List<UserType> userTypeLst) {
		this.userTypeLst = userTypeLst;
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

	public boolean isEmployee() {
		return isEmployee;
	}

	public void setEmployee(boolean isEmployee) {
		this.isEmployee = isEmployee;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		if(null==authorities){
			List<GrantedAuthorityImpl> authorityLst = new ArrayList<GrantedAuthorityImpl>();
			List<ModulePermission> modulePermissionLst= this.getUsersModuleAccessLst();
			
			if(null!=modulePermissionLst){
				for(ModulePermission mp: modulePermissionLst ){
					
					if(mp.getReadModule()){
						GrantedAuthorityImpl authority = new GrantedAuthorityImpl();
						authority.setName(mp.getModuleCode()+"_R");
						authorityLst.add(authority);
					}
					if(mp.getWriteModule()){
						GrantedAuthorityImpl authority = new GrantedAuthorityImpl();
						authority.setName(mp.getModuleCode()+"_M");
						authorityLst.add(authority);
					}
					if(mp.getDeleteModule()){
						GrantedAuthorityImpl authority = new GrantedAuthorityImpl();
						authority.setName(mp.getModuleCode()+"_D");
						authorityLst.add(authority);
					}
					
				}
			}
			authorities=authorityLst;
		}
		return authorities;
		
	}

	@Override
	public String getUsername() {
		return userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}
	
	
	public static class GrantedAuthorityImpl implements GrantedAuthority {
		 
	    private static final long serialVersionUID = 1L;
	    private String name;
	    
	    public String getName() {
	        return name;
	    }
	 
	    public void setName(String name) {
	        this.name = name;
	    }
	 
	    @Override
	    public String getAuthority() {
	        return this.name;
	    }
	 
	}

}
