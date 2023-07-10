package org.fi.fullaplication.services;

import java.util.Iterator;

import org.fi.fullaplication.dto.ProductDTO;
import org.fi.fullaplication.dto.ProductDTOId;

public interface ProductService {

	
	public Iterator<ProductDTO> productByCategoryId(int category);
	public boolean addNewProduct(ProductDTO productDTO);
	public ProductDTO  productDetails(ProductDTOId pid);
	public boolean delectProduct(ProductDTOId pid);
	
	
	
	
}
