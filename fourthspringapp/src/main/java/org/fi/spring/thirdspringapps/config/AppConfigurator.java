package org.fi.spring.thirdspringapps.config;

import org.fi.spring.thirdspringapps.beans.Users;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class AppConfigurator {
@Bean
public Users objUser() {
	return new Users();
}
}
