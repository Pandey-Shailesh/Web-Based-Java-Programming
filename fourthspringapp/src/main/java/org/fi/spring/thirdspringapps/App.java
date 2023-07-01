package org.fi.spring.thirdspringapps;

import org.fi.spring.thirdspringapps.beans.Users;
import org.fi.spring.thirdspringapps.config.AppConfigurator;
import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class App 
{
    public static void main( String[] args )
    {
      
    	try (AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfigurator.class)) {
			Users objUser = (Users) applicationContext.getBean("objUser");
			objUser.setUserName("Shailesh");
			objUser.setPassword("Shailesh@123");
			System.out.println(objUser.getUserName());
			System.out.println(objUser.getPassword());
		} catch (BeansException e) {
			e.printStackTrace();
		}
    }
}
