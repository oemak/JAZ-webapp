package com.webapp.webappapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {
		"com.webapp.webappapi",
		"com.webapp.webappdata.service",
		"com.webapp.webappdata.client",
		"com.webapp.webappdata.mapper",
		"com.webapp.webappdata.config"
})
@EntityScan("com.webapp.webappdata.entity")
@EnableJpaRepositories("com.webapp.webappdata.repository")
public class WebappApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(WebappApiApplication.class, args);
	}
}