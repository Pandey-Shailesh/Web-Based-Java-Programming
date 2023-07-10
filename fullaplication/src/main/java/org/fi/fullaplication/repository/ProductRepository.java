package org.fi.fullaplication.repository;

import java.util.List;

import org.fi.fullaplication.entity.Product;
import org.fi.fullaplication.entity.ProductId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface ProductRepository extends JpaRepository<Product, ProductId> {
@Query("select objProduct from product objProduct where objProduct.productid.categoryId=:cid")
public List<Product> findByCategoryId(@Param("cid")int categoryId);
}
