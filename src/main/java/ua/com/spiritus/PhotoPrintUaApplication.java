package ua.com.spiritus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import org.h2.server.web.WebServlet;


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
}
