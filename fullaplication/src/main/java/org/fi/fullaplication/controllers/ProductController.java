package org.fi.fullaplication.controllers;

import java.util.Iterator;

import org.fi.fullaplication.dto.ProductDTO;
import org.fi.fullaplication.dto.ProductDTOId;
import org.fi.fullaplication.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
	@Autowired
	ProductService productService;
	
	@GetMapping("/allProducts/{cid}")
	public Iterator<ProductDTO> allProducts(@PathVariable("cid")int  categoryId )
	{
		return productService.productByCategoryId(categoryId);
	}
	
	@GetMapping("/productDetails")
	public ProductDTO productDetails(@RequestBody ProductDTOId pid )
	{
		return productService.productDetails(pid);
	}
	
	@PostMapping("/addProduct")
	public boolean addProduct(@RequestBody ProductDTO dto )
	{
		return productService.addNewProduct(dto);
	}
	@PostMapping("/deleteProduct")
	public boolean deleteProduct(@RequestBody ProductDTOId pid )
	{
		return productService.delectProduct(pid);
	}
	
	
	
	
}
