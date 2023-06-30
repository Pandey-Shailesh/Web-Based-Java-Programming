package org.fi.hibernate.secondHiberProj;

import java.util.Scanner;

import org.fi.hibernate.secondapp.entity.Category;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Categeries 
{
    

	public static void main( String[] args )
    {
     Configuration hibernateConfiguration = new Configuration();
     
    	
    	hibernateConfiguration.configure("first-app.cfg.xml");
    	
    	int choice=0;
    	try (SessionFactory hibernateFactory = hibernateConfiguration.buildSessionFactory();
				Session hibernateSession = hibernateFactory.openSession();
				Scanner scr = new Scanner(System.in)) {
    		
    		while (choice!=5) {
				System.out.println("1. Add Category");
				System.out.println("2. Show Category");
				System.out.println("3. Update Category");
				System.out.println("4. Delete Category");
				System.out.println("Enter Your Choice:");
				choice = scr.nextInt();
				scr.nextLine();
				
				
				switch (choice) {
				case 1: {
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

					System.out.println("************************");
				}
				break;
				case 2: {
					System.out.println("Enter the categoryId");
					int categoryId= scr.nextInt();
					scr.nextLine();
					
					Category objCategory =  hibernateSession.load(Category.class, categoryId);
					System.out.println(objCategory.getCategoryName());
					System.out.println(objCategory.getCategoryDescription());	
					System.out.println(objCategory.getCategoryImageUrl());
					System.out.println(objCategory.getCategoryId());
					System.out.println("************************");
					
				
				}
				break;
				case 3:{
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
					hibernateSession.saveOrUpdate(objCategory);
					hibernateSession.getTransaction().commit();
					System.out.println("Updated values :-");
					System.out.println(objCategory.getCategoryName());
					System.out.println(objCategory.getCategoryDescription());	
					System.out.println(objCategory.getCategoryImageUrl());
					System.out.println(objCategory.getCategoryId());

					System.out.println("************************");
				}
				break;
				case 4:{
					System.out.println("Enter the categoryName");
					String categoryName = scr.next();
					
					Category objCategory = (Category)hibernateSession.load(Category.class,categoryName);
					hibernateSession.remove(objCategory);
					System.out.println("category Remove");

					System.out.println("************************");
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
