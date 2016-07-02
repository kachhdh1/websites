package com.dvk.service;

import java.util.List;

import com.dvk.model.Product;

public interface ProductService {
	
	public List<Product> getProducts();
	public void addProduct(Product product);
	public void deleteProduct(int productId);
	public Product getProductById(int productId);

}
