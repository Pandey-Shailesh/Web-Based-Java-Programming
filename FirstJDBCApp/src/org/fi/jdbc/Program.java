package org.fi.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Program {

	public static void main(String[] args) {
		Connection connection = null;
		Statement stSelect = null;
		ResultSet result = null;

		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaee_0029", "root", "Shailesh@123");
			stSelect  = connection.createStatement();
			result = stSelect.executeQuery("select * from users_0029");
			while (result.next()) {
				System.out.println(result.getString("userName"));// result.getString(1)
				System.out.println(result.getString(2));
				System.out.println(result.getString("name"));
				System.out.println(result.getString(4));
				System.out.println("========================================");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				if (result!=null) 
					result.close();	
				if (stSelect!=null) 
					stSelect.close();	
				if (connection!=null) 
					connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
	}

}
