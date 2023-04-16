package com.netbanking.service.beans;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


public class UserDetailsImpl implements UserDetails {

	private static final long serialVersionUID = -3720900319238407652L;
	private int accountId;
	private String emailAddress;
	private String password;;
	private String status;

	private List<GrantedAuthority> listAuthority = new ArrayList<>();

	
	
	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public UserDetailsImpl(int accountId,String emailAddress, String password, String status, String roleName) {
		this.accountId=accountId;
		this.emailAddress = emailAddress;
		this.password = password;
		this.status = status;
		listAuthority.add(new SimpleGrantedAuthority(roleName));
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return listAuthority;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return emailAddress;
	}

	@Override
	public boolean isAccountNonExpired() {
		return !status.equals("E");
	}

	@Override
	public boolean isAccountNonLocked() {
		return !status.equals("L");
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
