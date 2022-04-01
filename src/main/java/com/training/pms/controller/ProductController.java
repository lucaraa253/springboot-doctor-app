package com.training.pms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.pms.model.Product;
import com.training.pms.repositories.ProductRepository;
import com.training.pms.service.ProductService;
import com.training.pms.utility.Demo;

@RestController
//used at method or class level
@RequestMapping("product")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {
	
	@Autowired
	ProductService productServ;
	
	@Autowired
	Demo demo;
	
	@GetMapping
//	HAnds on, 200 if record is there, 204 if record is not there
	public ResponseEntity<List<Product>> getProducts(){
		List<Product> result = productServ.getProducts();
		ResponseEntity<List<Product>> responseEntity = null;
		if(result.size()==0) {
			responseEntity = new ResponseEntity<List<Product>>(result, HttpStatus.NO_CONTENT);
			
		}else {
			responseEntity = new ResponseEntity<List<Product>>(result, HttpStatus.OK);
		}
		return responseEntity;
	}
	
	@PostMapping
	public ResponseEntity<String> saveProduct(@RequestBody Product product) {
		
		ResponseEntity<String> responseEntity = null;
		String result = null;
		if(productServ.isProductExists(product.getProductId())) {
			result = "Product with product ID : " + product.getProductId() + "Already exists";
			responseEntity = new ResponseEntity<String>(result, HttpStatus.OK);
		}else {
			result = productServ.addProduct(product);
			responseEntity = new ResponseEntity<String>(result, HttpStatus.CREATED);
		}
		return responseEntity;
	}
	//Update
	@PutMapping("{productId}")
	public ResponseEntity<String> updateProduct(@PathVariable("productId") int productId, @RequestBody Product product) { 
		
		//localhost:5050/product   -Put
		
		ResponseEntity<String> responseEntity = null;
		String result = null;
		if (productServ.isProductExists(product.getProductId())) {
			result = productServ.updateProduct(productId, product);
			responseEntity = new ResponseEntity<String>(result, HttpStatus.OK);// 200
		} else {
			result = "Product with product id :" + product.getProductId() + " does not exists";
			responseEntity = new ResponseEntity<String>(result, HttpStatus.NOT_MODIFIED); // 304
		}
		return responseEntity;
	}
//	Getting a product by ID
	@GetMapping("{productId}")
	public ResponseEntity<Product> getProduct(@PathVariable("productId") int productId) { //localhost:5050/product   -GET
		ResponseEntity<Product> responseEntity = null;
		Product product = new Product();
		if(productServ.isProductExists(productId)) {
			product = productServ.getProduct(productId);
			responseEntity = new ResponseEntity<Product>(product, HttpStatus.OK);//200
			
		}else {
			
			responseEntity = new ResponseEntity<Product>(product, HttpStatus.NO_CONTENT);//304
		}
		return responseEntity;
	}
	
	@DeleteMapping("{productId}")
	public ResponseEntity<String> deleteByProductId(@PathVariable("productId")int productId) {
		ResponseEntity<String> responseEntity = null;
		String result = null;
		if (productServ.isProductExists(productId)) {
			result = productServ.deleteProduct(productId);
			responseEntity = new ResponseEntity<String>(result,HttpStatus.OK);
		} else {
			result = "Product (id:"+productId+") does not exist";
			responseEntity = new ResponseEntity<String>(result,HttpStatus.NOT_FOUND);
		}
		return responseEntity;
	}
	
	@GetMapping("searchProductByName/{productName}")
	public ResponseEntity<List<Product>> getProductByProductName(@PathVariable("productName") String pname) { // localhost:5050/product/Bottle
		List<Product> result = productServ.getProductByProductName(pname);
		ResponseEntity<List<Product>> responseEntity = null;
		if (result.size() == 0) {
			responseEntity = new ResponseEntity<List<Product>>(result, HttpStatus.NO_CONTENT);
		} else {
			responseEntity = new ResponseEntity<List<Product>>(result, HttpStatus.OK);
		}
		return responseEntity;
	}
	
	//localhost:5050/product/filterProductByPrice/100/200
		@GetMapping("filterProductByPrice/{lowerPrice}/{upperPrice}")
		public ResponseEntity<List<Product>> filterProductByPrice(@PathVariable("lowerPrice") int lowerPrice,
				@PathVariable("upperPrice") int upperPrice) { // localhost:5050/product/Bottle -GET
			List<Product> result = productServ.getProductByPriceRange(lowerPrice,upperPrice);
			ResponseEntity<List<Product>> responseEntity = null;
			if (result.size() == 0) {
				responseEntity = new ResponseEntity<List<Product>>(result, HttpStatus.NO_CONTENT);
			} else {
				responseEntity = new ResponseEntity<List<Product>>(result, HttpStatus.OK);
			}
			return responseEntity;
		}
	
//	@GetMapping
//	public List<Product> getProducts() { //localhost:5050/product   -GET
//		return (List<Product>) productRepo.findAll();
//		
//	}
//	
	
//	
	
//	
//	@GetMapping("filterProductByPrice/{lowerPrice}/{higherPrice}")
//	public String getProductByPrices(@PathVariable("lowerPrice")int price1, @PathVariable("higherPrice")int price2) { //localhost:5050/product   -GET
//		return "Searching all products between : " + price1 + " and " + price2;
//	}
//	
//	@GetMapping("single")
//	public String getSingleProduct() {     //localhost:5050/product/single   -GET
//		return "Gettin a single product";
//	}
//	
//	@PostMapping
//	public String saveProduct(@RequestBody Product product) {     //localhost:5050/product   -Post
//		if(product.getPrice()>0) {
//			productRepo.save(product);
//			return "saving a single product";
//		}else {
//			return "product not saved";
//		}
//		
//		
//	}
//	
//	@PutMapping
//	public String updateProduct(@PathVariable("productId") int productId, @RequestBody Product product) {    //localhost:5050/product   -Put
//		return "updating a single product with product ID : " + productId;
//	}
//
//	
//	@DeleteMapping("{id}")
//	public String deleteProduct(@PathVariable("id")int id) {    //localhost:5050/product   -Delete
//		return "successfully deleted product with product ID : " + id;
//	}
//	@DeleteMapping("deleteProductByName/{name}")
//	public String deleteProduct2(@PathVariable("name")String productName) {    //localhost:5050/product   -Delete
//		return "successfully deleted product with product name : " + productName;
//	}
//	
//	@DeleteMapping("/allProduct")
//	public String deleteProduct2() {    //localhost:5050/product   -Delete
//		return "saving a single product";
//	}
}
