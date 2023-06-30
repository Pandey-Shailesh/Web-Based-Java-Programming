package org.fi.hibernate.secondHiberProj;

import java.util.List;
import java.util.Scanner;

import javax.persistence.Query;

import org.fi.hibernate.secondapp.entity.Category;
import org.fi.hibernate.secondapp.entity.Users;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class App 
{
    public static void main( String[] args )
    {
     Configuration hibernateConfiguration = new Configuration();
     
    	
    	hibernateConfiguration.configure("first-app.cfg.xml");
    	
    	int choice=0;
    	try (SessionFactory hibernateFactory = hibernateConfiguration.buildSessionFactory();
				Session hibernateSession = hibernateFactory.openSession();
				Scanner scr = new Scanner(System.in)) {
    		
    		while (choice!=12) {
				System.out.println("1. Add User");
				System.out.println("2. Load User");
				System.out.println("3. Add Category");
				System.out.println("4. Add ad update  user");
				System.out.println("5.Hibernate Query language(HQL) Retrive the all Data from users");
				System.out.println("6.Hibernate Query language(HQL) Retrive the all Data from users using full query");
				System.out.println("7.Hibernate Query language(HQL) Retrive the userName ,email from users using full query");
				System.out.println("8.Hibernate Query language(HQL) Retrive the all Data from users using where condition");
				System.out.println("9.Synax Query language(SQL) Retrive the all Data from users by using native Query  ");
				System.out.println("10.Hibernate Query language(HQL) Retrive the all Data from users by using native Query by using annotation ");
				System.out.println("Enter Your Choice:");
				choice = scr.nextInt();
				scr.nextLine();
				
				
				switch (choice) {
				case 1: {
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
				}
				break;
				case 2:{
					System.out.println("Enter the Username");
					String userName = scr.next();
					Users objUser = (Users)hibernateSession.load(Users.class,userName);
					System.out.println(objUser.getName());
					System.out.println(objUser.getEmail());
					System.out.println(objUser.getUserName());	
					System.out.println(objUser.getPassword());	
					
				}
				break;
				case 3: {
					System.out.println("Enter the categoryId");
					int categoryId= scr.nextInt();
					System.out.println("Enter the categoryName");
					String categoryName= scr.next();
					System.out.println("Enter the categoryDescription");
					String categoryDescription= scr.next();
					System.out.println("Enter the categoryImageUrl");
					String categoryImageUrl= scr.next();
					scr.nextLine();
					
					Category objCategory =  new Category(categoryId,categoryName,categoryDescription,categoryImageUrl);
					hibernateSession.beginTransaction();
					hibernateSession.save(objCategory);
					
					hibernateSession.getTransaction().commit();
					System.out.println("categoryName Added");
				}
				break;
				case 4: {
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
					hibernateSession.saveOrUpdate(objUser);
					
					hibernateSession.getTransaction().commit();
					
				}
				break;
				case 5: {
					Query query = hibernateSession.createQuery("from Users");
					List<Users> list = query.getResultList();
					for (Users objUser : list) {
						System.out.println(objUser);
					}
				}
				break;
				case 6: {
					Query query = hibernateSession.createQuery("select OBJECT(objUser) from Users objUser");
					List<Users> list = query.getResultList();
					for (Users objUser : list) {
						System.out.println(objUser);
					}
				}
				break;
				case 7: {
					Query query = hibernateSession.createQuery("select objUser.userName, objUser.email from Users objUser");
					List<Object []> list = query.getResultList();
					for (Object [] data : list) {
						System.out.println(data[0]+","+data[1]);
					}
				}
				break;
				case 8: {
					System.out.println("Enter the userName");
					String userName= scr.next();
//					Query query = hibernateSession.createQuery("select OBJECT(objUser) from Users objUser where objUser.userName=?1");
//					query.setParameter(1, userName);
					
					Query query = hibernateSession.createQuery("select OBJECT(objUser) from Users objUser where objUser.userName=:uname");
					query.setParameter("uname", userName);
					List<Users> list = query.getResultList();
					for (Users objUser : list) {
						System.out.println(objUser);
					}
					
				}
				break;
				case 9: {
					Query query = hibernateSession.createNativeQuery("select * from users_0029 ");
					List<Object []> list = query.getResultList();
					for (Object [] data : list) {
						System.out.println(data[0]+","+data[1]+","+data[2]+","+data[3]);
						System.out.println("*****************");
					}
				}
				break;
				case 10: {
					Query query = hibernateSession.getNamedQuery("allUsers");
					List<Users> list = query.getResultList();
					for (Users objUser : list) {
						System.out.println(objUser);
						System.out.println("**************");
					}
				}
				break;
				default:
					System.out.println("Please select valid choice..");
				}
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
    
   
    }
}
