package com.xworkz.demo.configuration;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import lombok.extern.slf4j.Slf4j;

@Configuration
@ComponentScan("com.xworkz.demo")
@Slf4j
public class FamConfig {
	
	public FamConfig() {
		log.info("Constructor is Created in : " + this.getClass().getSimpleName());
	}

	@Bean
	public MultipartResolver multipartResolver() {
		log.info("Registering MultipartResolver in FamConfiguration");
		return new StandardServletMultipartResolver();
	}

	@Bean // prefix and sufix add madoke
	public ViewResolver viewResolver() {
		log.info("Running ViewResolver in FamConfiguration");
		return new InternalResourceViewResolver("/", ".jsp");

	}

	@Bean // EMF instance create madoke //spring and jsp na integrate
	public LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean(DataSource dataSource) {
		log.info("Running localContainerEntityManagerFactoryBean in FamConfiguration");
		LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
		bean.setPackagesToScan("com.xworkz.demo");
		bean.setDataSource(dataSource());
		bean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		return bean;

	}

	@Bean
	public DataSource dataSource() {
		log.info("Registering Datasource in FamConfiguration");
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/java");
		dataSource.setPassword("Xworkzodc@123");
		dataSource.setUsername("root");
		return dataSource;
	}
	
	@Bean
    public PasswordEncoder passwordEncoder() {
		log.info("Running PasswordEncoder() Method in FamConfiguration");
        return new BCryptPasswordEncoder();
    }
}
