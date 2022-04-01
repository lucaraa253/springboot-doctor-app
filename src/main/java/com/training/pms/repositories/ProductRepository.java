package com.training.pms.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.training.pms.model.Product;

public interface ProductRepository extends CrudRepository<Product, Integer>{
	List<Product> findByProductName(String productName);
	List<Product> findByPriceBetween(int lowerPrice, int upperPrice);
	List<Product> findByQuantityOnHandBetween(int lowerBound, int upperBound);
	
	@Query("SELECT COUNT(*) FROM Product p")
	public int countProducts();
	
	@Query("FROM Product p WHERE p.productName LIKE :pname")
	public Optional<List<Product>> findMyProductName(@Param("pname") String productName);
	
	@Query("FROM Product p WHERE p.price = :price and p.quantityOnHand > :qoh")
	public Optional<List<Product>> findMyProductPriceAndQuantity(@Param("price") int price, @Param("qoh") int quantityOnHand);
}
