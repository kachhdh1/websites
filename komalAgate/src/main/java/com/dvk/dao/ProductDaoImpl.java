package com.dvk.dao;

import java.util.ArrayList;
import java.util.List;

import com.dvk.model.Product;

public class ProductDaoImpl implements ProductDao{

	public List<Product> getProducts() {
		//hardcoded entries
		List<Product> productList = new ArrayList<Product>();
		Product p1 = new Product();
		p1.setProductName("Honda");
		p1.setPrice("50000");
		p1.setProductCategory("auto");
		p1.setManufacturer("Hero");
		
		Product p2 = new Product();
		p2.setProductName("Maruti");
		p2.setPrice("150000");
		p2.setProductCategory("auto");
		p2.setManufacturer("Maruti Suzuki");
		
		productList.add(p1);
		productList.add(p2);
		return productList;
	}

	public void addProduct(Product product) {
		// TODO Auto-generated method stub
		
	}

	public void deleteProduct(String productId) {
		// TODO Auto-generated method stub
		
	}

}
