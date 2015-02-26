package com.sivalabs.springsecurity;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class MyUserAuthenticationProvider implements AuthenticationProvider {
	
	private final CustomUserDetailsService customUserDetailsService;

	@Autowired
	public MyUserAuthenticationProvider(CustomUserDetailsService customUserDetailsService) {
		this.customUserDetailsService = customUserDetailsService;
	}

	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		DomainUsernamePasswordAuthenticationToken token = (DomainUsernamePasswordAuthenticationToken) authentication;
		String email = token.getName();
		String domain = token.getDomain();
		if(!"sivalabs.in".equalsIgnoreCase(domain)){
			throw new BadCredentialsException("Invalid domain");
		}
		SecurityUser securityUser = null;
		if (email != null) {
			securityUser = (SecurityUser) customUserDetailsService.loadUserByUsername(email);
		}
		if (securityUser == null) {
			throw new UsernameNotFoundException("Invalid username/password");
		}
		String password = securityUser.getPassword();
		if (!password.equals(token.getCredentials())) {
			throw new BadCredentialsException("Invalid username/password");
		}
		Collection<? extends GrantedAuthority> authorities = securityUser.getAuthorities();
		return new DomainUsernamePasswordAuthenticationToken(securityUser, password, domain, authorities);
	}

	public boolean supports(Class<?> authentication) {
		return DomainUsernamePasswordAuthenticationToken.class.equals(authentication);
	}
}
