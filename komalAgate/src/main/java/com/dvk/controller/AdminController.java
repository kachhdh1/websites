package com.dvk.controller;

import java.io.File;
import java.nio.file.Path;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.dvk.model.Product;
import com.dvk.service.ProductService;
import com.dvk.views.ProductReportExcel;
import com.dvk.views.ProductsReportPdf;

@Controller
@RequestMapping(value = "/admin")
//@PropertySource("classpath:global.properties")
public class AdminController {
	
	/*@Autowired
	private Environment env;
	
	String image_path = env.getProperty("image_path");*/
	
	@Value("${image_path}")
	String image_path;

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
		File imageDir = new File(image_path);
		if(!imageDir.exists()){
			System.out.println("creating folder: " + image_path);
		    boolean result = false;
		    try{
		        imageDir.mkdir();
		        result = true;
		    } 
		    catch(SecurityException se){
		       System.out.println("No priviledge to create file");
		    }        
		    if(result) {    
		        System.out.println("Folder created");  
		    }
		}
		
		String imageUrl = image_path+ product.getId() + ".png";

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
	public String deleteProduct(@PathVariable int productId, Model model) {
		productService.deleteProduct(productId);
		/*List<Product> productList = productService.getProducts();
		model.addAttribute("products", productList);
		return "productList";*/
		String imageUrl = image_path+ productId + ".png";
		File file = new File(imageUrl);
		file.delete();
		 return "redirect:/admin/product"; 
	}
	
	@RequestMapping(value="/updateProduct/{productId}")
	public String updateProduct(@PathVariable int productId,Model model){
		Product product = productService.getProductById(productId);
		model.addAttribute("product", product);
		return "updateProduct";
	}
	
	@RequestMapping(value = "/productInventory/updateProduct", method = RequestMethod.POST)
	public String updateProductPost(@ModelAttribute("product") Product product,
			HttpServletRequest request) {
		productService.addProduct(product);
		MultipartFile image = product.getProductImage();
		
		String imageUrl = image_path+ product.getId() + ".png";

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
	/* Shweta's code ends */
	
	@RequestMapping("/productsPdf")
	public ModelAndView getAllProductsPdf(){
		List<Product> allProducts =  productService.getProducts();
		return new ModelAndView("productsRptPdf","allProducts",allProducts);
	}
	
	@RequestMapping("/productsXls")
	public ModelAndView getAllProductsExcel(){
		List<Product> allProducts =  productService.getProducts();
		return new ModelAndView("productsRptExcel","allProducts",allProducts);
	}
}
