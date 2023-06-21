package org.fi.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Program {

	public static void main(String[] args) {
		 
//Step 1: Declare reference to represent the connection and supporting classes
		Connection connection = null;
		Statement stSelect = null;
		ResultSet result = null;
		// step 2 : load the database driver using which you need to connect to the database 
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			// loading the database specific driver class 
			
			
			// step 3 : open a connection to the database by providing username and password
			//URL: jdbc->db -> ip address :port/ schema
			
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaee_0029", "root", "Shailesh@123");
			System.out.println(connection);
			
			// step 4: Allocate a statement to allow me to fire queries on the database
			
			// Step 5: fire the query and generate the result 
			
			// step 6: Iterate through the result
				
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// step 7: close all the resource that been allocate 
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
