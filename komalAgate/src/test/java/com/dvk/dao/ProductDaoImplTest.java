package com.dvk.dao;

import java.util.List;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.dvk.model.Product;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/config/applicationContext-test.xml")
public class ProductDaoImplTest {
	
	@Autowired
	ProductDao productDao;
	
	@BeforeClass
	public static void setup(){
		System.out.println("executing before class setup function");
	}
	
	@AfterClass
	public static void tearDown(){
		System.out.println("executing tear down");
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testAddProduct() {
		Product product = new Product();
		product.setProductName("junit test product");
		product.setProductCategory("junit");
		product.setProductPrice(100);
		productDao.addProduct(product);
		
		List<Product> products = productDao.getProducts();
		assertEquals(1, products.size());
		assertEquals("junit", products.get(0).getProductCategory());
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void testDeleteProduct(){
		Product product = new Product();
		product.setProductName("junit test product");
		product.setProductCategory("junit");
		product.setProductPrice(100);
		productDao.addProduct(product);
		int id = product.getId();
		productDao.deleteProduct(id);
		
		//get the list and check the size;
		assertEquals(0, productDao.getProducts().size());
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void testInvalidGet_product_byID(){
		
		Product product = productDao.getProductById(1);
		//get the list and check the size;
		assertNull(product);
	}

}
