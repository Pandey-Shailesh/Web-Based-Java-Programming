package org.fi.spring.fifthapp.config;


import org.fi.spring.sixthapp.beans.Users;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

@Configuration
@PropertySource("classpath:default-users.properties")
public class AppConfigurator {

	
	@Bean
	@Scope("prototype")
	public Users objUsers(@Value("${default.userName}")String uName,@Value("${default.password}")String password) {
		return new Users(uName, password);
	}
	
	
	
	//singleton -> default -> only 1 object of this bean will be available in this container 
	//prototype -> A new object of this bean will be created for each call of getBean
	//request
	//session
	//application
	
	
}
