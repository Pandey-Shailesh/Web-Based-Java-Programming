package org.fi.spring.springdaojdbc.config;

import javax.sql.DataSource;

import org.fi.spring.springdaojdbc.beans.Category;
import org.fi.spring.springdaojdbc.dao.CategoryDAOImpl;
import org.fi.spring.springdaojdbc.dao.CategoryDao;
import org.fi.spring.springdaojdbc.dao.UserDAO;
import org.fi.spring.springdaojdbc.dao.UserDAOImpl;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@org.springframework.context.annotation.Configuration
@PropertySource("classpath:application.properties")
public class AppConfigurator {

	@Autowired
	Environment environment;
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource =new DriverManagerDataSource();
		dataSource.setUrl(environment.getProperty("db.url"));
		dataSource.setUsername(environment.getProperty("db.username"));
		dataSource.setPassword(environment.getProperty("db.password"));
		dataSource.setDriverClassName(environment.getProperty("db.driver_class"));
		return dataSource;
	}
	@Bean
	public JdbcTemplate jdadTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}
	@Bean
	public CategoryDao categoryDao() {
		return new CategoryDAOImpl();
	}
	
	
	@Bean 
	public Configuration hibernateConfiguration() {
		String configFile = environment.getProperty("hibernate.config.file");
		Configuration hiberConfiguration = new Configuration();
		hiberConfiguration.configure(configFile);
		return hiberConfiguration;	
	}
	
	@Bean
	public SessionFactory hiberFactory(Configuration hiberConfiguration) {
		return  hiberConfiguration.buildSessionFactory();
	}
	@Bean
	public UserDAO userDAO() {
		return new UserDAOImpl();
	}
	
	
	
	
	@Bean
	@Scope("prototype")
	public Category objCategory() {
		return new Category();
	}
}
