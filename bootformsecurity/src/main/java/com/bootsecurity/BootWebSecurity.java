package com.bootsecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class BootWebSecurity {

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain httpSecurity(HttpSecurity http) throws Exception {
		// http.httpBasic().and().csrf().disable();
		http.formLogin().loginPage("/login.htm").loginProcessingUrl("/jLogin.htm").usernameParameter("j_username")
				.passwordParameter("j_password").and().logout().logoutSuccessUrl("/logout.htm")
				.logoutUrl("/j_logout.htm").invalidateHttpSession(true);
		http.csrf().disable();
		
		http.authorizeRequests().requestMatchers("/home.htm").permitAll().requestMatchers("/account.htm")
				.hasAuthority("manager");

		return http.build();
	}

	@Bean
	public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
		UserDetails userDetails = User.withUsername("bob").password(passwordEncoder().encode("welcome1"))
				.authorities("manager").build();

		UserDetails userDetails1 = User.withUsername("joe").password(passwordEncoder().encode("welcome2"))
				.authorities("manager").build();
		return new InMemoryUserDetailsManager(userDetails1, userDetails);

	}

}
