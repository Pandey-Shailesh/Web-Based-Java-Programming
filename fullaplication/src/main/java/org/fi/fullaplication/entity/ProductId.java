package org.fi.fullaplication.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
@Embeddable
public class ProductId implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Column(name="categoryid")
	int categoryId;
	@Column(name="productid")
	int productId;
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	@Override
	public int hashCode() {
		return Objects.hash(categoryId, productId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductId other = (ProductId) obj;
		return categoryId == other.categoryId && productId == other.productId;
	}
	
	
	
	
	
	
	
	
}
