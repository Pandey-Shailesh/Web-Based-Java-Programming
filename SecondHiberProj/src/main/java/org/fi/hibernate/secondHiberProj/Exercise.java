package org.fi.hibernate.secondHiberProj;

import java.util.Scanner;

import org.fi.hibernate.secondapp.entity.Card;
import org.fi.hibernate.secondapp.entity.Category;
import org.fi.hibernate.secondapp.entity.ProductId;
import org.fi.hibernate.secondapp.entity.Products;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Exercise {
	public static void main(String[] args) {
		Configuration hibernateConfiguration = new Configuration();

		hibernateConfiguration.configure("first-app.cfg.xml");

		int choice = 0;
		try (SessionFactory hibernateFactory = hibernateConfiguration.buildSessionFactory();
				Session hibernateSession = hibernateFactory.openSession();
				Scanner scr = new Scanner(System.in)) {

			while (choice != 9) {
				System.out.println("1. Add New Category");
				System.out.println("2. Update Category");
				System.out.println("3. Find Category by Id");
				System.out.println("4. Add New Card Details");
				System.out.println("5. Update Card Details");
				System.out.println("6. Find Card Details by Id");
				System.out.println("7. Find Products Details ");
				System.out.println("8. Exit");
				System.out.println("Enter Your Choice:");
				choice = scr.nextInt();
				scr.nextLine();

				switch (choice) {
				case 1: {
					System.out.println("Enter the categoryId");
					int categoryId = scr.nextInt();
					System.out.println("Enter the categoryName");
					String categoryName = scr.next();
					System.out.println("Enter the categoryDescription");
					String categoryDescription = scr.next();
					System.out.println("Enter the categoryImageUrl");
					String categoryImageUrl = scr.next();
					scr.nextLine();

					Category objCategory = new Category(categoryId, categoryName, categoryDescription,
							categoryImageUrl);
					hibernateSession.beginTransaction();
					hibernateSession.save(objCategory);

					hibernateSession.getTransaction().commit();
					System.out.println("categoryName Added");

					System.out.println("************************");
				}
					break;
				case 2: {
					System.out.println("Enter the categoryId");
					int categoryId = scr.nextInt();
					System.out.println("Enter the categoryName");
					String categoryName = scr.next();
					System.out.println("Enter the categoryDescription");
					String categoryDescription = scr.next();
					System.out.println("Enter the categoryImageUrl");
					String categoryImageUrl = scr.next();
					scr.nextLine();

					Category objCategory = new Category(categoryId, categoryName, categoryDescription,
							categoryImageUrl);
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
				case 3: {
					System.out.println("Enter the categoryId");
					int categoryId = scr.nextInt();
					scr.nextLine();

					Category objCategory = hibernateSession.load(Category.class, categoryId);
					System.out.println(objCategory.getCategoryName());
					System.out.println(objCategory.getCategoryDescription());
					System.out.println(objCategory.getCategoryImageUrl());
					System.out.println(objCategory.getCategoryId());
					System.out.println("************************");

				}
					break;
				case 4: {
					System.out.println("Enter the srNo");
					int srNo = scr.nextInt();
					System.out.println("Enter the cardNo");
					String cardNo = scr.next();
					System.out.println("Enter the expirty");
					String expirty = scr.next();
					System.out.println("Enter the cvv");
					int cvv = scr.nextInt();
					System.out.println("Enter the balance");
					float balance = scr.nextFloat();
					scr.nextLine();

					Card objCard = new Card(srNo, cardNo, expirty, cvv, balance);
					hibernateSession.beginTransaction();
					hibernateSession.save(objCard);

					hibernateSession.getTransaction().commit();
					System.out.println("New Card Added");

					System.out.println("************************");
				}
					break;
				case 5: {
					System.out.println("Enter the srNo");
					int srNo = scr.nextInt();
					System.out.println("Enter the cardNo");
					String cardNo = scr.next();
					System.out.println("Enter the  updated expirty");
					String expirty = scr.next();
					System.out.println("Enter the updated cvv");
					int cvv = scr.nextInt();
					System.out.println("Enter the updated balance");
					float balance = scr.nextFloat();
					scr.nextLine();

					Card objCard = new Card(srNo, cardNo, expirty, cvv, balance);
					hibernateSession.beginTransaction();
					hibernateSession.saveOrUpdate(objCard);
					hibernateSession.getTransaction().commit();
					System.out.println(objCard.getCardNo());
					System.out.println(objCard.getCvv());
					System.out.println(objCard.getBalance());
					System.out.println(objCard.getExpirty());
					System.out.println("************************");

				}
					break;
				case 6: {
					System.out.println("Enter the cardNo");
					String cardNo = scr.next();
					scr.nextLine();

					Card objCard = hibernateSession.load(Card.class, cardNo);
					System.out.println(objCard.getCardNo());
					System.out.println(objCard.getCvv());
					System.out.println(objCard.getBalance());
					System.out.println(objCard.getExpirty());
					System.out.println("************************");
				}
					break;
				case 7: {

					ProductId pid = new ProductId(1, 4);
					Products objProducts = new Products(pid, "LAptop", "latest processer", "lsaptop.jpg", 85000.0f);
					Transaction tx = hibernateSession.beginTransaction();
					hibernateSession.save(objProducts);
					tx.commit();
					System.out.println("product Stored");

//					
//					Card objCard = hs.load(1234);
//					if(amount <objCard.getBalance() ) {
//						objCard.setBalance(balance-amount);
//						Transactions objTransactions =new Transactions(parameters..);
//						hibernateSession.beginTransaction();
//						hibernateSession.update(objCard);
//						hibernateSession.save(objTransactions);
//						hibernateSession.tx.commit();}

				}

				case 8: {

					System.out.println("******EXIT********");

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
