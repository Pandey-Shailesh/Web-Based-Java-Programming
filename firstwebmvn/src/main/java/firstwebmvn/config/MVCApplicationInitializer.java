package firstwebmvn.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRegistration;

public class MVCApplicationInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext application) throws ServletException {
		
		AnnotationConfigWebApplicationContext springContext= new AnnotationConfigWebApplicationContext();
		springContext.register(AppConfigurator.class);
		springContext.setServletContext(application);
		
		ServletRegistration.Dynamic primaryController = application.addServlet("dispatcher",new DispatcherServlet(springContext));
		
				primaryController.setLoadOnStartup(1);
				primaryController.addMapping("/spring/*");
		
	}

}
