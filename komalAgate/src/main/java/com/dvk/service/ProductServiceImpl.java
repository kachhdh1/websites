package com.dvk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.dvk.dao.ProductDao;
import com.dvk.dao.ProductDaoImpl;
import com.dvk.model.Product;

public class ProductServiceImpl implements ProductService {

	//@Autowired
	private ProductDao productDao = new ProductDaoImpl();
	
	public List<Product> getProducts() {
		return productDao.getProducts();
	}

	public void addProduct(Product product) {
		// TODO Auto-generated method stub

	}

	public void deleteProduct(String productId) {
		// TODO Auto-generated method stub

	}

}
