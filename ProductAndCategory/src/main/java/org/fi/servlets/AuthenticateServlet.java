package org.fi.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(loadOnStartup = 100,urlPatterns = {"/Authenticate"})
public class AuthenticateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Connection connection ;
	PreparedStatement psAunthenticateUser;
	
	@Override
	public void init(ServletConfig config) throws ServletException
	{
		
		super.init(config);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			 connection = DriverManager.getConnection("jdbc:mysql://localhost/javaee_0029", "root",
					"Shailesh@123");
			 psAunthenticateUser = connection.prepareStatement("select * from users_0029 where userName=? and password=?");
			 System.out.println("Authenticate"+ connection);
		} catch (ClassNotFoundException  | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	
	@Override
	public void destroy() {
		
		
		try {
			if (psAunthenticateUser!= null) {
				psAunthenticateUser.close();
			}
			if (connection!= null) {
				connection.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		if ((userName == null || userName.length() <= 0) || (password == null || password.length() <= 0)) {
			out.println("Authentication failed");
			return;
		}

				try {
					psAunthenticateUser.setString(1, userName);
					psAunthenticateUser.setString(2, password);

					try (ResultSet result = psAunthenticateUser.executeQuery()) {

						if (result.next()) {
							
							if (userName.equals("admin")) 
							{
								response.sendRedirect("admin.html");
							}else {
								response.sendRedirect("AddCategory");
							}
						}
							
						 else 
							 out.println("<font color='red'>Authentication failed</font><br/><a href='index.html'>Go back</a>");
					}catch (SQLException e) {
					
					e.printStackTrace();
}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
 

	}

}
