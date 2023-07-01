package org.fi.spring.firstspringapps;

import org.fi.spring.firstspringapps.beans.Users;
import org.springframework.beans.BeansException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
      
    	try (ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("first-beans.xml")) {
			Users objUser = (Users) applicationContext.getBean("objUser");
			
			System.out.println(objUser.getUserName());
			System.out.println(objUser.getPassword());
		} catch (BeansException e) {
			e.printStackTrace();
		}
    }
}
