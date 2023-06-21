package org.fi.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Program3 {

	public static void main(String[] args) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try(
			 Scanner scr = new Scanner(System.in);
			 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaee_0029", "root", "Shailesh@123");
			 Statement stInsert  = connection.createStatement();
			){
				System.out.println("Enter the UserName");
				String userName =  scr.nextLine();
				System.out.println("Enter the password");
				String password =  scr.nextLine();
				System.out.println("Enter the name");
				String name = scr.nextLine();
				System.out.println("Enter the email");
				String email = scr.nextLine();
				
				String sqlInsertUser = "insert into users_0029 values('"+userName+"','"+password+"','"+name+"','"+email+"')";
				System.out.println(sqlInsertUser);
				int rowsUpdated = stInsert.executeUpdate(sqlInsertUser);
				 if (rowsUpdated>0 ) {
					System.out.println("Record saved.");
				}else {
					System.out.println("No Insert possible");
				}
			
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
