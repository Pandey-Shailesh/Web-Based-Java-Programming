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
import java.sql.SQLException;

@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		
		if ((userName == null || userName.length() <= 0) || (password == null || password.length() <= 0)
				|| (email == null || email.length() <= 0) || (name == null || name.length() <= 0)) {
			out.println("Please fill the Inputs");
			return;
		}

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/javaee_0029", "root",
					"Shailesh@123");
					PreparedStatement psRegisterUser = connection
							.prepareStatement("insert into users_0029 values(?,?,?,?)")) {

				psRegisterUser.setString(1, userName);
				psRegisterUser.setString(2, password);
				psRegisterUser.setString(3, name);
				psRegisterUser.setString(4, email);

				int rowsUpdated = psRegisterUser.executeUpdate();

				if (rowsUpdated > 0)
					{out.println("Hello " + name + ", U have Successfully Register");}
					
				else
					{out.println("<font color='red'> Allready Registed</font><br/><a href='register.html'>Go back</a>");}
					
			} catch (SQLException e) {

				e.printStackTrace();
			}

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}

	}

}
