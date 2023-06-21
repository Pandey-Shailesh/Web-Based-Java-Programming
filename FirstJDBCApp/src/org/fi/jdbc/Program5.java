package org.fi.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Program5 {

	public static void main(String[] args) {

		try (Scanner scr = new Scanner(System.in)) {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String sqlAuthenticateUser = "select * from users_0029 where userName=? and password=?";

			try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaee_0029", "root",
					"Shailesh@123");
					PreparedStatement psAunthenticate = connection.prepareStatement(sqlAuthenticateUser)) {

				System.out.println("Enter the userName");
				String userName = scr.next();

				System.out.println("Enter the password");
				String password = scr.next();

				psAunthenticate.setString(1, userName);
				psAunthenticate.setString(2, password);
				System.out.println(psAunthenticate);

				try (ResultSet result = psAunthenticate.executeQuery()) {
					if (result.next()) {
						System.out.println("USER Authenticated");
						System.out.println(result.getString(3));
						System.out.println(result.getString(4));
					} else {
						System.out.println(" Authentication failed");
					}
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
		}
	}
}
