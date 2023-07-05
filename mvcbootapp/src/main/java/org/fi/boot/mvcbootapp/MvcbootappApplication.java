package org.fi.boot.mvcbootapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"org.fi.boot.mvcbootapp.controllers","org.fi.boot.mvcbootapp.beans","org.fi.boot.mvcbootapp.dao"})
public class MvcbootappApplication {

	public static void main(String[] args) {
		SpringApplication.run(MvcbootappApplication.class, args);
	}

}
