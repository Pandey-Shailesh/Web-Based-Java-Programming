package org.fi.spring.secondspringapps;

import org.fi.spring.secondspringapps.beans.Users;
import org.springframework.beans.BeansException;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class App 
{
    public static void main( String[] args )
    {
      
    	try (ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("second-beans.xml")) {
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
