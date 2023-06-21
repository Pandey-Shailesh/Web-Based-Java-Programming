package org.fi.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Program4 {

	public static void main(String[] args) {

		try (Scanner scr = new Scanner(System.in)) {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Enter the UserName");
			String userName = scr.next();
			System.out.println("Enter the password");
			String password = scr.next();

			String sqlAunthenticateUser = "Select from users_0029 where userName ='" + userName + "'and password='"
					+ password + "'";

			try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaee_0029", "root",
					"Shailesh@123");
					Statement stSelect = connection.createStatement();
					ResultSet result = stSelect.executeQuery(sqlAunthenticateUser);) {
				if (result.next()) {
					System.out.println("USER AUNTHENTICATED");
					System.out.println(result.getString(3));
					System.out.println(result.getString(4));
				} else {
					System.out.println("AUNTHENTICATION FAILED");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
