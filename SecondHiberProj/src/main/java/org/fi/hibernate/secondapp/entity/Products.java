package org.fi.hibernate.secondapp.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import javax.persistence.Table;

@Entity
@Table(name="product_0029")
public class Products {
	@EmbeddedId
	ProductId productId;
	
	@Column(name="productName")
	String productName;
	@Column(name="productDescription")
	String productDescription;
	@Column(name="productImageUrl")
	String productImageUrl;
	@Column(name="productPrice")
	float productPrice;
	public Products() {
		// TODO Auto-generated constructor stub
	}
	
	public Products(ProductId productId, String productName, String productDescription, String productImageUrl,
			float productPrice) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productDescription = productDescription;
		this.productImageUrl = productImageUrl;
		this.productPrice = productPrice;
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
	public float getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(float productPrice) {
		this.productPrice = productPrice;
	}
}
