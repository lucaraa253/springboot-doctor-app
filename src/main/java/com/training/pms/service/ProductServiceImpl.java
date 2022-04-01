package com.training.pms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.pms.model.Product;
import com.training.pms.repositories.ProductRepository;
@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductRepository productRepository;
	@Override
	public String addProduct(Product product) {
		if(product.getPrice()< 0 || product.getQuantityOnHand() < 0) {
			
			return "Product could not be saved because either the price or QOH is negative";
		}else {
			System.out.println("Adding product");
			productRepository.save(product);
			return "Product was saved";
		}
		
	}

	@Override
	public String updateProduct(int productId, Product product) {
		if(product.getPrice() < 0  || product.getQuantityOnHand() < 0)
			return "Product could not be updated because either price or qoh is negative";
		else
		{
			System.out.println("Updating product");
			productRepository.save(product);
			return "Product updated successfully!!";

		}
	}

	@Override
	public String deleteProduct(int productId) {
		productRepository.deleteById(productId);
		return "Product deleted successfully";
	}

	@Override
	public List<Product> getProducts() {
		System.out.println("Getting products method");
		return (List<Product>) productRepository.findAll();
	}

	@Override
	public Product getProduct(int productId) {
		Optional<Product> product = productRepository.findById(productId);
		return product.get();
	}

	@Override
	public boolean isProductExists(int productId) {
		Optional<Product> product = productRepository.findById(productId);
		return product.isPresent();
		
	}

	@Override
	public String deleteProduct() {
		productRepository.deleteAll();
		return "Product Deleted Succesfully";
	}

	@Override
	public int checkProductStock(int productid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Product> getProductByProductName(String productName) {
		// TODO Auto-generated method stub
		return productRepository.findByProductName(productName);
	}

	@Override
	public List<Product> getProductByPriceRange(int lowerPrice, int upperPrice) {
		// TODO Auto-generated method stub
		return productRepository.findByPriceBetween(lowerPrice, upperPrice);
	}

}
