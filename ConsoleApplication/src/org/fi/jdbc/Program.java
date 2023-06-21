package org.fi.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try (Scanner scr = new Scanner(System.in);
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaee_0029",
							"root", "Shailesh@123");
					Statement stSelect = connection.createStatement();
					Statement stInsert = connection.createStatement();) {

				while (true) {
					System.out.println("===============Welcome======================");
					System.out.println("1. Register a Use ");
					System.out.println("2. List all users based on email domain ");
					System.out.println("3. Update Password of a User ");
					System.out.println("4. Display user information based on User Name");
					System.out.println("===========================================");
					System.out.println("Select the Option(1/2/3/4): ");

					int input = scr.nextInt();

					if (input == 1) {

						System.out.println("Enter the UserName");
						String userName = scr.next();
						System.out.println("Enter the password");
						String password = scr.next();
						System.out.println("Enter the name");
						String name = scr.next();
						System.out.println("Enter the email");
						String email = scr.next();

						String sqlInsertUser = "insert into users_0029 values(?,?,?,?)";
						try (PreparedStatement psRegistration = connection.prepareStatement(sqlInsertUser)) {

							psRegistration.setString(1, userName);
							psRegistration.setString(2, password);
							psRegistration.setString(3, name);
							psRegistration.setString(4, email);

							System.out.println(sqlInsertUser);
							int rowsUpdated = psRegistration.executeUpdate();
							if (rowsUpdated > 0) {
								System.out.println("user get Register");
							} else {
								System.out.println("Sorry user name already exit");
							}
						}
						System.out.println("=====================================================");
					} else if (input == 2) {
						System.out.println("Enter the Domain Name");
						String domainName = scr.next();

						String sqlSelectUser = "select * from users_0029 where email like" + "'%" + domainName + "'";
						try (ResultSet result = stSelect.executeQuery(sqlSelectUser)) {
							while (result.next()) {
								System.out.println("UserName: " + result.getString("userName"));
								System.out.println("Password: " + result.getString("password"));
								System.out.println("Name: " + result.getString("name"));
								System.out.println("Email: " + result.getString("email"));
								System.out.println("========================================");
							}
						}

					} else if (input == 3) {
						// update users_0029 set password= 'new_password' where name= 'value';
						System.out.println("Enter the New Password");
						String newPassword = scr.next();
						System.out.println("Enter the  Name where you want to change ");
						String name = scr.next();

						String sqlUpdateUser = "update users_0029 set password=? where name=?";
						try (PreparedStatement psUpdateUser = connection.prepareStatement(sqlUpdateUser)) {
							psUpdateUser.setString(1, newPassword);
							psUpdateUser.setString(2, name);

							try (ResultSet result = psUpdateUser.executeQuery()) {
								if (result.next()) {
									System.out.println("USER PASSWORD IS UPDATED");
									System.out.println("UserName: " + result.getString(1));
									System.out.println("Password: " + result.getString(2));
									System.out.println("Name: " + result.getString(3));
									System.out.println("Email: " + result.getString(4));
								} else {
									System.out.println(" Updation failed");
								}
							}

						}

					} else if (input == 4) {
						System.out.println("Enter the User Name");
						String userName = scr.next();

						String sqlSelectUser = "select * from users_0029 where username='" + userName + "'";
						try (ResultSet result = stSelect.executeQuery(sqlSelectUser)) {
							while (result.next()) {
								System.out.println("Name:" + result.getString("name"));
								System.out.println("Password:" + result.getString("password"));
								System.out.println("Email:" + result.getString("email"));
								System.out.println("========================================");
							}
						}

					} else {
						System.out.println("Program Ends");
						break;
					}
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
