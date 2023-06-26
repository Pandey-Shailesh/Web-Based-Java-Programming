package org.fi.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import org.fi.pojo.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/Listcart")
public class ListCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession(false);
		if (session==null) {
			response.sendRedirect("index.html");
			return;
		}
		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<body>");
		out.println("Welcome <b>"+session.getAttribute("userName")+"</b><br/>");
		
		ArrayList<Product> objCart = (ArrayList<Product>)session.getAttribute("cart");
		
		if (objCart==null) {
			out.println("<h3>Your cart is empty</h3>");
		}
	
		
		out.println("<h3>Your cart</h3><br/>");
		out.println("<table border='1'>");
		out.println("<tr>");
		out.println("<th>Category Id</th>");
		out.println("<th>Product Id</th>");
		out.println("<th>Price</th>");
		out.println("</tr>");
		
		double total=0.0;
		
	for (Product objProduct : objCart) {
		
		
		out.println("<tr>");
		out.println("<td>" +objProduct.getCategoryId() +"</td>");
		out.println("<td>" +objProduct.getProductId() +"</td>");
		out.println("<td>" +objProduct.getPrice() +"</td>");
		out.println("</tr>");
		total+=objProduct.getPrice();
		
	}
	out.println("</table>");
	
	
	out.println("Cart Total: <b>"+total+"</b><br/>");
	out.println("<a href='Checkout'>Checkout<a/>&nbsp;&nbsp;"
			+ "<a href='Category'>Continue Shoping<a/>&nbsp;&nbsp;"
			+ "<a href='Logout'>LogOut<a/>&nbsp;");
	
	out.println("</body>");
	out.println("</html>");
	
		
	}

}
