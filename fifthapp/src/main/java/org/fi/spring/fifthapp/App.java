package org.fi.spring.fifthapp;

import java.util.Iterator;

import javax.security.auth.login.AppConfigurationEntry;

import org.fi.spring.fifthapp.beans.Users;
import org.fi.spring.fifthapp.cart.Cart;
import org.fi.spring.fifthapp.config.AppConfigurator;
import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       try (AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfigurator.class)) {
    	   
    	   
    	   
//   		Cart c1 = (Cart)applicationContext.getBean("objCart");
//    	   
//    	   c1.addToCart("Test");
//    	  Iterator iter =c1.allItems();
//    	   while (iter.hasNext()) {
//			System.out.println(iter.next());
//		}
    	   
    	   
		Users o1 = (Users)applicationContext.getBean("objUsers");
		   System.out.println(o1);
		   o1.setUserName("Shailesh");
		   o1.setPassword("shailesh@123");
		   
		   Users o2 = (Users)applicationContext.getBean("objUsers"); 
		   System.out.println(o2);
		   o2.setUserName("Pankaj");
		   o2.setPassword("Guruji");
		   
		   
		   Users o3 = (Users)applicationContext.getBean("objUsers");  
		   System.out.println(o3);
		   o3.setUserName("Abhi");
		   o3.setPassword("Abhi@123");
		   
		   
		   System.out.println("************o1");
		   System.out.println(o1.getUserName());
		   System.out.println(o1.getPassword());
		   System.out.println("************o2");
		   System.out.println(o2.getUserName());
		   System.out.println(o2.getPassword());
		   System.out.println("************o3");
		   System.out.println(o3.getUserName());
		   System.out.println(o3.getPassword());
	} catch (BeansException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    }
}
