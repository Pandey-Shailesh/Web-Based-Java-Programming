package org.fi.spring.sixthapp;

import org.fi.spring.fifthapp.config.AppConfigurator;
import org.fi.spring.sixthapp.beans.Users;
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
      	   
  		   
  		   Users o1 = (Users)applicationContext.getBean("objUsers"); 
  		
  		   System.out.println("************o1");
  		   System.out.println(o1.getUserName());
  		   System.out.println(o1.getPassword());
  		 
  	} catch (BeansException e) {
  		// TODO Auto-generated catch block
  		e.printStackTrace();
  	}
    }
}
