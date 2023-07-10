package org.fi.fullaplication.dto;

public class ProductDTO {
ProductDTOId productId;
String productName;
String productDescription;
String productImageUrl;
float productPrice;
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
public float getProductPrice() {
	return productPrice;
}
public void setProductPrice(float productPrice) {
	this.productPrice = productPrice;
}




}
