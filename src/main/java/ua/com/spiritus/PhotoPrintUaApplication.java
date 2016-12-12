package ua.com.spiritus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import org.h2.server.web.WebServlet;

import javax.servlet.MultipartConfigElement;


@SpringBootApplication
public class PhotoPrintUaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhotoPrintUaApplication.class, args);
	}

	@Bean
	public ServletRegistrationBean h2servletRegistration() {
		ServletRegistrationBean registration = new ServletRegistrationBean(new WebServlet());
		registration.addUrlMappings("/console/*");
		return registration;
	}


	@Bean
	public MultipartConfigElement multipartConfigElement() {
		MultipartConfigFactory factory = new MultipartConfigFactory();
		factory.setMaxFileSize("5120KB");
		factory.setMaxRequestSize("5120KB");
		return factory.createMultipartConfig();
	}
}
