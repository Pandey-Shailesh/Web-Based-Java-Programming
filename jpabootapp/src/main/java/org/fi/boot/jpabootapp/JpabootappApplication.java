package org.fi.boot.jpabootapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"org.fi.boot.jpabootapp.controllers","org.fi.boot.jpabootapp.services"})
@EntityScan(basePackages = {"org.fi.boot.jpabootapp.entity"})
@EnableJpaRepositories(basePackages = {"org.fi.boot.jpabootapp.repository"})
public class JpabootappApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpabootappApplication.class, args);
	}

}
