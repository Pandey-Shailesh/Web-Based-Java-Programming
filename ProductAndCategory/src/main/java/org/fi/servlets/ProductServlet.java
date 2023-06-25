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

@WebServlet("/ShowProduct")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<body>");
		out.println("<table border='1'>");
		out.println("<tr>");
		out.println("<th>Name</th>");
		out.println("<th>Description</th>");
		out.println("<th>Price</th>");
		out.println("<th>Image</th>");
		out.println("</tr>");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/javaee_0029", "root",
					"Shailesh@123");
					PreparedStatement psProduct = connection.prepareStatement("select * from product_0029 where categoryId=?");
					) {
						
				
				String tmp =request.getParameter("categoryId");
				int  categoryId = Integer.parseInt(tmp);
				
				psProduct.setInt(1, categoryId);
				
				
				try (ResultSet result = psProduct.executeQuery()) {
					while (result.next()) {

						out.println("<tr>");
						out.println("<td>"+result.getString("productName")+"</td>");
						out.println("<td>" + result.getString("productDescription") + "</td>");
						out.println("<td><img src='Images/" + result.getString("productImageUrl")
								+ "' height='60px' width='60px'/></td>");
						out.println("</tr>");
					}
				}
				
				out.println("</table>");
				out.println("</body>");
				out.println("</html>");

			} catch (SQLException e) {

				e.printStackTrace();
			}

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}

	}

}
