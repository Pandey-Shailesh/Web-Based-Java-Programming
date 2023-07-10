package org.fi.fullaplication.entity;

import org.fi.fullaplication.dto.ProductDTOId;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="products_0029")
public class Product {
	@EmbeddedId
	ProductDTOId productId;
	@Column(name="productname")
	String productName;
	@Column(name="productdescription")
	String productDescription;
	@Column(name="productimageurl")
	String productImageUrl;
	public ProductDTOId getProductId() {
		return productId;
	}
	public void setProductId(ProductDTOId productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public String getProductImageUrl() {
		return productImageUrl;
	}
	public void setProductImageUrl(String productImageUrl) {
		this.productImageUrl = productImageUrl;
	}

}
