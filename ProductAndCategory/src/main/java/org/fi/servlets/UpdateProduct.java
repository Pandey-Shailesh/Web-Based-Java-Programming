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

@WebServlet("/UpdateProduct")
public class UpdateProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String updateProductName = request.getParameter("updateCategoryName");
		String productName = request.getParameter("productName");
		String productDescription = request.getParameter("productDescription");
		String productImageUrl = request.getParameter("productImageUrl");
		String productPrice = request.getParameter("productPrice");
		PrintWriter out = response.getWriter();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/javaee_0029", "root",
					"Shailesh@123");
					PreparedStatement psUpdateProduct = connection.prepareStatement("update product_0029 set productName=?,productDescription=?,productImageUrl=?,productPrice=? where categoryName=?");
					) {
				psUpdateProduct.setString(5, updateProductName);
				psUpdateProduct.setString(1, productName);
				psUpdateProduct.setString(2, productDescription);
				psUpdateProduct.setString(3, productImageUrl);
				psUpdateProduct.setString(4, productPrice);


				try (ResultSet result = psUpdateProduct.executeQuery()) {
					if (result.next()) {
						out.println("Updated Category Name:"+productName);
						out.println("Updated Category Description:"+productDescription);
						out.println("Updated Category Image Url:"+productImageUrl);
						out.println("Updated Category Image Url:"+productPrice);
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
