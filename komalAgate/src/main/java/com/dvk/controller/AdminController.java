package com.dvk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dvk.model.Product;
import com.dvk.service.ProductService;

@Controller
@RequestMapping(value="/admin")
public class AdminController {
	
	@Autowired
	private ProductService productService;
	
	//--------Admin Home Page------//
	@RequestMapping(method=RequestMethod.GET)
	public String adminHome(Model model){
		return "adminHome";
	}
	
	//----------Retrieves all product------//
	@RequestMapping(value="/product", method=RequestMethod.GET)
	public String productInventory(Model model){
		List<Product> productList = productService.getProducts();
		model.addAttribute("products",productList);
		return "productInventory";
	}
	
	@RequestMapping(value="/productInventory/addProduct", method=RequestMethod.GET)
	public String addProduct(Model model){
		Product product = new Product();
		product.setProductCondition("New");
		model.addAttribute("product", product);
		return "addProduct";
	}

	@RequestMapping(value="/productInventory/addProduct", method=RequestMethod.POST)
	public String addProductPost(@ModelAttribute("product") Product product){
		productService.addProduct(product);
		 return "redirect:/admin/product";
	}
}
