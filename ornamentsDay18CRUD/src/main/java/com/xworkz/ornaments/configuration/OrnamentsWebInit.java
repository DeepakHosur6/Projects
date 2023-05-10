package com.xworkz.ornaments.configuration;

import java.io.File;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class OrnamentsWebInit extends AbstractAnnotationConfigDispatcherServletInitializer implements WebMvcConfigurer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		System.out.println("1) Invoked getRootConfigClasses() ");
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		System.out.println("2) Invoked getRootConfigClasses() ");
		return new Class[] { OrnamentsConfiguration.class };
	}

	@Override
	protected String[] getServletMappings() {
		System.out.println("3) Invoked getServletMappings()");
		return new String[] { "/" };
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		System.out.println("4) Invoking configureDefaultServletHandling ");
		WebMvcConfigurer.super.configureDefaultServletHandling(configurer);
		configurer.enable();
	}

	@Override // image upload
	protected void customizeRegistration(Dynamic registration) {
		System.out.println("Running customizeRegistration() in OrnamentsWebInit ");
		String tempDir = "C:\\temp";
		int maxUploadSizeInMb = 3 * 1024 * 1024;
		File uploadDirectory = new File(tempDir);
		MultipartConfigElement multipartConfigElement = new MultipartConfigElement(uploadDirectory.getAbsolutePath(),
				maxUploadSizeInMb, maxUploadSizeInMb * 2, maxUploadSizeInMb / 2);
		registration.setMultipartConfig(multipartConfigElement);
		// super.customizeRegistration(registration);
	}
}
