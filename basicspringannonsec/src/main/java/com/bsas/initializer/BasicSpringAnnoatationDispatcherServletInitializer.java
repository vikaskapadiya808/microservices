package com.bsas.initializer;

import javax.servlet.Filter;

import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.bsas.config.RootConfig;
import com.bsas.config.WebMvcConfig;
import com.bsas.config.WebSecurityConfig;

public class BasicSpringAnnoatationDispatcherServletInitializer
		extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] { RootConfig.class, WebSecurityConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] {WebMvcConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "*.htm" };

	}

	/*
	 * @Override protected javax.servlet.Filter[] getServletFilters() {
	 * DelegatingFilterProxy delegateFilterProxy = new DelegatingFilterProxy();
	 * delegateFilterProxy.setTargetBeanName("springSecurityFilterChain"); return
	 * new Filter[]{delegateFilterProxy}; }
	 */
}
