package org.fi.boot.jpabootapp.repository;


import java.util.List;
import java.util.Optional;

import org.fi.boot.jpabootapp.entity.Category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
	public Optional<Category>findByCategoryDescription(String categoryDescription);
	public Optional<Category>findByCategoryName(String categoryName);
	@Query(value="select * from category_0029 where categoryImageUrl like %:criteria",nativeQuery = true)
	public List<Category> findByCategoryImageUrl(@Param("criteria")String categoryImageUrl);
}
