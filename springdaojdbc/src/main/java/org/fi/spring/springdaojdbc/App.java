package org.fi.spring.springdaojdbc;

import java.util.Iterator;
import java.util.Scanner;

import org.fi.spring.springdaojdbc.beans.Category;
import org.fi.spring.springdaojdbc.config.AppConfigurator;
import org.fi.spring.springdaojdbc.dao.CategoryDao;
import org.fi.spring.springdaojdbc.dao.UserDAO;
import org.fi.spring.springdaojdbc.entity.Users;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		try (AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				AppConfigurator.class); Scanner scanner = new Scanner(System.in);) {

			CategoryDao categoryDao = (CategoryDao) applicationContext.getBean("categoryDao");
			UserDAO userDAO= (UserDAO)applicationContext.getBean("userDAO");
			int choice = 0;
			while (choice != 7) {

				System.out.println("1.Add Category");
				System.out.println("2.Delete Category");
				System.out.println("3.All Categories");
				System.out.println("4.Add user");
				System.out.println("5.Authenticate");
				System.out.println("6.All User");
				System.out.println("7.Exit");
				choice = scanner.nextInt();
				switch (choice) {
				case 1: {

					System.out.println("Enter categoryId");
					int categoryId = scanner.nextInt();
					System.out.println("Enter categoryName");
					String categoryName = scanner.next();
					System.out.println("Enter categoryDescription");
					String categoryDescription = scanner.next();
					System.out.println("Enter categoryImageUrl");
					String categoryImageUrl = scanner.next();
					Category objCategory = (Category) applicationContext.getBean("objCategory");

					objCategory.setCategoryId(categoryId);
					objCategory.setCategoryName(categoryName);
					objCategory.setCategoryDescription(categoryDescription);
					objCategory.setCategoryImageUrl(categoryImageUrl);

					boolean status = categoryDao.addNewCategory(objCategory);
					if (status) {
						System.out.println("Category added");
					} else {
						System.out.println("Failed to add Category ");
					}
				}
					break;
				case 2: {
					System.out.println("Enter categoryId");
					int categoryId = scanner.nextInt();

					boolean status = categoryDao.deleteCategory(categoryId);

					if (status) {
						System.out.println("Category Deleted");
					} else {
						System.out.println("Failed to delete Category ");
					}
				}

					break;
				case 3: {

					Iterator<Category> iter = categoryDao.allCategories();
					while (iter.hasNext()) {
						Category objCategory = iter.next();
						System.out.println(objCategory);
					}

				}

					break;
				case 4: {

					System.out.println("Enter UserName");
					String userName = scanner.next();
					System.out.println("Enter password");
					String password = scanner.next();
					System.out.println("Enter name");
					String name = scanner.next();
					System.out.println("Enter email");
					String email = scanner.next();
					Users objUsers = (Users) applicationContext.getBean("userDAO");

					objUsers.setUserName(userName);
					objUsers.setPassword(password);
					objUsers.setName(name);
					objUsers.setEmail(email);

					boolean status = userDAO.addUser(objUsers);
					
					if (status) {
						System.out.println("User added");
					} else {
						System.out.println("Failed to add User ");
					}

				}

					break;
				case 5: {

					Iterator<Category> iter = categoryDao.allCategories();
					while (iter.hasNext()) {
						Category objCategory = iter.next();
						System.out.println(objCategory);
					}

				}

					break;
				case 6: {

					Iterator<Users> iter = userDAO.allUsers();
					while (iter.hasNext()) {
						Users objUsers = iter.next();
						System.out.println(objUsers);
					}


				}

					break;

				case 7:
					System.out.println("Exit");
					break;

				}

			}

		}
	}
}
