package org.fi.spring.fifthapp.config;

import org.fi.spring.fifthapp.beans.Users;
import org.fi.spring.fifthapp.cart.Cart;
import org.fi.spring.fifthapp.cart.ProductCart;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfigurator {

	@Bean
	public Cart objCart() {
		return new ProductCart();
	}
	
	
	@Bean(initMethod = "initializeUser",destroyMethod = "destroy")
	@Scope("prototype")
	public Users objUsers(@Value("guest")String uName,@Value("guest")String password) {
		return new Users(uName, password);
	}
	
	
	
	//singleton -> default -> only 1 object of this bean will be available in this container 
	//prototype -> A new object of this bean will be created for each call of getBean
	//request
	//session
	//application
	
	
}
