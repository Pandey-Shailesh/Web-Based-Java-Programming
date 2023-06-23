package org.fi.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/Authenticate")
public class AuthenticateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
			Class.forName("com.mysql.cj.jdbc.Driver");
			

			try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/javaee_0029", "root",
					"Shailesh@123");
					PreparedStatement psAunthenticateUser = connection.prepareStatement("select * from users_0029 where userName=? and password=?")) {

				psAunthenticateUser.setString(1, userName);
				psAunthenticateUser.setString(2, password);

				try (ResultSet result = psAunthenticateUser.executeQuery()) {

					if (result.next()) 
						out.println("Welcome " + userName + ", to the Shoping site");
						
					 else 
						 out.println("<font color='red'>Authentication failed</font><br/><a href='index.html'>Go back</a>");
						
				}

			} catch (SQLException e) {
				
				e.printStackTrace();
			}

		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}

	}

}
