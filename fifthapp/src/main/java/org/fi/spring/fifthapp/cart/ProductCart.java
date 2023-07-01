package org.fi.spring.fifthapp.cart;

import java.util.ArrayList;
import java.util.Iterator;

public class ProductCart implements Cart {

	@Override
	public void addToCart(Object product) {
		// TODO Auto-generated method stub
		System.out.println("Add of productCard");
	}

	@Override
	public void deleteFormCart(Object product) {
		// TODO Auto-generated method stub
		System.out.println("delete of productCard");
	}

	@Override
	public Iterator<Object> allItems() {
		// TODO Auto-generated method stub
		System.out.println("List of productCard");
		return new ArrayList().iterator();
	}

}
