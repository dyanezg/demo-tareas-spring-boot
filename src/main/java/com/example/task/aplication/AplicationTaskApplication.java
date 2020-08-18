package com.example.task.aplication;

import org.h2.server.web.WebServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan({"com.example.task.services","com.example.task.controllers"})
@EntityScan("com.example.task.model")
@EnableJpaRepositories("com.example.task.repositories")
public class AplicationTaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(AplicationTaskApplication.class, args);
	}
	
	
	 @Bean
	    public ServletRegistrationBean h2servletRegistration(){
	        ServletRegistrationBean registrationBean = new ServletRegistrationBean( new WebServlet());
	        registrationBean.addUrlMappings("/console/*");
	        return registrationBean;
	    }
}
