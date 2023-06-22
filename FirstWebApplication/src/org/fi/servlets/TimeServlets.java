package org.fi.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class TimeServlets extends HttpServlet{

@Override
public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException {
	
	PrintWriter out = response.getWriter();
	out.println("<html>");
	out.println("<body>");
	out.println("<h1>"+ new Date()+"</h1>");
	out.println("</body>");
	out.println("</html>");

}

}
