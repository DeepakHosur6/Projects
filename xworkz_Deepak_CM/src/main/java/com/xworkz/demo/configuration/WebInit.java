package com.xworkz.demo.configuration;

import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@EnableWebMvc
public class WebInit extends AbstractAnnotationConfigDispatcherServletInitializer implements WebMvcConfigurer {
	@Override
	protected Class<?>[] getRootConfigClasses() { // contains Data source, service, repo
		log.info("Running getRootConfigClasses in WebInit");
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() { // helps to spring container to create object of component. //it
		// contains viewResolver, handler mapping, controller
		log.info("running getServletConfigClasses  in WebInit ");
		return new Class[] {FamConfig.class};
	}

	@Override
	protected String[] getServletMappings() { // identify path where DS will be mapped to , / is application default
		log.info("running getServletMappings  in WebInit");
		return new String[] { "/" };
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		//log.info(DEFAULT_SERVLET_NAME);
		// it tells DS to forward request for static resource to view resolver
		configurer.enable();
	}
}
