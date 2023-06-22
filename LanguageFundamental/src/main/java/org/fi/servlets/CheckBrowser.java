package org.fi.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/CheckBrowser")
public class CheckBrowser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String agent = request.getHeader("user-agent");

		PrintWriter out = response.getWriter();

		out.println("You are using :- <br/>");

		if (agent.indexOf("Edg") != -1) 
			out.println("<h1>Microsoft Edge Browser </h1>");
		 else if (agent.indexOf("Firefox") != -1) 
			out.println("<h1>Mozilla FireFox Browser </h1>");
		 else if (agent.indexOf("Chrome") != -1) 
			out.println("<h1>Google Chrome Browser </h1>");
		 else 
			out.println("<h1>Unknown Browser </h1>");
		

	}

}
