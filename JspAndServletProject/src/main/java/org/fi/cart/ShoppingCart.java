package org.fi.cart;

import java.util.ArrayList;
import java.util.Iterator;

import firstjsp.pojo.Product;



public class ShoppingCart implements Cart {

	
	ArrayList<Product> items = new ArrayList<Product>();
	public void addToCart(Product objProduct) {
		items.add(objProduct);
	}

	
	public void deleteFromCart(int categoryId,int productId) {
		if (items.isEmpty()) 
			return;
		for(Product objProduct:items) {
			if (objProduct.getCategoryId()==categoryId && objProduct.getProductId()==productId) {
				items.remove(objProduct);
				return;
			}
		}
	}
	public Iterator<Product> allItems(){
		if (items.isEmpty()) 
			return null;
		else 
			return items.iterator();
		
	}

}
