package webhibernate.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.persistence.NoResultException;

import org.hibernate.HibernateException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import webhibernate.entity.Users;

@WebServlet(loadOnStartup = 100,urlPatterns = {"/Authenticate"})
public class Authenticate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	

		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		SessionFactory hibernateFactory = (SessionFactory)getServletContext().getAttribute("hibernateFactory");
		
		try (Session hibernateSession = hibernateFactory.openSession()) {
			
			Query<Users> authenticateQuery = hibernateSession.getNamedQuery("authenticateUser");
			authenticateQuery.setParameter(1, userName);
			authenticateQuery.setParameter(2, password);
			
			Users objUser = authenticateQuery.getSingleResult();
			response.sendRedirect("category.jsp");
			
		}catch (HibernateException  e) {
			e.printStackTrace();
		} 
		catch ( NoResultException e) {
			response.sendRedirect("login.jsp");
			e.printStackTrace();
		}
					
	}

}
