package com.dvk.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.dvk.model.Product;
import com.dvk.service.ProductService;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

	private Path path;

	@Autowired
	private ProductService productService;

	// --------Admin Home Page------//
	@RequestMapping(method = RequestMethod.GET)
	public String adminHome(Model model) {
		return "adminHome";
	}

	// ----------Retrieves all product------//
	@RequestMapping(value = "/product", method = RequestMethod.GET)
	public String productInventory(Model model) {
		List<Product> productList = productService.getProducts();
		model.addAttribute("products", productList);
		return "productInventory";
	}

	@RequestMapping(value = "/productInventory/addProduct", method = RequestMethod.GET)
	public String addProduct(Model model) {
		Product product = new Product();
		product.setProductCondition("New");
		model.addAttribute("product", product);
		return "addProduct";
	}

	@RequestMapping(value = "/productInventory/addProduct", method = RequestMethod.POST)
	public String addProductPost(@ModelAttribute("product") Product product,
			HttpServletRequest request) {
		productService.addProduct(product);
		
		MultipartFile image = product.getProductImage();
		//String rootDirectory = request.getSession().getServletContext()
				//.getRealPath("/");
		//path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\images\\"
				//+ product.getId() + ".png");
		
		String imageUrl = "D:/Dharmik/"+ product.getId() + ".png";

		if (null != image && !image.isEmpty()) {
			try {
				image.transferTo(new File(imageUrl));
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("Error in saving image", e);
			}
		}
		return "redirect:/admin/product";

	}

	/* below method added by Shweta */

	@RequestMapping(value = "/deleteProduct/{productId}")
	public String deleteProduct(@PathVariable String productId, Model model) {
		productService.deleteProduct(productId);
		/*List<Product> productList = productService.getProducts();
		model.addAttribute("products", productList);
		return "productList";*/
		 return "redirect:/admin/product"; 
	}
	/* Shweta's code ends */
}
