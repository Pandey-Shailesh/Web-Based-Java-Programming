package com.firstbootapp.firstbootapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import com.firstbootapp.beans.Users;

@SpringBootApplication(scanBasePackages = {"com.firstbootapp.beans"})
public class FirstbootappApplication implements CommandLineRunner{

	@Autowired
	Users objUser;
	
	public static void main(String[] args) {
		SpringApplication.run(FirstbootappApplication.class, args);
	}

	@Override
	public void run(String... args)throws Exception {
	objUser.setUserName("Shailesh");	
    objUser.setPassword("Shailesh@123");
    System.out.println(objUser);
	}
}
