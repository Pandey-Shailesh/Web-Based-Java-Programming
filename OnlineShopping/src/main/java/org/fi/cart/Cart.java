package org.fi.cart;

import java.util.Iterator;

import org.fi.servlet.Product;

public interface Cart {
public void addToCart(Product objProduct);
public void seleteFromCart(int categoryId,int productId);
public Iterator<Product> allItems();

}
