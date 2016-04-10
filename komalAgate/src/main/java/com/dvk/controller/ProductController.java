package com.dvk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dvk.model.Product;
import com.dvk.service.ProductService;
import com.dvk.service.ProductServiceImpl;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value="/products")
	public String getProductList(Model model){
		List<Product> productList = productService.getProducts();
		model.addAttribute("products",productList);
		return "productList";
	}
	
	@RequestMapping(value="/products/viewProduct")
	public String viewProduct(Model model){
		
		return "viewProduct";
	}

}
