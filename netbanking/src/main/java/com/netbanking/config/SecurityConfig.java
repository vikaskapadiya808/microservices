package com.netbanking.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.netbanking.security.service.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
@ComponentScan(basePackages = { "com.netbanking.service.beans", "com.netbanking.security.service" })
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private DaoAuthenticationProvider daoAuthenticationProvider;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(daoAuthenticationProvider);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		http.httpBasic().and().csrf().disable();
		http.formLogin().loginPage("/login.htm").loginProcessingUrl("/jLogin.htm").usernameParameter("j_username")
				.passwordParameter("j_password").and().logout().logoutSuccessUrl("/logout.htm")
				.logoutUrl("/j_logout.htm").invalidateHttpSession(true);
		http.csrf().disable();
		http.authorizeHttpRequests().antMatchers("/home.htm").permitAll().antMatchers("/account/find.htm")
				.hasAnyAuthority("customer", "manager", "clerk");
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider(PasswordEncoder passwordEncoder,
			UserDetailsServiceImpl userDetailsServiceImpl) {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setUserDetailsService(userDetailsServiceImpl);
		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder);
		return daoAuthenticationProvider;
	}
}
