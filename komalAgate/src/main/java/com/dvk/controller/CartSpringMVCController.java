package com.dvk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.dvk.model.Cart;
import com.dvk.model.CartItem;
import com.dvk.model.Customer;
import com.dvk.model.Product;
import com.dvk.service.CartService;
import com.dvk.service.CustomerService;
import com.dvk.service.ProductService;

/**
 * This class is simple spring mvc controller and acts as a resources 
 * for handling all the cart related operations.
 * @author Dharmik
 *
 */
@Controller
@RequestMapping(value="/mvc/cart")
public class CartSpringMVCController {
	
	@Autowired
	CartService cartService;
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	ProductService productService;

	@RequestMapping(value="/{cartId}",method=RequestMethod.GET)
	public String getCart(@PathVariable(value="cartId") int cartId,Model model){
		Cart cart =  cartService.getCartById(cartId);
		model.addAttribute("cart",cart);
		return "cart_mvc";
	}
	
	@RequestMapping(value="/add/{productId}")
	public String addProductItem(@PathVariable(value="productId") int productId,
			@AuthenticationPrincipal User loggedInUser,Model model){
		
		Customer customer = customerService.getCustomerByUsername(loggedInUser.getUsername());
		Cart cart = customer.getCart();
		Product product = productService.getProductById(productId);
		List<CartItem> items = cart.getCartItems();
		boolean produtExists =false;
		for(CartItem item : items){
			if(product.getId()==item.getProduct().getId()){
				item.setQuantity(item.getQuantity()+1);
				item.setTotalAmount(product.getProductPrice()*item.getQuantity());
				cartService.addCartItem(item);
				produtExists = true;
			}
		}
		
		if(!produtExists){
			//add new product to the cart
			CartItem cartItem = new CartItem();
			cartItem.setProduct(product);
			cartItem.setQuantity(1);
			cartItem.setTotalAmount(product.getProductPrice());
			cartItem.setCart(cart);
			cartService.addCartItem(cartItem);
		}
		model.addAttribute("productAdd","success");
		return "redirect:/products/viewProduct/"+productId;
	}
	
	
	@RequestMapping(value="/remove/{productId}/{cartId}")
	public String removeCartItem(@PathVariable(value="productId") int productId,
			@PathVariable(value="cartId") int cartId){
		CartItem cartItem = cartService.getCartItemByProductId(productId);
		cartService.removeCartItem(cartItem);
		return "redirect:/mvc/cart/"+cartId;
	}
	
	@RequestMapping(value="/clear/{cartId}")
	public String clearCart(@PathVariable(value="cartId") int cartId){
		
		Cart cart = cartService.getCartById(cartId);
		cartService.removeAllCartItems(cart);
		return "redirect:/mvc/cart/"+cartId;
	}
	
	
}
