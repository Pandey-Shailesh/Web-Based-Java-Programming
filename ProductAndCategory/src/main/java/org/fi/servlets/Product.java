package org.fi.servlets;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/Product")
public class Product extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection connection;
	PreparedStatement psProduct;
	
	public void init(ServletConfig config) throws ServletException {
		
		super.init(config);
		
		try {
			ServletContext application = getServletContext();
			connection = (Connection)application.getAttribute("globalConnection");
			
			psProduct= connection.prepareStatement("select * from product_0029 where categoryId=?");
			System.out.println("Product : "+connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	public void destroy() {
		try {
			if (psProduct!= null) {
				psProduct.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try {
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
	
	
	}

}
