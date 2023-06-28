package org.fi.cart;

import java.util.Iterator;

import firstjsp.pojo.Product;


public interface Cart {
public void addToCart(Product objProduct);
public void deleteFromCart(int categoryId,int productId);
public Iterator<Product> allItems();

}
