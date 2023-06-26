package org.fi.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/AddCategory")
public class AddCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String categoryName = request.getParameter("categoryName");
		String categoryDescription = request.getParameter("categoryDescription");
		String categoryImageUrl = request.getParameter("categoryImageUrl");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/javaee_0029", "root",
					"Shailesh@123");
					PreparedStatement psInsertCategory = connection.prepareStatement("insert into category_0029 values(?,?,?,?)");
					PreparedStatement psMaxId = connection.prepareStatement("select MAX(categoryID) form category_0029")) {

				int categoryId=-1;
				
				try (ResultSet result = psMaxId.executeQuery()) {
					if (result.next()) {
						categoryId= result.getInt(1)+1;
					} else {
						categoryId=1;
					}
				}
				
				psInsertCategory.setInt(1, categoryId);
				psInsertCategory.setString(2, categoryName);
				psInsertCategory.setString(3, categoryDescription);
				psInsertCategory.setString(4, categoryImageUrl);

				 psInsertCategory.executeUpdate();

					
			} catch (SQLException e) {

				e.printStackTrace();
			}

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}

	}

}
