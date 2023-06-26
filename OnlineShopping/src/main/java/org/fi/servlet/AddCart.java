package org.fi.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import org.fi.cart.Cart;
import org.fi.cart.ShoppingCart;
import org.fi.pojo.Product;
import java.io.IOException;

@WebServlet("/Addcart")
public class AddCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession(false);
		if (session==null) {
			response.sendRedirect("index.html");
			return;
		}
		int categoryId = Integer.parseInt(request.getParameter("categoryId"));
		int productId = Integer.parseInt(request.getParameter("categoryId"));
		float price = Float.parseFloat(request.getParameter("price"));
		
		Product objProduct = new Product(categoryId,productId,price);
		Cart objCart = (Cart)session.getAttribute("cart");
		
		if (objCart==null) {
			objCart= new ShoppingCart();
			session.setAttribute("cart", objCart);
		}
	
	}

}
