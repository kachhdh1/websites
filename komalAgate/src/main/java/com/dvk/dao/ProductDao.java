package com.dvk.dao;

import java.util.List;

import com.dvk.model.Product;

public interface ProductDao {

	public List<Product> getProducts();
	public void addProduct(Product product);
	public void deleteProduct(String productId);
	public Product getProductById(String id);
	
}
