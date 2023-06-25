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

@WebServlet("/UpdateCategory")
public class UpdateCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String updateCategoryName = request.getParameter("updateCategoryName");
		String categoryName = request.getParameter("categoryName");
		String categoryDescription = request.getParameter("categoryDescription");
		String categoryImageUrl = request.getParameter("categoryImageUrl");
		PrintWriter out = response.getWriter();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/javaee_0029", "root",
					"Shailesh@123");
					PreparedStatement psUpdateProduct = connection.prepareStatement("update category_0029 set categoryName=?,categoryDescription=?,categoryImageUrl=? where categoryName=?");
					) {
				psUpdateProduct.setString(4, updateCategoryName);
				psUpdateProduct.setString(1, categoryName);
				psUpdateProduct.setString(2, categoryDescription);
				psUpdateProduct.setString(3, categoryImageUrl);
				


				try (ResultSet result = psUpdateProduct.executeQuery()) {
					if (result.next()) {
						out.println("Updated Category Name:"+categoryName);
						out.println("Updated Category Description:"+categoryDescription);
						out.println("Updated Category Image Url:"+categoryImageUrl);
					} else {
						System.out.println(" Updation failed");
					}
				}
				
				
				
			} catch (SQLException e) {

				e.printStackTrace();
			}

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}

	}

}
