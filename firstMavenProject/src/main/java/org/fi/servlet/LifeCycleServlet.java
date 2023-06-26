package org.fi.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/LifeCycleServlet")
public class LifeCycleServlet extends HttpServlet {

  
	private static final long serialVersionUID = 1L;
	
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		System.out.println("I am the Initilizer 'Bhrama' ");
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("I am the Operator 'Vishnu'");
	}
	
	@Override
	public void destroy() {
		System.out.println("I am Destroyer 'Shiva'");
	}

}
