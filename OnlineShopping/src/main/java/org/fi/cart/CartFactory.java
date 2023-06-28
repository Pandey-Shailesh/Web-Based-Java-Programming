package org.fi.cart;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import jakarta.servlet.ServletContext;

public class CartFactory  {

	
	public static Cart  getCartInstance(ServletContext application) {
		
		
		try {
			String cartClassName= application.getInitParameter("cartClassName");
			Class refCartClass = Class.forName(cartClassName);
			Constructor defaultCtor = refCartClass.getConstructor(null);
			
			return (Cart)defaultCtor.newInstance(null);
		} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException
				| IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		return null;
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
