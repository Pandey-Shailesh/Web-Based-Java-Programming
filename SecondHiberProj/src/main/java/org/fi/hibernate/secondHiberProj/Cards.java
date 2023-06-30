package org.fi.hibernate.secondHiberProj;

import java.util.Scanner;

import org.fi.hibernate.secondapp.entity.Card;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Cards
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
				System.out.println("1. Add New Card Details");
				System.out.println("2. Show  Card Details");
				System.out.println("3. Update Card Details");
				System.out.println("4. Delete Category");
				System.out.println("Enter Your Choice:");
				choice = scr.nextInt();
				scr.nextLine();
				
				
				switch (choice) {
				case 1: {
					System.out.println("Enter the srNo");
					int srNo= scr.nextInt();
					System.out.println("Enter the cardNo");
					String cardNo= scr.next();
					System.out.println("Enter the expirty");
					String expirty= scr.next();
					System.out.println("Enter the cvv");
					int cvv= scr.nextInt();
					System.out.println("Enter the balance");
					float balance= scr.nextFloat();
					scr.nextLine();
					
					Card objCard =  new Card(srNo,cardNo,expirty,cvv,balance);
					hibernateSession.beginTransaction();
					hibernateSession.save(objCard);
					
					hibernateSession.getTransaction().commit();
					System.out.println("New Card Added");

					System.out.println("************************");
				}
				break;
				case 2: {
					System.out.println("Enter the cardNo");
					String cardNo= scr.next();
					scr.nextLine();
					
					Card objCard =  hibernateSession.load(Card.class, cardNo);
					System.out.println(objCard.getCardNo());
					System.out.println(objCard.getCvv());	
					System.out.println(objCard.getBalance());
					System.out.println(objCard.getExpirty());
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
