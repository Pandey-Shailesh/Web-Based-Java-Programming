package org.fi.spring.fifthapp.cart;

import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.stereotype.Component;

@Component
public class ShoppingCart implements Cart {

	ArrayList items = new ArrayList();
	
	@Override
	public void addToCart(Object product) {
		// TODO Auto-generated method stub
		items.add(product);
	}

	@Override
	public void deleteFormCart(Object product) {
		// TODO Auto-generated method stub
		items.remove(product);
	}

	@Override
	public Iterator<Object> allItems() {
		// TODO Auto-generated method stub
		return items.iterator();
	}

}
