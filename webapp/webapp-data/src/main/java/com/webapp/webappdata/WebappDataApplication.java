package com.webapp.webappdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.webapp.webappdata.entity")
@EnableJpaRepositories("com.webapp.webappdata.repository")
public class WebappDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebappDataApplication.class, args);
	}

}
