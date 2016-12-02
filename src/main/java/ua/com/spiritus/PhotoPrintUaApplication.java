package ua.com.spiritus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication

public class PhotoPrintUaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhotoPrintUaApplication.class, args);
	}
}
