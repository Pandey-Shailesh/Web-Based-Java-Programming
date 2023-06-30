package org.fi.hibernate.firstHiberProj;

import java.util.Scanner;


import org.fi.hibernate.firstapp.entity.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class App 
{
    public static void main( String[] args )
    {
     Configuration hibernateConfiguration = new Configuration();
     
    	
    	hibernateConfiguration.configure("first-app.cfg.xml");
    	
    	
    	SessionFactory hibernateFactory = hibernateConfiguration.buildSessionFactory();
    	Session hibernateSession = hibernateFactory.openSession();
    	
    	
    	Scanner scr = new Scanner(System.in);
    	
    	System.out.println("Enter the userName");
    	String userName= scr.next();
    	System.out.println("Enter the password");
    	String password= scr.next();
    	System.out.println("Enter the name");
    	String name= scr.next();
    	System.out.println("Enter the email");
    	String email= scr.next();
    	
    	Users objUser= new Users(userName,password,name,email);
    	hibernateSession.beginTransaction();
    	hibernateSession.save(objUser);
    	
    	hibernateSession.getTransaction().commit();
    	System.out.println("User Register");
    	scr.close(); 
    }
}
