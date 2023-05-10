package com.xworkz.ornaments.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan("com.xworkz")
public class OrnamentsConfiguration {
	public OrnamentsConfiguration() {
		System.out.println("Constructor is Created in : " + this.getClass().getSimpleName());
	}

	@Bean
	public ViewResolver viewResolver() {
		System.out.println("Registering Custom View Resolver in OrnamentsConfiguration ");
		return new InternalResourceViewResolver("/", ".jsp");
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean bean() {
		System.out.println("Registering local entity bean OrnamentsConfiguration");
		return new LocalContainerEntityManagerFactoryBean();
	}
	
	@Bean  // Used to process html from which is enctype.
	public MultipartResolver multipartResolver() {
		System.out.println("Registering MultipartResolver ");
		return new StandardServletMultipartResolver();
	}
}


