package org.fi.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Authenticate")
public class AuthenticateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out =  response.getWriter();
		
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		if ((userName==null || userName.length()<=0)||(password==null || password.length()<=0)) {
			out.println("Authentication failed");
			return;
		}
		if (userName.equals("Shailesh")&& password.equals("Shailesh@123")) {
			out.println("Welcome Shailesh");
		}else {
			out.println("Authentication failed");
		}
		
		
	}

}
