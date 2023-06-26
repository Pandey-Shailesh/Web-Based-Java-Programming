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

@WebServlet("/Category")
public class Category extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection connection;
	PreparedStatement psCategory;
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		try {
			ServletContext application = getServletContext();
			connection = (Connection)application.getAttribute("globalConnection");
			
			psCategory= connection.prepareStatement("select * from category_0029");
			System.out.println("Category : "+connection);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	public void destroy() {
		try {
			if (psCategory!= null) {
				psCategory.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<body>");
		out.println("<table border='1'>");
		out.println("<tr>");
		out.println("<th>Name</th>");
		out.println("<th>Description</th>");
		out.println("<th>Image</th>");
		out.println("</tr>");
		
		
		try (ResultSet result = psCategory.executeQuery()) {
			while (result.next()) {

				out.println("<tr>");
				out.println("<td><a herf='Products?categoryId=" + result.getInt("categoryId") + "'>"
						+ result.getString("categoryName") + "</a></td>");
				out.println("<td>" + result.getString("categoryDescription") + "</td>");
				out.println("<td><img src='Images/" + result.getString("categoryImageUrl")
						+ "' height='60px' width='60px'/></td>");
				out.println("</tr>");
			
			}
			out.println("</table>");
			out.println("</body>");
			out.println("</html>");
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		}

}
