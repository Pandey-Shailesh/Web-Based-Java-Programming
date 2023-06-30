package webhibernate.servlets;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

@WebServlet(loadOnStartup = 100,urlPatterns = {"/initialize"})
public class InitializeHibernate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	SessionFactory hibernateFactory;
	@Override
	public void init(ServletConfig config)throws  ServletException{
		super.init(config);
		Configuration hibernateConfiguration = new Configuration();
		hibernateConfiguration.configure("web-app.cfg.xml");
		hibernateFactory = hibernateConfiguration.buildSessionFactory();
		ServletContext application = getServletContext();
		application.setAttribute("hibernateFactory", hibernateFactory);
		
	}
	
	

}
