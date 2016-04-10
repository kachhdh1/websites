package com.dvk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dvk.dao.ProductDao;
import com.dvk.model.Product;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;
	
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
