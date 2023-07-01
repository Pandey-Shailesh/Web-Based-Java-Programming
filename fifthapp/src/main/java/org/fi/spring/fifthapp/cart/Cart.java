package org.fi.spring.fifthapp.cart;

import java.util.Iterator;

public interface Cart {
public void addToCart(Object product);
public void deleteFormCart(Object product);
public Iterator<Object> allItems();

}
